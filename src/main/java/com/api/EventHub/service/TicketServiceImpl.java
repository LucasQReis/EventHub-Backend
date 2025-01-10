package com.api.EventHub.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.api.EventHub.model.dto.TicketDto;
import com.api.EventHub.model.entity.Event;
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
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null) {
            ticketRepository.delete(ticket);
            return modelMapper.map(ticket, TicketDto.class);
        } else {
            return null;
        }
    }

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {

        Event event = eventRepository.findById(ticketDto.getEventId())
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado com o ID fornecido."));

        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);

        ticket.setEvent(event);

        ticket.setStatus("PENDING");
        ticket.setQrCode(UUID.randomUUID().toString());

        Ticket savedTicket = ticketRepository.save(ticket);

        return modelMapper.map(savedTicket, TicketDto.class);
    }

    @Override
    public TicketDto updateTicket(Long ticketId, TicketDto ticketDto) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null) {
            ticket.setParticipantEmail(ticketDto.getParticipantEmail()); // Campo E-mail que será alterado
            ticket.setParticipantName(ticketDto.getParticipantName()); // Campo Nome que será alterado

            ticketRepository.save(ticket); // Salva as alterações

            return modelMapper.map(ticket, TicketDto.class);
        } else {
            return null;
        }
    }

}
