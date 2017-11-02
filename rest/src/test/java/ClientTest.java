import com.cat.zsy.rest.entity.*;

import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

public class ClientTest {

    public static void main(String[] args) {
        Client client = ClientBuilder.newBuilder().build();
//        client.register();

        WebTarget target = client
                .target("http://localhost:8080/")
                .path("/users");
        Invocation invocation = target.request().build(HttpMethod.POST, Entity.entity(new User(), MediaType.APPLICATION_FORM_URLENCODED));
        Response response = invocation.invoke();
        System.out.println(response.readEntity(String.class));

    }
}
