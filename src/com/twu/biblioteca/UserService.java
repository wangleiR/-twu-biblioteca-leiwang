package com.twu.biblioteca;

import java.util.ArrayList;

public class UserService {

    private  ArrayList<UserAccountInfo> userLists = new ArrayList<>();
    private String userId = "";

    public ArrayList<UserAccountInfo> getBookInfoList(){
        userLists.add(new UserAccountInfo("100-0001","123123","Lisa","10000001@aa.com","xian","100100101"));
        userLists.add(new UserAccountInfo("100-0002","aaaaaa","Tom","100000012@aa.com","xian","100100102"));
        return userLists;
    }

    public boolean login(String id,String password){
        userLists = getBookInfoList();
        userId = id;
        long cc = userLists.stream().filter(e -> e.getLoginId().equals(id) && e.getPassword().equals(password)).count();
        return  cc == 0 ? false :true;
    }

    public void showUserInfo(){
        userLists.stream().filter(e -> e.getLoginId().equals(userId)).forEach(
                e-> System.out.println("name:"+e.getName()+" email:"+e.getEmail() + "  phone number:" + e.getPhoneNumber())
        );
    }

}