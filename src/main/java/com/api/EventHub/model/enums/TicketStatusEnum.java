package com.api.EventHub.model.enums;

public enum TicketStatusEnum {
    PENDING("Pending"),
    CANCELED("Canceled"),
    COMPLETED("Completed");

    private final String description;

    TicketStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static TicketStatusEnum fromString(String value) {
        for (TicketStatusEnum status : values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid state: " + value);
    }
}
