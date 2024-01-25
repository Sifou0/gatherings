package com.learning.crud.event.controller;

import com.learning.crud.event.model.Event;
import com.learning.crud.event.repository.EventRepository;
import com.learning.crud.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;
    @GetMapping("/events")
    ResponseEntity<List<Event>> getAllEvents() {
        try {
            List<Event> events = new ArrayList<>(eventRepository.findAll());
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/events/organizer")
    public ResponseEntity<List<Event>> getAllEventsByOrganizer(@RequestBody User organizer) {
        Optional<List<Event>> events = Optional.ofNullable(eventRepository.findAllEventsByOrganizer(organizer));
        return events.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        try {
            System.out.println(event);
            Event _event = eventRepository.save(new Event(event.getTitle(),event.getDateTime(),event.getOrganizer(),event.getGuests()));
            return new ResponseEntity<>(_event,HttpStatus.CREATED);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/event/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") long id, @RequestBody Event event) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if(eventOptional.isPresent()) {
            Event _event = eventOptional.get();
            _event.setTitle(event.getTitle());
            _event.setDateTime(event.getDateTime());
            _event.setOrganizer(event.getOrganizer());
            _event.setGuests(event.getGuests());
            return new ResponseEntity<>(eventRepository.save(_event),HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") long id) {
        try {
            eventRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
