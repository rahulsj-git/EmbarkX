package com.example.ChallengeApp;

public class Challenge {

    private Long id;
    private String months;
    private String description;

    public Challenge(Long id, String months, String description) {
        this.id = id;
        this.months = months;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
