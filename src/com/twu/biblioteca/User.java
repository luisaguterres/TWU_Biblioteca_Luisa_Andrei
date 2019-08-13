package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String libraryNumber;
    private String password;
    private List<Book> checkoutBooks;
    private String name;
    private String email;
    private Integer phoneNumber;

    public User(String libraryNumber, String password, String name, String email, Integer phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.checkoutBooks = new ArrayList<Book>();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getCheckoutBooks() {
        return checkoutBooks;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public boolean hasCheckedoutBook(String bookTitle) {
        Book hasCheckedout = checkoutBooks.stream()
                .filter(book -> book.getTitle().equals(bookTitle))
                .findAny().orElse(null);
        return hasCheckedout!=null;
    }

    public void checkoutBook(Book selectedBook) {
        checkoutBooks.add(selectedBook);
    }

    @Override
    public String toString() {
        return "{" +
                "libraryNumber '" + libraryNumber + '\'' +
                '}';
    }

    public String information(){
        return "Name: "+ name +" / Email: "+email+ " / Phone number: "+phoneNumber;
    }
}
