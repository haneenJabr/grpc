package restfulClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClientPostRequest {

	public static void insert() {

		try {
			ClientResponse response = null;
		double startTime=	startTime();
			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/restful-department/rest/department/post");

			for (int index =0; index < 10000; index++) {
				String result = "{\"deptNo\":\"" + index + "\",\"name\":\"hr\"}";
				response = webResource.type("application/json").post(ClientResponse.class, result);
			}

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			double endTime=	endTime();
			System.out.println("insert time using restful is "+(endTime-startTime));

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	private static double startTime() {
        return (double) (System.currentTimeMillis() / 1000);
    }
    private static double endTime() {
        return (double) (System.currentTimeMillis() / 1000);
    }

}
