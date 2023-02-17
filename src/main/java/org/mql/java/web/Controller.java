package org.mql.java.web;

import java.io.IOException;
import java.util.List;

import org.mql.java.dom.RouteParser;
import org.mql.java.routes.Route;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Route> routes;
	private String url;
	
	public void init() throws ServletException {
		System.out.println("servlet init");
		RouteParser routParser = new RouteParser(getServletContext());
		routes = routParser.getRoutes();
		System.out.println(getServletContext().getInitParameter("url"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	private Route getRoute(String name, String method) {
		
		for(Route route:routes) {
			if(route.getName().equals(name)&&route.getMethod().equals(method)) {
				return route;
			}
		}
		
		return null;
	}
	

}
