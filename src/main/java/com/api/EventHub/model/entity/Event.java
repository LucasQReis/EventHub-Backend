package com.api.EventHub.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    private Long version;

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

    @Column(name = "IE_STATUS")
    private String status;

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

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
        this.atualizationDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.atualizationDate = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getAtualizationDate() {
        return atualizationDate;
    }

    public void setAtualizationDate(Date atualizationDate) {
        this.atualizationDate = atualizationDate;
    }
}
