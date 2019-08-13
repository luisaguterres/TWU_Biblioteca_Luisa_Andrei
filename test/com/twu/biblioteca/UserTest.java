package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldReturnUserInformation(){
        User user = new User("01-0002", "123", "John", "john@thoughtworks.com", 1234567);
        assertEquals("Name: John / Email: john@thoughtworks.com / Phone number: 1234567", user.information());
    }
}
