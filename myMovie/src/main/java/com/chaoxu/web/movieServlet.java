package com.chaoxu.web;

import com.chaoxu.dao.movieDao;
import com.chaoxu.entity.Movie;
import com.chaoxu.service.MovieService;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dell on 2016/6/18.
 */
@WebServlet("/movies")
public class movieServlet extends HttpServlet {
    private MovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pageNO = req.getParameter("p");
        int p = 1;
         if(StringUtils.isNumeric(pageNO)){
             p = new Integer(pageNO);
         }

        List<Movie> movieList = movieService.findbypage(p);
        req.setAttribute("movie", movieList);

        req.getRequestDispatcher("/WEB-INF/views/movielist.jsp").forward(req, resp);

    }

}
