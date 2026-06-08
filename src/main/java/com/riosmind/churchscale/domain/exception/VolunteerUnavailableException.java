package com.riosmind.churchscale.domain.exception;

import java.time.LocalDate;

public class VolunteerUnavailableException extends RuntimeException     {
    public VolunteerUnavailableException(String volunteerName, LocalDate date) {
        super("Volunteer " + volunteerName + " is not available on " + date);
    }
}
