package com.progressoft.restful;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.progressoft.jpa.entities.Department;

/**
 * @author u538
 *
 */
@Path("/department")
public class DepartmentRestService {
	
	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postDepartment(List<Department> departments) {
		return Response.status(201).build();
	}
}
