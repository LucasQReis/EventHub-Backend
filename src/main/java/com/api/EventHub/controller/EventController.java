package com.api.EventHub.controller;

import com.api.EventHub.model.dto.EventDto;
import com.api.EventHub.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    // get all events
    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    // get event by id
    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long id) {
        EventDto eventDto = eventService.getEventById(id);
        return ResponseEntity.ok(eventDto);
    }

    // create a new event
    @PostMapping
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        EventDto createdEvent = eventService.createEvent(eventDto);
        return ResponseEntity.ok(createdEvent);
    }

    // update event

    // delete event
    @DeleteMapping("/{id}")
    public ResponseEntity<EventDto> deleteEvent(@PathVariable Long id) {
        EventDto deletedEvent = eventService.deleteEvent(id);
        if (deletedEvent != null) {
            return ResponseEntity.ok(deletedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // search event by filter

    // change event status

    // list all events participants

    // create a review of the given event
}
