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
    public void updateEvent(Long eventId, EventDto eventDto) {

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
}
