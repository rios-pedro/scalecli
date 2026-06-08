package com.riosmind.churchscale.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Setlist {

    private LocalDate date;
    private List<Music>  musics;
    private Volunteer responsible;

    public Setlist() {
        this.musics = new ArrayList<>();
    }

    public Setlist(LocalDate date, List<Music> musics, Volunteer responsible) {
        this.date = date;
        this.musics = musics;
        this.responsible = responsible;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public Volunteer getResponsible() {
        return responsible;
    }

    public void setResponsible(Volunteer responsible) {
        this.responsible = responsible;
    }
}
