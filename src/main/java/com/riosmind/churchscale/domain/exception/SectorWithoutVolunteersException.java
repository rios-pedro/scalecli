package com.riosmind.churchscale.domain.exception;

public class SectorWithoutVolunteersException extends RuntimeException {
    public SectorWithoutVolunteersException(String sectorName) {
        super("Sector " + sectorName + " has no volunteers available");
    }
}
