package org.mql.java.dom;

import java.util.List;
import java.util.Vector;

import org.mql.java.routes.Route;

import jakarta.servlet.ServletContext;

public class RouteParser {
	private List<Route> routes;
	
	public RouteParser(ServletContext context) {
		parse(context);
	}
	
	private void parse(ServletContext context) {
		routes = new Vector<>();
		XmlNode root = new XmlNode(context);
		XmlNode children[] = root.children();
		for(XmlNode item:children) {
			Route route = new Route();
			route.setName(item.attribute("name"));
			route.setName(item.attribute("method"));
			route.setName(item.attribute("action"));
			routes.add(route);
		}
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	  
}
