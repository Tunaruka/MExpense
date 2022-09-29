package com.example.mexpense.data;

public class TripEntity {
    private int id;
    private String title;
    private String destination;
    private String type;
    private String date;
    private int risk;
    private String description;

    public TripEntity(int id, String title, String destination, String type, String date, int risk, String description) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.type = type;
        this.date = date;
        this.risk = risk;
        this.description = description;
    }

    public TripEntity(String title, String destination, String type, String date, int risk, String description) {
        this.title = title;
        this.destination = destination;
        this.type = type;
        this.date = date;
        this.risk = risk;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
