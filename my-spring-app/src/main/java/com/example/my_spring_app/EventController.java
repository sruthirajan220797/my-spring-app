package com.example.my_spring_app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> subscribe(@RequestBody Subscription subscription) {
        Subscription createdSubscription = eventService.subscribe(subscription);
        return ResponseEntity.ok(createdSubscription);
    }

    @GetMapping("/events/{userId}")
    public ResponseEntity<List<Event>> getUserEvents(@PathVariable Long userId) {
        List<Event> events = eventService.getUserEvents(userId);
        return ResponseEntity.ok(events);
    }
}
