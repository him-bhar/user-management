import java.util.ArrayList;
import java.util.List;

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

	@GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
	public List<UserTO> getUsers() {
		List<UserTO> userList = new ArrayList<UserTO>();
		UserTO userTo1 = new UserTO();
		User u1 = new User();
		u1.setUsername("himanshu");
		userTo1.setUser(u1);
		userList.add(userTo1);

		UserTO userTo2 = new UserTO();
		User u2 = new User();
		u2.setUsername("bhardwaj");
		userTo2.setUser(u2);
		userList.add(userTo2);

		return userList;
	}

}
