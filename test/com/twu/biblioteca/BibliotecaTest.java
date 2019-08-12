package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static junit.framework.TestCase.*;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaTest {
    private Scanner scan;

    @Before
    public void before() {
        scan = mock(Scanner.class);
    }
    @Test
    public void shouldReturnWelcomeMessage() {
        assertEquals("Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!", BibliotecaApp.welcomeMessage());
    }

    @Test
    public void shouldPrintMenu(){
        List<String> menu = BibliotecaApp.menu();
        assertEquals("1 - List of books" , menu.get(0));
        assertEquals(5, menu.size());
    }

    @Test
    public void whenChooseMenuOptionShouldListdBooks(){
        assertEquals("[{title 'Harry Potter', publishYear 2001, author J.K. Rolling', checkout false'}]", BibliotecaApp.loadMenuOption(1, scan));
    }

    @Test
    public void shouldReturnSuccessMessageWhenCheckoutBook() {
        when(scan.nextLine()).thenReturn("Harry Potter");
        assertEquals("Thank you! Enjoy the book", BibliotecaApp.loadMenuOption(2, scan));
    }

    @Test
    public void shouldReturnFailureMessageWhenCheckoutInexistentBook() {
        when(scan.nextLine()).thenReturn("Twilight");
        assertEquals("Sorry, that book is not available", BibliotecaApp.loadMenuOption(2, scan));
    }

    @Test
    public void shouldReturnSuccessMessageWhenCheckintBook() {
        when(scan.nextLine()).thenReturn("Harry Potter");
        BibliotecaApp.loadMenuOption(2, scan);
        assertEquals("Thank you for returning the book.", BibliotecaApp.loadMenuOption(3, scan));
    }

//    @Test
//    public void shouldReturnFailureMessageWhenCheckinInexistentBook() {
//        when(scan.nextLine()).thenReturn("Harry Potter");
//        assertEquals("That is not a valid book to return.", BibliotecaApp.loadMenuOption(3, scan));
//    }
}
