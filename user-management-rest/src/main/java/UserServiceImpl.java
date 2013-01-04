import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.himanshu.um.api.model.User;
import com.himanshu.um.api.model.UserTO;


@Path("/user-service/")
public class UserServiceImpl {

	@GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_XML)
	public UserTO getUser(@PathParam("id") Integer id) {
		System.out.println("Id to get :    "+id);
		User u = new User();
		//u.setId(id);
		UserTO userTo = new UserTO();
		userTo.setUser(u);
		return userTo;
	}

}
