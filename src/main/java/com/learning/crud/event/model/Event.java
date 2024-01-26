package com.learning.crud.event.model;

import com.learning.crud.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "events")
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    private User organizer;

    @OneToMany(fetch = FetchType.LAZY)
    private List<User> guests = new ArrayList<>();

    public Event(String title, LocalDateTime dateTime, User organizer, List<User> guests) {
        this.title = title;
        this.dateTime = dateTime;
        this.organizer = organizer;
        this.guests = guests;
    }
}
