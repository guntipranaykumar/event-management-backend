package com.event.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.event.demo.entity.Event;
import com.event.demo.entity.Sponsor;
import com.event.demo.service.EventJpaService;
import com.event.demo.service.SponsorJpaService;

@CrossOrigin(origins = "https://d2cujn41htmykc.cloudfront.net")
@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventJpaService eventService;
    private final SponsorJpaService sponsorService;

    public EventController(EventJpaService eventService,
                           SponsorJpaService sponsorService) {
        this.eventService = eventService;
        this.sponsorService = sponsorService;
    }

    // GET /api/events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // GET /api/events/{eventId}
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable int eventId) {
        return eventService.getEventById(eventId);
    }

    // POST /api/events
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // PUT /api/events/{eventId}
    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable int eventId,
                             @RequestBody Event event) {
        return eventService.updateEvent(eventId, event);
    }

    // DELETE /api/events/{eventId}
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable int eventId) {
        eventService.deleteEvent(eventId);
    }

    // GET /api/events/{eventId}/sponsors
    @GetMapping("/{eventId}/sponsors")
    public List<Sponsor> getSponsorsByEvent(@PathVariable int eventId) {
        return eventService.getSponsorsByEvent(eventId);
    }
}