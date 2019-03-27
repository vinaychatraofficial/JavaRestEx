package test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.AlienDao;
import com.model.Alien;

@Path("aliens")
public class AlienResource {
	private AlienDao dao = new AlienDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Alien getAlien() {
		System.out.println("getAlien called");
		Alien a = new Alien(1, "Vinay");
		return a;
	}
	
	@Path("/all")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Alien> getAliens() {
		System.out.println("getAliens called");
		List<Alien> list = new ArrayList<>();
		Alien a1 = new Alien(1, "Vinay");
		list.add(a1);
		Alien a2 = new Alien(2, "Samrat");
		list.add(a2);
		return list;
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id) {
		return dao.getAlien(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Alien createAlien(Alien a) {
		System.out.println("Calling createAlien");
		dao.createAlien(a);
		return a;
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien updateAlien(@PathParam("id") int id, Alien a) {
		System.out.println("updateAlien called for id "+id);
		
		return a;
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAlien(@PathParam("id") int id) {
		System.out.println("deleteAlien called");
		Alien a = new Alien(id, "deleted alien");
		return Response.ok(a).build();
	}

}
