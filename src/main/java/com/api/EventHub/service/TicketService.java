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
    public void updateTicket(Long ticketId, TicketDto ticketDto);
    // delete ticket
    public TicketDto deleteTicket(Long ticketId);

    // TODO search event by filter
    // TODO change event status
    // TODO list all events participants
    // TODO create a review of the given event
}
