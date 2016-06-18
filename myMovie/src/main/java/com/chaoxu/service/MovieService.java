package com.chaoxu.service;

import com.chaoxu.dao.movieDao;
import com.chaoxu.entity.Movie;
import com.chaoxu.util.Page;

import java.util.List;

/**
 * Created by dell on 2016/6/18.
 */
public class MovieService {
    private movieDao dao = new movieDao();

    public List<Movie> findAll(){
       return dao.getAllmovie();
    }

    public Page<Movie> findbypage(int pageNO){

        int totalSize = dao.getmovietotal().intValue();//获取数据总记录

        Page<Movie> page = new Page<>(pageNO,10,totalSize);

        List<Movie> movieList = dao.getmoviebylimit(page.getStart(),10);
        page.setItems(movieList);
        return page;

        /*int size = 10 ;
        int movietotal = dao.getmovietotal().intValue();//获取总数据
        int pagesize = movietotal/size;//获取总页数

        if(pagesize % 10 != 0){
            pagesize++;
        }
        if(pageNO>pagesize){
            pageNO = pagesize;
        }
        if (pageNO==0){
            pageNO = 1;
        }

        int start = (pageNO-1)*size;

       return  dao.getmoviebylimit(start,size);*/
    }

}
