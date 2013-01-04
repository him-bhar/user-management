import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.himanshu.um.api.model.User;


//@Path("/user-service/")
public interface UserService {

	    /*@GET
	    @Path("/user/{id}")
	    @Produces(MediaType.APPLICATION_XML)*/
	    public User getUser(/*@PathParam("id")*/ Integer id);

	    /*@POST
	    @Path("/new")
		@Produces(MediaType.TEXT_HTML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void newUser(
				@FormParam("id") Integer id,
				@FormParam("name") String name,
				@Context HttpServletResponse servletResponse
		) throws IOException;*/
	}
