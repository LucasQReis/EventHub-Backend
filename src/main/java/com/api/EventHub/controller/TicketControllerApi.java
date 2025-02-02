package com.api.EventHub.controller;

import com.api.EventHub.model.dto.TicketDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TicketControllerApi {

    @Operation(
            summary = "Get all tickets",
            description = "Retrieves all tickets available in the database.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of tickets successfully retrieved",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TicketDto.class)))
            }
    )
    ResponseEntity<List<TicketDto>> getAllTickets();

    @Operation(
            summary = "Get ticket by ID",
            description = "Retrieves information of a specific ticket by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ticket successfully retrieved",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TicketDto.class))),
                    @ApiResponse(responseCode = "404", description = "Ticket not found")
            }
    )
    ResponseEntity<TicketDto> getTicketById(@PathVariable Long id);

    @Operation(
            summary = "Create a new ticket",
            description = "Creates a new ticket based on the data provided in the request body.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ticket successfully created",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TicketDto.class))),
                    @ApiResponse(responseCode = "404", description = "Failed to create ticket")
            }
    )
    ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto);

    @Operation(
            summary = "Delete a ticket",
            description = "Deletes a specific ticket by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ticket successfully deleted",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TicketDto.class))),
                    @ApiResponse(responseCode = "404", description = "Ticket not found")
            }
    )
    ResponseEntity<TicketDto> deleteTicket(@PathVariable Long id);

    @Operation(
            summary = "Update a ticket",
            description = "Updates the information of a specific ticket by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ticket successfully updated",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TicketDto.class))),
                    @ApiResponse(responseCode = "404", description = "Ticket not found")
            }
    )
    ResponseEntity<TicketDto> updateTicket(@PathVariable Long id, @RequestParam String email,
                                           @RequestParam String name);
}
