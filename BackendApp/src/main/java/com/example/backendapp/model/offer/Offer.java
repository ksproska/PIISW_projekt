package com.example.backendapp.model.offer;

import com.example.backendapp.model.common.Concession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "offers")
public abstract class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "offer_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Concession concession;

    private Double price;
}
