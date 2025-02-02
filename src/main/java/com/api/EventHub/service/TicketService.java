package com.api.EventHub.service;

import java.util.List;

import com.api.EventHub.model.dto.TicketDto;

public interface TicketService {
        // get all Tickets
    public List<TicketDto> getAllTickets();
    // get ticket by id
    public TicketDto getTicketById(Long id);
    // create a new ticket
    public TicketDto createTicket(TicketDto ticketDto);
    // update ticket
    public TicketDto updateTicket(Long ticketId, String email, String name);
    // delete ticket
    public TicketDto deleteTicket(Long ticketId);
}
