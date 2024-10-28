package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);

    List<Event> searchByScore(double searchScore);

    List<Event> searchByNameAndScore(String searchText, double searchScore);
}
