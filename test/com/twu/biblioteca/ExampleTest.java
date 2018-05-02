package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Test
    public void testisValidParam() {
        String str = null;
        boolean flag = bibliotecaApp.isValidParam(str);
        assertEquals(false, flag);
    }

    @Test
    public void testShowMainMenu() {
        // assertEquals(1, 1);
        bibliotecaApp.showMainMenu();
    }


}
