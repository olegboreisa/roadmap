package com.accenture.roadmap.Movies.model;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private double length;
    private int totalRate = 0;
    private int totalVotes = 0;
    private double averageRate = 0;

    public MovieEntity() {
    }

    public MovieEntity(Long id, String name, double length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public MovieEntity(Long id, String name, double length, int totalRate, int totalVotes, double averageRate) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.totalRate = totalRate;
        this.totalVotes = totalVotes;
        this.averageRate = averageRate;
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

    public int getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(int totalRate) {
        this.totalRate = totalRate;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }
}
