package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String libraryNumber;
    private String password;
    private List<Book> checkoutBooks;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.checkoutBooks = new ArrayList<Book>();
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
}
