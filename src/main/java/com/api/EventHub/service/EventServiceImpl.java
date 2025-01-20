package com.api.EventHub.service;

import com.api.EventHub.model.dto.EventDto;
import com.api.EventHub.model.entity.Event;
import com.api.EventHub.repository.EventRepository;
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

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }


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
        Optional<Event> event = eventRepository.findById(eventId);
        event.ifPresent(value -> eventRepository.save(this.updatedEvent(value, eventDto)));
        return modelMapper.map(event, EventDto.class);
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        event.ifPresent(value -> eventRepository.delete(value));
        return modelMapper.map(event, EventDto.class);
    }

    @Override
    public List<EventDto> getEventsByType(String type) {
        List<Event> events = eventRepository.findEventsByType(type);
        return events.stream()
                .map(event -> modelMapper.map(event, EventDto.class))
                .toList();
    }

    @Override
    public EventDto changeEventStatus(Long eventId, String status) {
        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isPresent()) {
            event.get().setStatus(status);
            eventRepository.save(event.get());
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
