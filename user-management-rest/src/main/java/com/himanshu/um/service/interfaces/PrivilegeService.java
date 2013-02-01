package com.himanshu.um.service.interfaces;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.himanshu.um.api.model.PrivilegeTO;

/*@Path("/privilege-service/")*/
public interface PrivilegeService {

	/*@GET
    @Path("/privileges")
    @Produces(MediaType.APPLICATION_XML)*/
	List<PrivilegeTO> getAllPrivileges();
}
