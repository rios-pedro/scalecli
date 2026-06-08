package com.riosmind.churchscale.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Scale {

    private String name;
    private LocalDate date;
    private Map<Sector, List<Volunteer>> allocations;

    public Scale(){
    }

    public Scale(String name, LocalDate date, Map<Sector, List<Volunteer>> allocations) {
        this.name = name;
        this.date = date;
        this.allocations = allocations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<Sector, List<Volunteer>> getAllocations() {
        return allocations;
    }

    public void setAllocations(Map<Sector, List<Volunteer>> allocations) {
        this.allocations = allocations;
    }
}
