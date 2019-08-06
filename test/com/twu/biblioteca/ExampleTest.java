package com.twu.biblioteca;


import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        assertTrue(BibliotecaApp.welcomeMessage() instanceof String);
    }
}
