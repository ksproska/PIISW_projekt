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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private Date clipTime;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Concession concession;

    @ManyToOne
    private User owner;
}
