package com.api.EventHub.controller;

import com.api.EventHub.model.dto.TicketDto;
import com.api.EventHub.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController implements TicketControllerApi {

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
        Optional<TicketDto> tickedCreated = Optional.ofNullable(ticketService.createTicket(ticketDto));
        return tickedCreated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<TicketDto> deleteTicket(@PathVariable Long id) {
        Optional<TicketDto> deletedTicket = Optional.ofNullable(ticketService.deleteTicket(id));
        return deletedTicket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Ticket
    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(
            @PathVariable Long id,
            @RequestBody TicketDto ticketDto) {
        Optional<TicketDto> ticketUpdated = Optional.ofNullable(ticketService.updateTicket(id, ticketDto));
        return ticketUpdated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
