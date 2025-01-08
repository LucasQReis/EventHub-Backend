package com.api.EventHub.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EventDto {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("startDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date startDate;

    @JsonProperty("endDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date endDate;

    @JsonProperty("location")
    private String location;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("totalCapacity")
    private int totalCapacity;

    @JsonProperty("status")
    private String status;

    @JsonProperty("eventType")
    private String eventType;

    @JsonProperty("imageUrl")
    private String imageUrl;
}
