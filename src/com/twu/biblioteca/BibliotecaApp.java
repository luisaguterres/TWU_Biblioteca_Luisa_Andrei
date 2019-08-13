package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BibliotecaApp {
    private static Library library = new Library();
    private static User currentUser;

    public static void main(String[] args) {
       System.out.println(welcomeMessage());
        int option;
        Scanner scan = new Scanner(System.in);
        currentUser = askForLogin(scan);
        do{
            menu().stream().iterator().forEachRemaining(System.out::println);
            option = getMenuOptionSelected(scan);
            System.out.println(loadMenuOption(option, scan, currentUser));
        }while (option != 0);

    }

    private static User askForLogin(Scanner scan) {
        System.out.println("Library Number: ");
        String libraryNumber = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();
        User user = library.loginUser(libraryNumber, password);
        if (user != null) return user;

        System.out.println("Wrong password or library number!!! ");
        return askForLogin(scan);
    }

    private static int getMenuOptionSelected(Scanner scan){
        int option = scan.nextInt();
        scan.nextLine();
        return option;
    }

    public static String loadMenuOption(int selectedOption, Scanner scan, User user) {

        switch (selectedOption){
            case 1: {
                return library.getAvailableBooks().toString();
            }
            case 2:{
                System.out.println("Inform the name of the book: ");
                String bookName = scan.nextLine();
                boolean checkouted = library.checkoutBookByTitle(bookName, user);

                if (checkouted){ return "Thank you! Enjoy the book";}
                else return "Sorry, that book is not available";
            }
            case 3: {
                System.out.println("Inform the name of the book: ");
                String bookName = scan.nextLine();
                boolean checkin = library.checkinBookByTitle(bookName);
                if (checkin){return "Thank you for returning the book.";}
                else return "That is not a valid book to return.";
            }
            case 4: {
                return library.getAvailableMovies().toString();
            }
            case 5: {
                System.out.println("Inform the name of the movie: ");
                String movieName = scan.nextLine();
                boolean checkouted = library.checkoutMovieByTitle(movieName);

                if (checkouted){ return "Thank you! Enjoy the movie";}
                else return "Sorry, that movie is not available";
            }
            case 6: {
                System.out.println("Inform the name of the book: ");
                String bookName = scan.nextLine();
                List<User> users = library.checkUsersWhoCheckedout(bookName);
                return users.toString();
            }
            case 0: {
                scan.close();
                System.exit(0);
                return "Closed!";
            }
            default: {
                return "Invalid option";
            }
        }
    }

    public static List<String> menu(){
        List menuItens = new ArrayList();
        menuItens.add("1 - List of books");
        menuItens.add("2 - Checkout a Book");
        menuItens.add("3 - Checkin a Book");
        menuItens.add("4 - List of Movies");
        menuItens.add("5 - Checkout Movie");
        menuItens.add("6 - Checked out Books");
        menuItens.add("0 - Exit");
        return menuItens;
    }

    public static String welcomeMessage(){return "Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!";}
}
