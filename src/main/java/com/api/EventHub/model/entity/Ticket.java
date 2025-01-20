package com.api.EventHub.model.entity;

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
@Entity(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TICKET")
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "EVENT_ID", nullable = false) // FK para Event
    private Event event;

    @Column(name = "NM_PARTICIPANT")
    private String participantName;

    @Column(name = "DS_EMAIL")
    private String participantEmail;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_PURCHASE")
    private Date purchaseDate;

    @Column(name = "NR_PRICE")
    private double price;

    @Column(name = "DS_TYPE")
    private String ticketType;

    @Column(name = "IE_STATUS")
    private String status;

    @Column(name = "NR_SEAT")
    private String seatNumber;

    @Column(name = "DS_QR_CODE")
    private String qrCode;

    @Column(name = "NR_QUANTITY")
    private int quantity;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @PrePersist
    protected void onCreate() {
        this.purchaseDate = new Date();
    }
}
