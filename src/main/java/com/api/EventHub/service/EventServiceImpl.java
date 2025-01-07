package com.api.EventHub.service;

import com.api.EventHub.model.dto.EventDto;
import com.api.EventHub.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventDto> getAllEvents() {
        return List.of();
    }

    @Override
    public EventDto getEventById(EventDto eventDto) {
        return null;
    }

    @Override
    public EventDto createEvent(EventDto eventDto) {
        return null;
    }

    @Override
    public void updateEvent(Long eventId, EventDto eventDto) {

    }

    @Override
    public void deleteEvent(Long eventId) {

    }
}
