package com.blxdev.greatseller.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private boolean available;

    @CreationTimestamp
    private LocalDateTime registerdate;

    @ManyToOne
    @JoinColumn(name="idmaker")
    private Maker maker;

    @ManyToOne
    @JoinColumn(name="idlocation")
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
