package com.example.backendapp.model.ticket;

import com.example.backendapp.model.common.Concession;
import com.example.backendapp.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "tickets")
public abstract class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "ticket_id")
    private Long id;

    private Date clipTime;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Concession concession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;
}
