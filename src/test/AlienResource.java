package test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Alien;

@Path("aliens")
public class AlienResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Alien getAlien() {
		System.out.println("getAlien called");
		Alien a = new Alien(1, "Vinay");
		return a;
	}
	
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens() {
		System.out.println("getAliens called");
		List<Alien> list = new ArrayList<>();
		Alien a1 = new Alien(1, "Vinay");
		list.add(a1);
		Alien a2 = new Alien(2, "Samrat");
		list.add(a2);
		return list;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Alien createAlien(Alien a) {
		System.out.println("Calling createAlien");
		return a;
	}

}
