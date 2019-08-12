package com.twu.biblioteca;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class BibliotecaApp {

    public static void main(String[] args) {
       System.out.println(welcomeMessage());
        int option;
        Scanner scan = new Scanner(System.in);
        do{
            menu().stream().iterator().forEachRemaining(System.out::println);
            option = getMenuOptionSelected(scan);
            System.out.println(loadMenuOption(option, scan));
        }while (option != 0);

    }

    private static int getMenuOptionSelected(Scanner scan){
        int option = scan.nextInt();
        scan.nextLine();
        return option;
    }

    public static String loadMenuOption(int selectedOption, Scanner scan) {
        Library library = new Library();
        switch (selectedOption){
            case 1: {
                return library.getAvailableBooks().toString();
            }
            case 2:{
                System.out.print("Inform the name of the book: ");
                String bookName = scan.nextLine();
                boolean checkouted = library.checkoutBookByTitle(bookName);

                if (checkouted){ return "Thank you! Enjoy the book";}
                else return "Sorry, that book is not available";
            }
            case 3: {
                System.out.print("Inform the name of the book: ");
                String bookName = scan.nextLine();
                System.out.println(">>>>>>>>>>>>>>. "+bookName);
                boolean checkin = library.checkinBookByTitle(bookName);
                if (checkin){return "Thank you for returning the book.";}
                else return "That is not a valid book to return.";
            }
            case 4: {
                return library.getAvailableMovies().toString();
            }
            case 5: {
                System.out.print("Inform the name of the movie: ");
                String movieName = scan.nextLine();
                boolean checkouted = library.checkoutMovieByTitle(movieName);

                if (checkouted){ return "Thank you! Enjoy the movie";}
                else return "Sorry, that movie is not available";
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
        menuItens.add("0 - Exit");
        return menuItens;
    }

    public static String welcomeMessage(){return "Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!";}
}
