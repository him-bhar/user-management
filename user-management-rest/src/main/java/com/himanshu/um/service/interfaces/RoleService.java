package com.himanshu.um.service.interfaces;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.himanshu.um.api.model.RoleTO;

/*@Path("/role-service/")*/
public interface RoleService {

	/*@GET
    @Path("/roles")
    @Produces(MediaType.APPLICATION_XML)*/
	List<RoleTO> getAllRoles();


}
