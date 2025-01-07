package com.api.EventHub.service;

import com.api.EventHub.model.dto.EventDto;

import java.util.List;

public interface EventService {
    // get all events
    public List<EventDto> getAllEvents();
    // get event by id
    public EventDto getEventById(EventDto eventDto);
    // create a new event
    public EventDto createEvent(EventDto eventDto);
    // update event
    public void updateEvent(Long eventId, EventDto eventDto);
    // delete event
    public void deleteEvent(Long eventId);

    // search event by filter
    // change event status
    // list all events participants
    // create a review of the given event
}
