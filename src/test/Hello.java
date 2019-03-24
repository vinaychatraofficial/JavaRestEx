package test;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/hello")
public class Hello {
	
	@Path("hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello world";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello() {
		String resource ="<? xml version='1.0' ?>"+
				"<hello>Hello from XML</hello>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJson() {
		String resource =null;
		return resource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHtml(@QueryParam("name") String name, @QueryParam("amount") int amount) {
		String resource = "<h1> Hello "+name+", ";
		String response=null;
		if(amount<100000)
			response = "Credit card approved";
		else
			response = "Credit card not approved";
		return resource + response + "</h1>";
	}

}
