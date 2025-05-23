package com.example.demo_mongo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OrganizerRepository {

    private final List<Organizer> organizers = List.of(
        new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
        new Organizer(10, "Carved Rock", "Carved Rock Sports Equipment")
    );

    public List<Organizer> findAll(){
        return organizers;
    }

}
