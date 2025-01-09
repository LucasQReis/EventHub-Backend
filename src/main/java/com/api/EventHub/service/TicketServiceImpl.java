package com.api.EventHub.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.api.EventHub.model.dto.TicketDto;
import com.api.EventHub.model.entity.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.EventHub.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

     @Autowired
    private TicketRepository ticketRepository;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTicket'");
    }

    @Override
    public void updateTicket(Long ticketId, TicketDto ticketDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTicket'");
    }
}
