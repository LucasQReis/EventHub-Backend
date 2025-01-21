package com.api.EventHub.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.api.EventHub.model.enums.TicketStatusEnum;
import org.modelmapper.ModelMapper;

import com.api.EventHub.model.dto.TicketDto;
import com.api.EventHub.model.entity.Event;
import com.api.EventHub.model.entity.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.EventHub.repository.EventRepository;
import com.api.EventHub.repository.TicketRepository;

import javax.swing.text.html.Option;

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

    //TODO - TESTAR
    @Override
    public TicketDto deleteTicket(Long ticketId) {
        Optional<Ticket> ticketDeleted = ticketRepository.findById(ticketId);
        ticketDeleted.ifPresent(value -> ticketRepository.delete(ticketDeleted.get()));
        return modelMapper.map(ticketDeleted, TicketDto.class);
    }

    //TODO - TESTAR
    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Optional<Event> event = eventRepository.findById(ticketDto.getEventId());

        if (event.isPresent()) {
            Ticket ticket = modelMapper.map(ticketDto, Ticket.class);

            ticket.setEvent(event.get());
            ticket.setStatus(TicketStatusEnum.PENDING.getDescription());
            ticket.setQrCode(UUID.randomUUID().toString());
            Ticket savedTicket = ticketRepository.save(ticket);

            return modelMapper.map(savedTicket, TicketDto.class);
        } else {
            return null;
        }
    }

    //TODO - TESTAR
    @Override
    public TicketDto updateTicket(Long ticketId, TicketDto ticketDto) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent()) {
            ticket.get().setParticipantEmail(ticketDto.getParticipantEmail());
            ticket.get().setParticipantName(ticketDto.getParticipantName());

            ticketRepository.save(ticket.get()); // Save changes

            return modelMapper.map(ticket, TicketDto.class);
        } else {
            return null;
        }
    }
}
