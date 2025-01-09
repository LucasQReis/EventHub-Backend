package com.api.EventHub.controller;


import com.api.EventHub.model.dto.TicketDto;
import com.api.EventHub.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    // Get all tickets
    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        List<TicketDto> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    // Get ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable Long id) {
        TicketDto ticketDto = ticketService.getTicketById(id);
         return ResponseEntity.ok(ticketDto);
    }

    // Create a new ticket
    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        TicketDto createdTicket = ticketService.createTicket(ticketDto);
        return ResponseEntity.ok(createdTicket);
    }

    // Delete ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<TicketDto> deleteTicket(@PathVariable Long id) {
        TicketDto deletedTicket = ticketService.deleteTicket(id);
        if (deletedTicket != null) {
            return ResponseEntity.ok(deletedTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
