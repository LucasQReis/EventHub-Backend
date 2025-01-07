package com.api.EventHub.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}
