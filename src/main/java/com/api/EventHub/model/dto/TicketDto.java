package com.api.EventHub.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TicketDto {

    @JsonProperty("eventId")
    private Long eventId;

    @JsonProperty("eventName")
    private String eventName;

    @JsonProperty("participantName")
    private String participantName;

    @JsonProperty("participantEmail")
    private String participantEmail;

    @JsonProperty("purchaseDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date purchaseDate;

    @JsonProperty("price")
    private double price;

    @JsonProperty("ticketType")
    private String ticketType;

    @JsonProperty("status")
    private String status;

    @JsonProperty("seatNumber")
    private String seatNumber;

    @JsonProperty("quantity")
    private int quantity;

    // Getters e Setters
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}