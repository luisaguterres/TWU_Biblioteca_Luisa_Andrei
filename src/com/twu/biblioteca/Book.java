package com.twu.biblioteca;

import java.util.UUID;

public class Book extends Product {

    private String id;
    private String title;
    private int publishYear;
    private String author;

    @Override
    public String toString() {
        return "{" +
                "title '" + title + '\'' +
                ", publishYear " + publishYear +
                ", author " + author + '\'' +
                ", checkout " + hasBeenCheckouted() + '\'' +
                '}';
    }

    public Book(String title, int publishYear, String author) {
        super("Book");
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.title = title;
        this.publishYear = publishYear;
        this.author = author;
    }

    public Object getTitle() {
        return this.title;
    }

}
