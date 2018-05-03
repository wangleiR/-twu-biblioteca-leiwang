package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    private BooksProvider booksProvider = new BooksProvider();
    private ArrayList<BookInfo> lists = booksProvider.getBookInfoList();
    private static BibliotecaApp bibliotecaApp = new BibliotecaApp();

    private static String IN_VALID_MESSAGE = "Select a valid option!" ;
    private static String WELCOME_MESSAGE = "Welcome to BibliotecaApp!";
    private static String CHECKOUT_BOOK_SUCCESS = "Thank you! Enjoy the book.";
    private static String CHECKOUT_BOOK_FAIL = "That book is not available.";
    private static String RETURN_BOOK_SUCCESS = "Thank you for returning the book.";
    private static String RETURN_BOOK_FAIL = "That is not a valid book to return.";
    private static String USER_CHOICE = "Please input your choice:";
    private static String MENUSHOW = "Id BookName Author PublishedYear";


    public static void main(String[] args) {
        bibliotecaApp.start();
    }

    public void start(){
        bibliotecaApp.welcomeToBibliotecaApp();
        bibliotecaApp.showMainMenu();
        bibliotecaApp.showAllBookLists();

        System.out.println(USER_CHOICE);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String in = sc.nextLine();
            if (in.equals("4"))
                break;
            else if(isValidParam(in.trim())){
                switch (in){
                    case "1":bibliotecaApp.showAllBookLists();
                        break;
                    case "2":bibliotecaApp.checkoutBookProcess(sc.nextLine());
                        break;
                    case "3":bibliotecaApp.returnBookProcess(sc.nextLine());
                        break;
                }
            }else{
                System.out.println(IN_VALID_MESSAGE);
            }
        }
    }

    public void welcomeToBibliotecaApp(){
        System.out.println(WELCOME_MESSAGE);
    }

    public void checkoutBookProcess(String bookId){
        checkoutBook(getBookById(bookId));
    }
    public void returnBookProcess(String bookId){
        returnBook(getBookById(bookId));
    }

    public void showAllBookLists(){
        System.out.println(MENUSHOW);
        lists.stream().filter(e -> e.isIfCheckout() == false).forEach(e -> System.out.println(e.getId()+ "  "
                +e.getBookName()+"   "+e.getAuthor() +"   "+e.getPublishedYear()));
    }

    public void showMainMenu(){
        Map<Integer,String> menus = new HashMap<>();
        menus.put(1,"List Books");
        menus.put(2,"Checkout Book");
        menus.put(3,"Return Book");
        menus.put(4,"Quit");
        menus.forEach((k,v)->System.out.print(k + "." + v + "   "));
        System.out.println();
    }
    public BookInfo getBookById(String bookId){
        for (BookInfo book:lists) {
            if (book.getId().equals(Integer.valueOf(bookId)))
                return book;
        }
        return null;
    }

    public void checkoutBook(BookInfo bookInfo){
        if (bookInfo == null || bookInfo.isIfCheckout() == true){
            System.out.println(CHECKOUT_BOOK_FAIL);
        }else if (bookInfo.isIfCheckout() == false){
            bookInfo.setIfCheckout(true);
            System.out.println(CHECKOUT_BOOK_SUCCESS);
        }
    }

    public void returnBook(BookInfo bookInfo){
        if (bookInfo == null){
            System.out.println(RETURN_BOOK_FAIL);
        }else if (bookInfo.isIfCheckout()){
            bookInfo.setIfCheckout(false);
            System.out.println(RETURN_BOOK_SUCCESS);
        }
    }

    public boolean isValidParam(String menuSelect){
        if (menuSelect == null || menuSelect == "")
            return false;
        Integer temp = Integer.valueOf(menuSelect);
        List<Integer> arr = Arrays.asList(1,2,3,4);
        return arr.stream().noneMatch(e -> e == temp) ? false: true ;
    }
}
