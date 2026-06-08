package com.riosmind.churchscale.domain.service;

import com.riosmind.churchscale.domain.exception.DuplicateMusicException;
import com.riosmind.churchscale.domain.model.Music;
import com.riosmind.churchscale.domain.model.Setlist;
import com.riosmind.churchscale.domain.model.Volunteer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetlistServiceTest {

    private domain.service.SetlistService setlistService;
    private Setlist setlist;
    private Music music1;
    private Music music2;

    @BeforeEach
    void setUp() {
        setlistService = new domain.service.SetlistService();
        Volunteer responsible = new Volunteer("Pedro", "pedro@email.com", new HashSet<>(), LocalDate.now());
        setlist = setlistService.createSetlist(LocalDate.now(), responsible);

        music1 = new Music("Oceans", "A", "https://link1.com");
        music2 = new Music("Way Maker", "G", "https://link2.com");
    }

    @Test
    void shouldAddMusicToSetlist() {
        setlistService.addMusic(setlist, music1);

        assertTrue(setlist.getMusics().contains(music1));
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateMusic() {
        setlistService.addMusic(setlist, music1);

        assertThrows(DuplicateMusicException.class, () ->
                setlistService.addMusic(setlist, music1)
        );
    }

    @Test
    void shouldThrowExceptionForDuplicateWithDifferentCase() {
        setlistService.addMusic(setlist, music1);
        Music duplicate = new Music("oceans", "A", "https://link1.com");

        assertThrows(DuplicateMusicException.class, () ->
                setlistService.addMusic(setlist, duplicate)
        );
    }

    @Test
    void shouldRemoveMusicFromSetlist() {
        setlistService.addMusic(setlist, music1);
        setlistService.removeMusic(setlist, music1);

        assertFalse(setlist.getMusics().contains(music1));
    }

    @Test
    void shouldReorderMusics() {
        setlistService.addMusic(setlist, music1);
        setlistService.addMusic(setlist, music2);

        setlistService.reorderMusics(setlist, List.of(music2, music1));

        assertEquals(music2, setlist.getMusics().get(0));
        assertEquals(music1, setlist.getMusics().get(1));
    }
}