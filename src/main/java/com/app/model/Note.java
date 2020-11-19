package com.app.model;

public class Note {

    private String text;
    private Integer id;

    public Note(final String text, final Integer id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Note{" +
                "text='" + text + '\'' +
                ", id=" + id +
                '}';
    }
}
