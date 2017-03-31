/**
* 
*/
package com.progressoft.restful;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.progressoft.jpa.entities.Department;

import repository.DepartmentRepository;
import repository.DepartmentRepositoryImpl;

/**
 * @author u538
 *
 */
@Path("/department")
public class DepartmentRestService {

	private DepartmentRepository repository = new DepartmentRepositoryImpl();

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Department getDepartmentInfoAsJson(@PathParam("id") String id) {
		return repository.get(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertDepartmentInfoAsJson(Department department) {
		repository.add(department);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateDepartment(Department department) {
		repository.update(department);
	}

	@DELETE
	@Path("/delete/{deptId}")
	public void deleteDepartment(@PathParam("deptId") String deptId) {
		repository.delete(deptId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> listAllDepartment() {
		return repository.listAllDepartments();
	}

}
