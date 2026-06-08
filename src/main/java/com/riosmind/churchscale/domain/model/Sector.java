package com.riosmind.churchscale.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Sector {

    private String name;
    private List<Volunteer> volunteers;

    public Sector(String louvor) {
        this.volunteers = new ArrayList<>();
    }

    public Sector(String name, List<Volunteer> volunteers) {
        this.name = name;
        this.volunteers = volunteers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }
}
