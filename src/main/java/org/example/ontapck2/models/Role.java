package org.example.ontapck2.models;

public enum Role {
    ADMIN(0),
    STAFF(1),
    MANAGER(2),
    EXECUTIVE(3);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
