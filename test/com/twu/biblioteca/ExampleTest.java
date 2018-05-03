package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Test
    public void testIsValidParamWhenInputMistake() {
        String str = null;
        boolean flag = bibliotecaApp.isValidParam(str);
        assertEquals(false, flag);
    }

    @Test
    public void testIsValidParamWhenInputRight() {
        String str = "1";
        boolean flag = bibliotecaApp.isValidParam(str);
        assertEquals(true, flag);
    }

    @Test
    public void testGetBookByIdWhenInputRight() {
        String bookId = "1001";
        BookInfo expectBookId = bibliotecaApp.getBookById(bookId);
        assertEquals(expectBookId.getId().toString() ,"1001");
    }

    @Test
    public void testGetBookByIdWhenInputMistake() {
        String bookId = "1009";
        BookInfo info  = bibliotecaApp.getBookById(bookId);
        assertEquals(info, null);
    }

}
