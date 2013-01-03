import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.himanshu.um.api.user.User;

@Path("/user-service/")
public class UserServiceImpl implements UserService {

	@Override
	@GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_XML)
	public User getUser(@PathParam("id") Integer id) {
		System.out.println("Id to get :    "+id);
		User u = new User();
		//u.setId(id);
		return u;
	}

}
