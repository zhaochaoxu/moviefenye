package com.chaoxu.dao;

import com.chaoxu.entity.Movie;
import com.chaoxu.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Created by dell on 2016/6/18.
 */
public class movieDao {

    public Movie getonemoviebyid(Integer id){
        String sql = "SELECT * FROM movie WHERE id=?";
        return Dbhelp.Query(sql,new BeanHandler<>(Movie.class),id);
    }

    public List<Movie> getAllmovie(){
        String sql = "SELECT * FROM movie ";
        return Dbhelp.Query(sql,new BeanListHandler<>(Movie.class));
    }

     public Long getmovietotal(){
         String sql = "select count(*) from movie";
         return Dbhelp.Query(sql, new ScalarHandler<Long>());
     }
    public List<Movie> getmoviebylimit(int start,int size){

        String sql = "SELECT * FROM movie LIMIT ?,?";
        return Dbhelp.Query(sql,new BeanListHandler<>(Movie.class),start,size);
    }


}
