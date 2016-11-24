package com.movieflix.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;

import com.movieflix.bean.Movie;

public class MovieDAO {
	public static Movie getMovie(int id,ServletContext context)
	{
		Movie movie=new Movie();
		try{
			Connection conn=(Connection)context.getAttribute("conn");
			String query="select * from movies where movie_id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				movie.setMovieId(rs.getInt("movie_id"));
				movie.setName(rs.getString("name"));
				movie.setCasts(rs.getString("casts"));
				movie.setProducers(rs.getString("producers"));
				movie.setDirectors(rs.getString("directors"));
				movie.setSynopsis(rs.getString("synopsis"));
				movie.setImage(rs.getString("image"));
				movie.setReleaseDate(rs.getDate("releaseDate"));
				
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return movie;
	}
}
