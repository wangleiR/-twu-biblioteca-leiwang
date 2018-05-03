package com.twu.biblioteca;

import java.util.ArrayList;

public class MoviesProvider {

    private ArrayList<MoviesInfo>  moviesInfos = new ArrayList<>();

    public ArrayList<MoviesInfo> getMoviesInfoList(){
        moviesInfos.add(new MoviesInfo(201,"Ship","HKKK",2017,false,2));
        moviesInfos.add(new MoviesInfo(202,"Live","LLLLL",2017,false,7));
        moviesInfos.add(new MoviesInfo(203,"Movies","MCMNB",2001,false,8));
        return moviesInfos;
    }
}
