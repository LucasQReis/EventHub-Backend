package com.api.EventHub.service;

import com.api.EventHub.model.dto.EventDto;
import com.api.EventHub.model.entity.Event;
import com.api.EventHub.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventDto getEventById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return modelMapper.map(event, EventDto.class);
    }

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);
        Event savedEvent = eventRepository.save(event);
        return modelMapper.map(savedEvent, EventDto.class);
    }

    @Override
    public EventDto updateEvent(Long eventId, EventDto eventDto) {
        Event existingEvent = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event ID " + eventId + " not found!"));

        Event updatedEvent = this.updatedEvent(existingEvent, eventDto);
        eventRepository.save(updatedEvent);

        return modelMapper.map(updatedEvent, EventDto.class);
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            eventRepository.delete(event);
            return modelMapper.map(event, EventDto.class);
        } else {
            return null;
        }
    }

    private Event updatedEvent(Event event, EventDto eventDto) {
        event.setName(eventDto.getName());
        event.setDescription(eventDto.getDescription());
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setLocation(eventDto.getLocation());
        event.setCity(eventDto.getCity());
        event.setState(eventDto.getState());
        event.setCountry(eventDto.getCountry());
        event.setTotalCapacity(eventDto.getTotalCapacity());
        event.setStatus(eventDto.getStatus());
        event.setEventType(eventDto.getEventType());
        event.setImageUrl(eventDto.getImageUrl());

        return event;
    }
}
