package com.accenture.roadmap.movies.model;

public class MovieForm {

    private Long id;
    private String name;
    private double length;

    public MovieForm(Long id, String name, double length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
