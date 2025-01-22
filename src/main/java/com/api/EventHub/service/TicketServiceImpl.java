package com.api.EventHub.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.api.EventHub.model.entity.Event;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;

import com.api.EventHub.model.dto.TicketDto;
import com.api.EventHub.model.entity.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.EventHub.repository.EventRepository;
import com.api.EventHub.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(ticket -> modelMapper.map(ticket, TicketDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto getTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return modelMapper.map(ticket, TicketDto.class);
    }

    @Override
    public TicketDto deleteTicket(Long ticketId) {
        Optional<Ticket> ticketDeleted = ticketRepository.findById(ticketId);
        ticketDeleted.ifPresent(value -> ticketRepository.delete(ticketDeleted.get()));
        return modelMapper.map(ticketDeleted, TicketDto.class);
    }

    @Override
    @Transactional
    public TicketDto createTicket(TicketDto ticketDto) {
        return eventRepository.findById(ticketDto.getEventId())
                .map(event -> {
                    Ticket ticket = this.getTicketFromTicketDto(ticketDto, event);
                    entityManager.persist(ticket);
                    entityManager.flush();

                    return modelMapper.map(ticket, TicketDto.class);
                })
                .orElseThrow(() -> new EntityNotFoundException("Event not found with ID: " + ticketDto.getEventId()));
    }

    @Override
    public TicketDto updateTicket(Long ticketId, TicketDto ticketDto) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent()) {
            ticket.get().setParticipantEmail(ticketDto.getParticipantEmail());
            ticket.get().setParticipantName(ticketDto.getParticipantName());

            ticketRepository.save(ticket.get());

            return modelMapper.map(ticket, TicketDto.class);
        } else {
            return null;
        }
    }

    private Ticket getTicketFromTicketDto(TicketDto ticketDto, Event event) {
        Ticket ticket = new Ticket();
        ticket.setEventId(event);
        ticket.setParticipantName(ticketDto.getParticipantName());
        ticket.setParticipantEmail(ticketDto.getParticipantEmail());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setTicketType(ticketDto.getTicketType());
        ticket.setStatus(ticketDto.getStatus());
        ticket.setSeatNumber(ticketDto.getSeatNumber());
        ticket.setQrCode(UUID.randomUUID().toString());
        ticket.setQuantity(ticketDto.getQuantity());
        return ticket;
    }
}
