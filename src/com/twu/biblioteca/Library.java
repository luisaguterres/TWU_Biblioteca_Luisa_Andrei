package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Product> products;

    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("008-0007","password", "Mary", "mary@thoughtworks.com", 9876543),
            new User("008-0005","password", "Steven", "steven@thoughtworks.com", 5674321)
    ));
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

    public List<Movie> getAvailableMovies() {
        return getMovies().stream()
                .filter(movie -> !movie.hasBeenCheckouted())
                .collect(Collectors.toList());
    }

    public Book getBookByName(String bookName) {
        Book selectedBook = getBooks().stream()
                .filter(book -> book.getTitle().equals(bookName))
                .findFirst()
                .orElse(null);
        return selectedBook;
    }

    public Movie getMovieByName(String movieName) {
        Movie selectedMovie = getMovies().stream()
                .filter(movie -> movie.getName().equals(movieName))
                .findFirst()
                .orElse(null);

        return selectedMovie;
    }

    public boolean checkoutBookByTitle(String bookName, User loggedUser) {
        Book selectedBook = getBookByName(bookName);
        if(selectedBook != null && !selectedBook.hasBeenCheckouted()){
            selectedBook.changeStatus(true);
            loggedUser.checkoutBook(selectedBook);
            return true;
        }
        return false;
    }

    public boolean checkoutMovieByTitle(String movieName) {
        Movie selectedMovie = getMovieByName(movieName);
        if(selectedMovie != null && !selectedMovie.hasBeenCheckouted()){
            selectedMovie.changeStatus(true);
            return true;
        }
        return false;
    }

    public boolean checkinBookByTitle(String bookName) {
        Book selectedBook = getBookByName(bookName);
        System.out.println("Book status "+selectedBook.hasBeenCheckouted());
        if(selectedBook != null && selectedBook.hasBeenCheckouted()){
            selectedBook.changeStatus(false);
            return true;
        }
        return false;
    }

    public User loginUser(String libraryNumber, String password) {
        User loggedUser = users.stream()
                .filter(user -> user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        return loggedUser;
    }

    public List<User> checkUsersWhoCheckedout(String bookTitle) {
        List<User> usersWhoCheckedout = users.stream()
                .filter(user -> user.hasCheckedoutBook(bookTitle)).collect(Collectors.toList());
        return  usersWhoCheckedout;
    }
}
