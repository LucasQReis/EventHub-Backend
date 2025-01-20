package com.api.EventHub.controller;

import com.api.EventHub.model.dto.EventDto;
import com.api.EventHub.model.enums.EventStatusEnum;
import com.api.EventHub.model.enums.EventTypeEnum;
import com.api.EventHub.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController implements EventControllerApi {

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
        Optional<EventDto> updatedEvent = Optional.ofNullable(eventService.updateEvent(id, eventDto));
        return updatedEvent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // delete event
    @DeleteMapping("/{id}")
    public ResponseEntity<EventDto> deleteEvent(@PathVariable Long id) {
        Optional<EventDto> deletedEvent = Optional.ofNullable(eventService.deleteEvent(id));
        return deletedEvent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // search all events by typo
    @GetMapping("/type")
    public ResponseEntity<List<EventDto>> getEventsByType(@RequestParam String type) {
        boolean isValidType = Arrays.stream(EventTypeEnum.values())
                .anyMatch(eventTypeEnum -> eventTypeEnum.getDescription().equals(type));

        if (isValidType) {
            List<EventDto> events = eventService.getEventsByType(type);
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // change event status
    @PutMapping("/status/{id}")
    public ResponseEntity<EventDto> changeEventStatus(@PathVariable Long id,
                                                      @RequestParam String status) {
        boolean isValidStatus = Arrays.stream(EventStatusEnum.values())
                .anyMatch(enumValue -> enumValue.getDescription().equals(status));

        if (isValidStatus) {
            EventDto updatedEvent = eventService.changeEventStatus(id, status);
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
