package com.api.EventHub.service;

import com.api.EventHub.model.dto.EventDto;

import java.util.List;

public interface EventService {
    // get all events
    public List<EventDto> getAllEvents();
    // get event by id
    public EventDto getEventById(Long id);
    // create a new event
    public EventDto createEvent(EventDto eventDto);
    // update event
    public EventDto updateEvent(Long eventId, EventDto eventDto);
    // delete event
    public EventDto deleteEvent(Long eventId);
    // search event by type filter
    public List<EventDto> getEventsByType(String type);
    // change event status
    public EventDto changeEventStatus(Long eventId, String status);
}
