package domain.service;

import domain.exception.DuplicateMusicException;
import domain.model.Music;
import domain.model.Setlist;
import domain.model.Volunteer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SetlistService {

    public Setlist createSetlist(LocalDate date, Volunteer responsible){
            Setlist setlist = new Setlist(date, new ArrayList<>(), responsible);
            return setlist;
    }

    public void addMusic(Setlist setlist, Music music) {
        boolean alreadyExists = setlist.getMusics().stream()
                .anyMatch(m -> m.getTitle().equalsIgnoreCase(music.getTitle()));

        if (alreadyExists) {
            throw new DuplicateMusicException(music.getTitle());
        }

        setlist.getMusics().add(music);
    }

    public void removeMusic(Setlist setlist, Music music) {
        setlist.getMusics().remove(music);
    }

    public void reorderMusics(Setlist setlist, List<Music> newOrder) {
        setlist.getMusics().clear();
        setlist.getMusics().addAll(newOrder);
    }
}
