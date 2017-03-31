package restfulClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClientDeleteRequest {

	public static void delete() {

		try {
			ClientResponse response = null;
			double startTime=	startTime();
			Client client = Client.create();

			for (int index = 0; index < 10000; index++) {
				WebResource webResource = client.resource("http://localhost:8080/restful-department/rest/department/delete/"+ index);
				response = webResource.type("application/json").delete(ClientResponse.class);
			}

			if (response.getStatus() != 204) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("delete done successfully");
			double endTime=endTime();
			System.out.println("delete time using restful is "+(endTime-startTime));

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
