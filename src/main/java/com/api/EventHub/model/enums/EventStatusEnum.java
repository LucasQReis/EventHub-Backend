package com.api.EventHub.model.enums;

public enum EventStatusEnum {
    SCHEDULED("Scheduled"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed");

    private final String description;

    EventStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EventStatusEnum fromString(String value) {
        for (EventStatusEnum status : values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid state: " + value);
    }
}

