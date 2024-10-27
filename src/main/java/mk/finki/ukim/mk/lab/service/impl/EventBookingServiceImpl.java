package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {
    private EventRepository eventRepository;

    public EventBookingServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        Event event = eventRepository.findAll().stream().filter(e -> e.getName().equals(eventName)).findFirst().orElseThrow(() -> new IllegalArgumentException("Event not found"));


        return new EventBooking(eventName, attendeeName, attendeeAddress, (long) numberOfTickets);
    }
}
