package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Product> products;
    private static List<Product> fakeList = new ArrayList<>(Arrays.asList(
            new Book("Harry Potter", 2001, "J.K. Rolling"),
            new Movie("Matrix", 1999, "Lilly and Lana Wachowski", 8))
    );

    public Library() {
        loadBooks();
    }

    public void loadBooks() { ;
        this.products = fakeList;
    }

    public List<Book> getBooks() {
        return products.stream()
                .filter(book -> book.getCategory().equals("Book"))
                .map(book -> (Book) book)
                .collect(Collectors.toList());
    }

    public List<Movie> getMovies() {
        return products.stream()
                .filter(movie -> movie.getCategory().equals("Movie"))
                .map(movie -> (Movie) movie)
                .collect(Collectors.toList());
    }

    public List<Book> getAvailableBooks() {
        return getBooks().stream()
                .filter(book -> !book.hasBeenCheckouted())
                .collect(Collectors.toList());

    }

    public Book getBookByName(String bookName) {
        Book selectedBook = getBooks().stream()
                .filter(book -> book.getTitle().equals(bookName))
                .findFirst()
                .orElse(null);
        products.remove(selectedBook);
        return selectedBook;
    }

    public boolean checkoutBookByTitle(String bookName) {
        Book selectedBook = getBookByName(bookName);
        if(selectedBook != null && !selectedBook.hasBeenCheckouted()){
            selectedBook.changeBookStatus(true);
            updateList(selectedBook);
            return true;
        }
        return false;
    }

    private void updateList(Book book) {
        products.add(book);
    }

    public boolean checkinBookByTitle(String bookName) {
        Book selectedBook = getBookByName(bookName);
        System.out.println("Book status "+selectedBook.hasBeenCheckouted());
        if(selectedBook != null && selectedBook.hasBeenCheckouted()){
            selectedBook.changeBookStatus(false);
            updateList(selectedBook);
            return true;
        }
        return false;
    }
}
