package com.api.EventHub.controller;

import com.api.EventHub.model.dto.EventDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = "Event Controller")
public interface EventControllerApi {

    @Operation(
            summary = "Retrieve all events",
            description = "Retrieve all events present in the database",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "All events retrieved",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    ResponseEntity<List<EventDto>> getAllEvents();

    @Operation(
            summary = "Retrieve event by ID",
            description = "Retrieve a specific event by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Event retrieved successfully",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Event not found"
                    )
            }
    )
    ResponseEntity<EventDto> getEventById(@PathVariable Long id);

    @Operation(
            summary = "Create a new event",
            description = "Create a new event and return the created event",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Event created successfully",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto);

    @Operation(
            summary = "Update an event",
            description = "Update the details of an existing event by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Event updated successfully",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Event not found"
                    )
            }
    )
    ResponseEntity<EventDto> updateEvent(@PathVariable Long id, @RequestBody EventDto eventDto);

    @Operation(
            summary = "Delete an event",
            description = "Delete an existing event by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Event deleted successfully",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Event not found"
                    )
            }
    )
    ResponseEntity<EventDto> deleteEvent(@PathVariable Long id);

    @Operation(
            summary = "Retrieve events by type",
            description = "Retrieve all events of a specific type",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Events retrieved successfully",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Invalid event type"
                    )
            }
    )
    ResponseEntity<List<EventDto>> getEventsByType(@RequestParam String type);

    @Operation(
            summary = "Change event status",
            description = "Change the status of a specific event by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Event status updated successfully",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Invalid status or event not found"
                    )
            }
    )
    ResponseEntity<EventDto> changeEventStatus(@PathVariable Long id, @RequestParam String status);
}
