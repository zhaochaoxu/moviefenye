package com.chaoxu;
import com.chaoxu.dao.movieDao;
import com.chaoxu.entity.Movie;
import static org.junit.Assert.*;

import com.chaoxu.service.MovieService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by dell on 2016/6/18.
 */
public class movieTeseCase {
    private Logger logger = LoggerFactory.getLogger(movieTeseCase.class);
    private movieDao movie = new movieDao();
    private MovieService movieService = new MovieService();


    @Test
    public void movietest(){
        Movie m = movie.getonemoviebyid(101);
        //logger.debug("{}",m);
        assertNotNull(m);
    }

    @Test
    public void testmovieall(){
        List<Movie> list = movie.getAllmovie();
        assertNotNull(list);
        //logger.debug("{}",list);
    }


    @Test
    public void testmovietotal(){
        int num =  movie.getmovietotal().intValue();
        //logger.debug("{}",num);
    }

    @Test
    public void testlimit(){
        List<Movie> m = movieService.findbypage(2);
        logger.debug("{}",m);

    }
}
