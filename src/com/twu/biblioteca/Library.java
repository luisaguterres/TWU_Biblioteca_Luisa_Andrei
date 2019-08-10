package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private static List<Book> fakeList = new ArrayList<>(Arrays.asList(new Book("Harry Potter", 2001, "J.K. Rolling")));
    public Library() {
        loadBooks();
    }

    public void loadBooks() { ;
        this.books = fakeList;
    }

    public List<Book> getBooks() {
        return books.stream()
                .filter(book -> !book.hasBeenCheckouted())
                .collect(Collectors.toList());

    }

    public Book getBookByName(String bookName) {
        Book selectedBook = getBooks().stream()
                .filter(book -> book.getTitle().equals(bookName) && !book.hasBeenCheckouted())
                .findFirst()
                .orElse(null);
        books.remove(selectedBook);
        return selectedBook;
    }

    public boolean checkoutBookByTitle(String bookName) {
        Book selectedBook = getBookByName(bookName);
        if(selectedBook != null){
            selectedBook.changeBookStatus(true);
            updateList(selectedBook);
            System.out.println(selectedBook.hasBeenCheckouted());
            return true;
        }
        return false;
    }

    private void updateList(Book book) {
        books.add(book);
    }

    public boolean checkinBookByTitle(String bookName) {
        Book selectedBook = getBookByName(bookName);
        if(selectedBook != null){
            selectedBook.changeBookStatus(false);
            updateList(selectedBook);
            return true;
        }
        return false;
    }
}
