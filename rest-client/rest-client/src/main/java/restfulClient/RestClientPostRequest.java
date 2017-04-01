package restfulClient;

import java.util.ArrayList;
import java.util.List;

import com.progressoft.jpa.entities.Department;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClientPostRequest {

	public static void main(String[] args) {

		try {
			ClientResponse response = null;
			
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/restful-department/rest/department/post");
			List<Department> list = fillDepartments();
			double startTime = startTime();
			for (int i = 0; i < 100000; i++) {
			response = webResource.type("application/json").post(ClientResponse.class, list);
			}
			double endTime = endTime();
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("request time using restful is " + (endTime - startTime));

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private static List<Department> fillDepartments() {
		List<Department> list = new ArrayList<>();
		for (int index = 0; index < 100000; index++) {
			Department department = new Department();
			department.setDeptNo(String.valueOf(index));
			department.setName("hr");
			list.add(department);
		}
		return list;
	}

	private static double startTime() {
		return (double) (System.currentTimeMillis());
	}

	private static double endTime() {
		return (double) (System.currentTimeMillis());
	}

}
