package com.api.EventHub.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TicketDto {

    @JsonProperty("id_ticket")
    private Long ticketId;

    @JsonProperty("event_id")
    private Long eventId;

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("nm_participant")
    private String participantName;

    @JsonProperty("ds_email")
    private String participantEmail;

    @JsonProperty("dt_purchase")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date purchaseDate;

    @JsonProperty("nr_price")
    private double price;

    @JsonProperty("ds_type")
    private String ticketType;

    @JsonProperty("ie_status")
    private String status;

    @JsonProperty("nr_seat")
    private String seatNumber;

    @JsonProperty("ds_qr_code")
    private String qrCode;

    @JsonProperty("nr_quantity")
    private int quantity;

    // Getters e Setters
}
