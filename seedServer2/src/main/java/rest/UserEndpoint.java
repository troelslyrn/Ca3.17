package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import deploy.DeploymentConfiguration;
import entity.User;
import facades.UserFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import security.PasswordStorage;

@Path("xxx")
//@RolesAllowed("User")
public class UserEndpoint {

    private UserFacade uf;
    private Gson gson;

    public UserEndpoint() {
        uf = new UserFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
        gson = new Gson();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomething() {
        return "{\"message\" : \"Hello User from Server (Accesible by only authenticated USERS)\"}";
    }

    @Path("message")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage() {
        return "{\"message\" : \"test message\"}";
    }

    @Path("adduser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postPerson(String content) throws PasswordStorage.CannotPerformOperationException {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        String userName = "";
        String passWord = "";

        if (body.has("userName")) {
            userName = body.get("userName").getAsString();
        }
        if (body.has("password")) {
            passWord = body.get("password").getAsString();
        }

        User u = new User(userName, passWord);
        uf.addUser(u);
        return new Gson().toJson(u);
    }
}
