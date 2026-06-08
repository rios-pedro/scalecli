package com.riosmind.churchscale.domain.model;

import java.time.LocalDate;
import java.util.Set;

public class Volunteer {

    private String name;
    private String email;
    private Set<Sector> sectors;
    private LocalDate availableDate;

    public Volunteer(){

    }

    public Volunteer(String name, String email, Set<Sector> sectors, LocalDate availableDate) {
        this.name = name;
        this.email = email;
        this.sectors = sectors;
        this.availableDate = availableDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
}
