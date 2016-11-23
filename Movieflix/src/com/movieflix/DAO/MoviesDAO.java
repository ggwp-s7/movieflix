package com.movieflix.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import com.movieflix.bean.Movie;

public class MoviesDAO {
	public static ArrayList<Movie> getMovies(int time,ServletContext context)
	{
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try{
			Connection conn = (Connection)context.getAttribute("conn");
			String query="select * from movies where showtime=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,time);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Movie movie = new Movie();
				movie.setMovieId(rs.getInt("movie_id"));
				movie.setName(rs.getString("name"));
				movie.setCasts(rs.getString("casts"));
				movie.setProducers(rs.getString("producers"));
				movie.setDirectors(rs.getString("directors"));
				movie.setSynopsis(rs.getString("synopsis"));
				movie.setImage(rs.getString("image"));
				movie.setReleaseDate(rs.getDate("releaseDate"));
				movies.add(movie);
			}
			return movies;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return movies;
		
	}
}
