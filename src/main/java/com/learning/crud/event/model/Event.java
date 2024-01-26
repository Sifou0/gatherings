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
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    private User organizer;

    @OneToMany
    @JoinTable(
            name = "events_guests",
            joinColumns = @JoinColumn(name = "guests_id"),
            inverseJoinColumns = @JoinColumn(name = "events_id")
    )
    private List<User> guests = new ArrayList<>();

    public Event(String title, LocalDateTime dateTime, Position position,User organizer, List<User> guests) {
        this.title = title;
        this.dateTime = dateTime;
        this.position = position;
        this.organizer = organizer;
        this.guests = guests;
    }
}
