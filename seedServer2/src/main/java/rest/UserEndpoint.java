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

   @Path("addUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
//  @Consumes(MediaType.APPLICATION_JSON)
    public String addUser(String content) throws PasswordStorage.CannotPerformOperationException {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        System.out.println("ddededuoguyguyuguygyuygu");
        String userName = "";
        String password = "";
//    String userRole ="";
        if (body.has("userName")) {
            userName = body.get("userName").getAsString();
        }
        if (body.has("password")) {
            password = body.get("password").getAsString();
        }

//     if (body.has("userRole"))
//     {
//         userRole= body.get("userRole").getAsString();
//     }
//     User user = null;
//        try {
//            user = new User(userName, password);
//        } catch (PasswordStorage.CannotPerformOperationException ex) {
//            ex.printStackTrace();
//        }
//     uf.addUser(user);
//   return new Gson().toJson(user);
        User user = new User(userName, password);
        user.addRole(uf.getRole("User"));
        uf.addUser(user);
        return new Gson().toJson(user);
    }
}
