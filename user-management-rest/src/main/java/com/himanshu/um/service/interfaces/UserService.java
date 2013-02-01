package com.himanshu.um.service.interfaces;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;

import com.himanshu.um.api.model.UserTO;

/*@Path("/user-service/")*/
public interface UserService {

	/*@GET
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_XML)*/
	UserTO getUser(/*@PathParam("name") */String username);

	/*@GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)*/
	List<UserTO> getAllUsers() throws DatatypeConfigurationException;

}
