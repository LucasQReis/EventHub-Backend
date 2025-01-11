package com.api.EventHub.model.enums;

public enum EventTypeEnum {
    SOCIAL_EVENT("Social"),
    CORPORATE_EVENT("Corporate"),
    ACADEMIC_EVENT("Academic"),
    SPORT_EVENT("Sport"),
    FESTIVAL_EVENT("Festival");

    private final String description;

    EventTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EventTypeEnum fromString(String value) {
        for (EventTypeEnum status : values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid state: " + value);
    }
}
