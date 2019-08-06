package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
       System.out.println(welcomeMessage());
       Library library = new Library();
        System.out.printf(library.getBooks().toString());
    }

    public static String welcomeMessage(){return "Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!";}
}
