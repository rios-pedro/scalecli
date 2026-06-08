package com.riosmind.churchscale.domain.service;

import com.riosmind.churchscale.domain.exception.SectorWithoutVolunteersException;
import com.riosmind.churchscale.domain.exception.VolunteerUnavailableException;
import com.riosmind.churchscale.domain.model.Scale;
import com.riosmind.churchscale.domain.model.Sector;
import com.riosmind.churchscale.domain.model.Volunteer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScaleServiceTest {

    private domain.service.ScaleService scaleService;
    private Scale scale;
    private Sector sector;
    private Volunteer availableVolunteer;
    private Volunteer unavailableVolunteer;

    private static final LocalDate SCALE_DATE = LocalDate.of(2025, 6, 15);

    @BeforeEach
    void setUp() {
        scaleService = new domain.service.ScaleService();
        scale = scaleService.createScale("Sunday Service", SCALE_DATE);
        sector = new Sector("Louvor");

        availableVolunteer = new Volunteer("Pedro", "pedro@email.com", new HashSet<>(), SCALE_DATE);
        unavailableVolunteer = new Volunteer("Ana", "ana@email.com", new HashSet<>(), SCALE_DATE.plusDays(1));
    }

    @Test
    void    shouldAllocateVolunteerWhenAvailable() {
        scaleService.allocateVolunteer(scale, sector, availableVolunteer);

        List<Volunteer> volunteers = scale.getAllocations().get(sector);
        assertNotNull(volunteers);
        assertTrue(volunteers.contains(availableVolunteer));
    }

    @Test
    void shouldThrowExceptionWhenVolunteerUnavailable() {
        assertThrows(VolunteerUnavailableException.class, () ->
                scaleService.allocateVolunteer(scale, sector, unavailableVolunteer)
        );
    }

    @Test
    void shouldThrowExceptionWhenSectorHasNoVolunteers() {
        assertThrows(SectorWithoutVolunteersException.class, () ->
                scaleService.getVolunteersBySector(scale, sector)
        );
    }

    @Test
    void shouldReturnVolunteersAfterAllocation() {
        scaleService.allocateVolunteer(scale, sector, availableVolunteer);

        List<Volunteer> volunteers = scaleService.getVolunteersBySector(scale, sector);
        assertEquals(1, volunteers.size());
        assertEquals("Pedro", volunteers.get(0).getName());
    }
}