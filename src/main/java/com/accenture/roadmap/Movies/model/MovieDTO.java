package com.accenture.roadmap.Movies.model;

public class MovieDTO {

    private long id;
    private String name;
    private double length;
    private double average;
    public MovieDTO(long id, String name, double length, double average) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.average = average;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

}
