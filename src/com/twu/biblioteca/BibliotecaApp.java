package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    private static BibliotecaApp bibliotecaApp = new BibliotecaApp();

    private BooksProvider booksProvider = new BooksProvider();
    private ArrayList<BookInfo> lists = booksProvider.getBookInfoList();

    private MoviesProvider moviesProvider = new MoviesProvider();
    private ArrayList<MoviesInfo> mlists = moviesProvider.getMoviesInfoList();

    private UserService userService = new UserService();

    private static String IN_VALID_MESSAGE = "Select a valid option!" ;
    private static String WELCOME_MESSAGE = "Welcome to BibliotecaApp!";
    private static String CHECKOUT_BOOK_SUCCESS = "Thank you! Enjoy the book.";
    private static String CHECKOUT_BOOK_FAIL = "That book is not available.";
    private static String RETURN_BOOK_SUCCESS = "Thank you for returning the book.";
    private static String RETURN_BOOK_FAIL = "That is not a valid book to return.";
    private static String USER_CHOICE = "Please input your choice:";
    private static String BOOKMENUSHOW = "Id BookName Author PublishedYear";
    private static String MOVIESMENUSHOW = "Id  Name  Direct  Year  Rate";

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bibliotecaApp.loginSys();
    }

    public void start(){

        bibliotecaApp.showMainMenu();
        bibliotecaApp.showAllBookLists();

        System.out.println(USER_CHOICE);
        while(sc.hasNext()){
            String in = sc.nextLine();
            if (in.equals("0"))
                break;
            else if(isValidParam(in.trim())){
                switch (in){
                    case "1":bibliotecaApp.showAllBookLists();break;
                    case "2":bibliotecaApp.checkoutBookProcess(sc.nextLine());break;
                    case "3":bibliotecaApp.returnBookProcess(sc.nextLine());break;
                    case "4":bibliotecaApp.showMoviesLists();break;
                    case "5":bibliotecaApp.checkoutMoviesProcess(sc.nextLine());break;
                    case "6":userService.showUserInfo(); break;
                }
            }else{
                System.out.println(IN_VALID_MESSAGE);
            }
        }
    }

    public void loginSys(){
        bibliotecaApp.welcomeToBibliotecaApp();
        System.out.print("id:");
        String id = sc.nextLine().trim();
        System.out.print("password:");
        String password = sc.nextLine().trim();
        if(userService.login(id,password)){
            start();
        }else{
            System.out.println("Invalid Id or password!");
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
        System.out.println(BOOKMENUSHOW);
        lists.stream().filter(e -> e.isIfCheckout() == false).forEach(e -> System.out.println(e.getId()+ "  "
                +e.getName()+"   "+e.getAuthor() +"   "+e.getYear()));
    }

    public void showMainMenu(){
        Map<Integer,String> menus = new HashMap<>();
        menus.put(1,"List Books");
        menus.put(2,"Checkout Book");
        menus.put(3,"Return Book");
        menus.put(4,"Movies List");
        menus.put(5,"Checkout Movie");
        menus.put(6,"UserInfo");
        menus.put(0,"Quit");
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
        List<Integer> arr = Arrays.asList(1,2,3,4,5,6);
        return arr.stream().noneMatch(e -> e == temp) ? false: true ;
    }

    //movies
    public void showMoviesLists(){
        System.out.println(MOVIESMENUSHOW);
        mlists.stream().filter(e -> e.isIfCheckout() == false).forEach(e -> System.out.println(e.getId()+ "  "
                +e.getName()+"   "+e.getAuthor() +"   "+e.getYear() + " "+e.getRate()));
    }

    public void checkoutMovies(MoviesInfo moviesInfo){
        if (moviesInfo == null || moviesInfo.isIfCheckout() == true){
            System.out.println(CHECKOUT_BOOK_FAIL);
        }else if (moviesInfo.isIfCheckout() == false){
            moviesInfo.setIfCheckout(true);
            System.out.println(CHECKOUT_BOOK_SUCCESS);
        }
    }

    public void checkoutMoviesProcess(String id){
        checkoutMovies(getMoviesById(id));
    }

    public MoviesInfo getMoviesById(String id){
        for (MoviesInfo m:mlists) {
            if (m.getId().equals(Integer.valueOf(id)))
                return m;
        }
        return null;
    }
}
