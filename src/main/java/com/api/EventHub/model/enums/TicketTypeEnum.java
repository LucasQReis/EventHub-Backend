package com.api.EventHub.model.enums;

public enum TicketTypeEnum {
    VIP("VIP"),
    REGULAR("Regular"),
    PROMOTIONAL("Promotional");

    private final String description;

    TicketTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static TicketTypeEnum fromString(String value) {
        for (TicketTypeEnum type : values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid state: " + value);
    }
}
