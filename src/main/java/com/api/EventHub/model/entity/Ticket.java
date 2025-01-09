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

    @PrePersist
    protected void onCreate() {
        this.purchaseDate = new Date();
    }
}
