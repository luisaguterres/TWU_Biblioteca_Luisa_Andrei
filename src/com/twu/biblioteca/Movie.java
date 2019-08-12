package com.twu.biblioteca;

public class Movie extends Product {

    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        super("Movie");
        this.name = name;
        this.year = year;
        this.director = director;
        if(this.rating < 0 || this.rating > 10){
            throw new IllegalArgumentException("Invalid Ratting");
        }else{ this.rating = rating; }
    }

    @Override
    public String toString() {
        return "{" +
                "title '" + name + '\'' +
                ", year " + year +
                ", director '" + director + '\'' +
                ", rating " + rating +
                '}';
    }

    public String getName() {
        return name;
    }
}
