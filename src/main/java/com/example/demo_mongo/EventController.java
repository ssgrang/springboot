package com.example.demo_mongo;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private final OrganizerRepository organizerRepository;
    private final VenueRepository venueRepository;

    public EventController(OrganizerRepository organizerRepository,
                            VenueRepository venueRepository) {
        this.organizerRepository = organizerRepository;
        this.venueRepository = venueRepository;

        }

    @GetMapping(path = "/organizers")
    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }

    @GetMapping(path = "/venue/{id}")
    public Venue getVenue(@PathVariable("id") int venueID){
        return venueRepository.findById(venueID)
            .orElseThrow(() -> new NoSuchElementException("Venue with id "+ venueID + " not found"));
    }

}
