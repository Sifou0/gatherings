package com.learning.crud.event.repository;

import com.learning.crud.event.model.Event;
import com.learning.crud.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAllEventsByOrganizer(User organizer);
}
