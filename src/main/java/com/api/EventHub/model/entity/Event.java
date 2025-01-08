package com.api.EventHub.model.entity;

import com.api.EventHub.model.enums.EventStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NM_NAME")
    private String name;

    @Column(name = "DS_DESCRIPTION")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_START")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_END")
    private Date endDate;

    @Column(name = "NM_LOCATION")
    private String location;

    @Column(name = "NM_CITY")
    private String city;

    @Column(name = "NM_STATE")
    private String state;

    @Column(name = "NM_COUNTRY")
    private String country;

    @Column(name = "NR_TOTAL_CAPACITY")
    private int totalCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "IE_STATUS")
    private EventStatusEnum status;

    @Column(name = "DS_EVENT_TYPE")
    private String eventType;

    @Column(name = "DS_IMAGE")
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CREATION")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ATUALIZATION")
    private Date atualizationDate;

    // TODO FK Column for reference to the organizing user

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
        this.atualizationDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.atualizationDate = new Date();
    }
}
