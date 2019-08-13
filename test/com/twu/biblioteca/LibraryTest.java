package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library = new Library();

    @Test
    public void shouldLoginUser(){
        User user = library.loginUser("008-0007", "password");
        assertEquals("008-0007", user.getLibraryNumber());
    }

    @Test
    public void shouldReturnNullWhenUserDoNotExist() {
        User user = library.loginUser("008-0017", "password");
        assertEquals(null, user);
    }

//    @Test
//    public void shoulReturnAListWithUsersThatCheckedoutHarryPotter(){
//        List<User> userWhoCheckedOutHarryPotter = library.checkUsersWhoCheckedout("Harry Potter");
//        assertEquals(2, userWhoCheckedOutHarryPotter.size());
//    }
}
