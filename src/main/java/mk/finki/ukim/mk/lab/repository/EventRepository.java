package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventRepository {
    private List<Event> events= new ArrayList<>();

    public EventRepository(List<Event> events) {
        events = new ArrayList<>();

        events.add(new Event("Event 1", "Description 1", 4.5));
        events.add(new Event("Event 2", "Description 2", 3.7));
        events.add(new Event("Event 3", "Description 3", 6.5));
        events.add(new Event("Event 4", "Description 4", 3.2));
        events.add(new Event("Event 5", "Description 5", 5.4));
        events.add(new Event("Event 6", "Description 6", 5.7));
        events.add(new Event("Event 7", "Description 7", 4.0));
        events.add(new Event("Event 8", "Description 8", 3.7));
        events.add(new Event("Event 9", "Description 9", 4.8));
        events.add(new Event("Event 10", "Description 10", 9.7));

    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> findAll() {
        return events;
    }

    public List<Event> searchEvents(String text){
        return events.stream().filter(event -> event.getName().contains(text)||event.getDescription().contains(text)).collect(Collectors.toList());//ovde
    }
}
