package com.zycus.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zycus.entity.PUser;
import com.zycus.fasad.Fasad;
import com.zycus.interfaces.IModel;
import com.zycus.resource.ResourceFactory;


public class ModelCheckCredentials implements IModel {

	@Override
	public String executeModel(ModelContext ctx) {
		ResourceFactory factory=(ResourceFactory)ctx.getResource("Resource");
		HttpServletRequest request=(HttpServletRequest) ctx.getResource("request");
		Fasad fasad=(Fasad)factory.getObject("fasad");

		PUser newUser=new PUser();
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword(request.getParameter("password"));
		
		PUser checkedUser=fasad.getValidUser(newUser);
		
		if(checkedUser==null){
			request.setAttribute("error", "Invalid Username or Password");
			return "invalideUser";
		}
		else{
			HttpSession session=request.getSession(true);
			session.setAttribute("user", checkedUser);
			return "valideUser";
		}
		
	}

}
