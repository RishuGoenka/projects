package com.zycus.models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zycus.entity.PMovies;
import com.zycus.fasad.Fasad;
import com.zycus.interfaces.IModel;
import com.zycus.resource.ResourceFactory;

public class ModelShowMovies implements IModel{

	@SuppressWarnings("deprecation")
	@Override
	public String executeModel(ModelContext ctx) {
		ResourceFactory factory=(ResourceFactory)ctx.getResource("Resource");
		HttpSession session=(HttpSession)ctx.getResource("session");
		HttpServletRequest request=(HttpServletRequest)ctx.getResource("request");
		Fasad fasad=(Fasad)factory.getObject("fasad");

		Date showDate=new Date(request.getParameter("date"));
		List<PMovies> movieList=fasad.getMoviesByDate(showDate);
		if(movieList.isEmpty()){
			request.setAttribute("empty", "No movie Available on "+showDate);
			return "empty";
		}
		else{
			session.setAttribute("movieList", movieList);
			session.setAttribute("showDate", showDate);
			return "notEmpty";
		}
	}

}
