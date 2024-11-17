package com.example.my_spring_app;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final SubscriptionRepository subscriptionRepository;
    public EventService(EventRepository eventRepository, SubscriptionRepository subscriptionRepository) {
        this.eventRepository = eventRepository;
        this.subscriptionRepository = subscriptionRepository;
    }
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Subscription subscribe(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Event> getUserEvents(Long userId) {
        List<Subscription> subscriptions = subscriptionRepository.findByUserId(userId);
        List<String> eventTypes = subscriptions.stream()
                .map(Subscription::getEventType)
                .collect(Collectors.toList());
        return eventRepository.findByTypeInOrderByTimestampDesc(eventTypes);
    }
}
