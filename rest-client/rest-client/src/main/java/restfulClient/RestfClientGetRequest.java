package restfulClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestfClientGetRequest {

	public static void select() {
		try {
			double startTime=startTime();
			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/restful-department/rest/department");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			double endTime=endTime();
			System.out.println("select time using restful is "+(endTime-startTime));

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
