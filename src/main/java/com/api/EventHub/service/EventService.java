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
    public void updateEvent(Long eventId, EventDto eventDto);
    // delete event
    public EventDto deleteEvent(Long eventId);

    // TODO search event by filter
    // TODO change event status
    // TODO list all events participants
    // TODO create a review of the given event
}
