package restfulClient;

import java.util.ArrayList;
import java.util.List;

import com.progressoft.jpa.entities.Department;
import com.progressoft.jpa.entities.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @author u538
 *
 */
public class RestClientPostRequest {

	public static void main(String[] args) {

		try {
			ClientResponse response = null;
			WebResource webResource = createClient()
					.resource("http://localhost:8080/restful-department/rest/department/post");
			List<Department> list = fillDepartments();
			double startTime = startTime();
			for(int i=0; i<1000;i++){
			 response = webResource.type("application/json").post(ClientResponse.class, list);
			}
			double endTime = endTime();
			checkIfFailed(response);
			System.out.println("request time using restful is " + (endTime - startTime));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Client createClient() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		return client;
	}

	private static void checkIfFailed(ClientResponse response) {
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
	}

	private static List<Department> fillDepartments() {
		List<Department> list = new ArrayList<>();
		for (int index = 0; index < 1000; index++) {
			Department department = new Department();
			department.setDeptNo(String.valueOf(index));
			department.setName("hr");
			department.setDescription(
					"this is human resource department ,the department in an organization dealing with matters involving employees, as hiring, training, labor relations, and benefits");
			department.setEmployees(fillEmployees());
			list.add(department);
		}
		return list;
	}

	private static List<Employee> fillEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Employee employee = new Employee();
			employee.setId(i);
			employee.setEmployeeName("haneen");
			employee.setBirthDate("07/01/1992");
			employee.setPhone(124567893);
			employees.add(employee);
		}
		return employees;
	}

	private static double startTime() {
		return (double) (System.currentTimeMillis());
	}

	private static double endTime() {
		return (double) (System.currentTimeMillis());
	}
}
