package com.api.EventHub.controller;

import com.api.EventHub.model.dto.EventDto;
import com.api.EventHub.model.enums.EventStatusEnum;
import com.api.EventHub.model.enums.EventTypeEnum;
import com.api.EventHub.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Long id,
                                                @RequestBody EventDto eventDto) {
        EventDto eve = eventService.updateEvent(id, eventDto);
        if (eve != null) {
            return ResponseEntity.ok(eve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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

    // search all events by typo
    @GetMapping("/type")
    public ResponseEntity<List<EventDto>> getEventsByType(@RequestParam String type) {
        List<EventDto> events = new ArrayList<>();

        if (Arrays.stream(EventTypeEnum.values())
                .anyMatch(eventTypeEnum -> eventTypeEnum.getDescription().equals(type))) {
            events = eventService.getEventsByType(type);
        }

        return ResponseEntity.ok(events);
    }

    // change event status
    @PutMapping("/status/{id}")
    public ResponseEntity<EventDto> changeEventStatus(@PathVariable Long id,
                                                      @RequestParam String status) {
        if (Arrays.stream(EventStatusEnum.values())
                .anyMatch(enumValue -> enumValue.getDescription().equals(status))) {
            EventDto eventDto = eventService.changeEventStatus(id, status);
            return ResponseEntity.ok(eventDto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
