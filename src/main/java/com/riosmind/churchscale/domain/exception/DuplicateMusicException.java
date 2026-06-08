package com.riosmind.churchscale.domain.exception;

public class DuplicateMusicException extends RuntimeException {
    public DuplicateMusicException(String musicTitle) {
        super("Music " + musicTitle + " is already in the setlist");
    }
}
