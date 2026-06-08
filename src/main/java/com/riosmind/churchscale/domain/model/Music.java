package com.riosmind.churchscale.domain.model;

public class Music {

    private String title;
    private String tone;
    private String link;

    public Music(){
    }

    public Music(String title, String tone, String link) {
        this.title = title;
        this.tone = tone;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
