package com.twu.biblioteca;

import java.util.ArrayList;

public class BooksProvider {

    private ArrayList<BookInfo> bookInfoList = new ArrayList<>();

    public ArrayList<BookInfo> getBookInfoList(){
        bookInfoList.add(new BookInfo(1001,"Today","HK",2017,false));
        bookInfoList.add(new BookInfo(1002,"Spring","LL",2017,false));
        bookInfoList.add(new BookInfo(1003,"Flower","MC",2001,false));
        bookInfoList.add(new BookInfo(1004,"Internet","MK",2013,false));
        bookInfoList.add(new BookInfo(1005,"Sun","sun",2009,true));
        return bookInfoList;
    }
}
