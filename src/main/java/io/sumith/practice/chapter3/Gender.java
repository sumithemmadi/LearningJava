package io.sumith.practice.chapter3;

public enum Gender {
    MALE("M"), FEMALE("F"), OTHER("O"), UNKNOWN("U");

    private final String shortId;

    Gender(String shortId) {
        this.shortId = shortId;
    }

    public String getShortId() {
        return shortId;
    }
}
