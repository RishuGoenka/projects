package com.zycus.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.zycus.interfaces.IModel;
import com.zycus.models.ModelCheckCredentials;
import com.zycus.models.ModelContext;
import com.zycus.models.ModelShowMovies;
import com.zycus.resource.ResourceFactory;

/**
 * Servlet implementation class TicketFrontController
 */
public class TicketFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(TicketFrontController.class);
	ResourceFactory resource;

    /**
     * Default constructor. 
     */
    public TicketFrontController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		resource=new ResourceFactory();
		super.init();
	}


	private String getCommang(String uri){
		int slashPosition=uri.lastIndexOf('/');
		int dotPosition=uri.lastIndexOf('.');
		return uri.substring(slashPosition+1,dotPosition);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispacher=null;
		String requestedURI=request.getRequestURI();
		String command=getCommang(requestedURI);
		ModelContext ctx=new ModelContext();
		
		ctx.setResource("Resource", resource);
		ctx.setResource("request", request);
		ctx.setResource("response", response);
		ctx.setResource("session", request.getSession(false));
		
		if(command.equalsIgnoreCase("HOME")||command.equalsIgnoreCase("*")){
			dispacher=request.getRequestDispatcher("/login");
			dispacher.forward(request, response);
		}
		
		else if(command.equalsIgnoreCase("chechCredentials")){
			IModel model=new ModelCheckCredentials();
			String validity=model.executeModel(ctx);
			if(validity.equalsIgnoreCase("valideUser")){
				//Go to Welcome Page.
				dispacher=request.getRequestDispatcher("/welcome");
				dispacher.forward(request, response);
			}else{
				//go to login page.
				dispacher=request.getRequestDispatcher("/login");
				dispacher.forward(request, response);
			}
		}
		
		else if(command.equalsIgnoreCase("showMovies")){
			IModel model1=new ModelShowMovies();
			model1.executeModel(ctx);
			dispacher=request.getRequestDispatcher("/showMovies");
			dispacher.forward(request, response);
		}
	}

	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
