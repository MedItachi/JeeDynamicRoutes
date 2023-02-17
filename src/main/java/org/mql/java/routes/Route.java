package org.mql.java.routes;

public class Route {
	private String name;
	private String method;
	private String actions;
	
	public Route() {}

	public Route(String name, String method, String actions) {
		super();
		this.name = name;
		this.method = method;
		this.actions = actions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}
	
	
	

}
