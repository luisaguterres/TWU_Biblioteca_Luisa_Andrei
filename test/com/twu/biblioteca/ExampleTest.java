package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        assertEquals("Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!", BibliotecaApp.welcomeMessage());
    }

    @Test
    public void shouldPrintMenu(){
        List<String> menu = BibliotecaApp.menu();
        assertEquals("1 - List of books" , menu.get(0));
        assertEquals(1, menu.size());
    }

    @Test
    public void whenChoosedMenuOptionShouldListdBooks(){
//        assertEquals();
    }
}
