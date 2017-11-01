package security;

import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author lam
 */
public interface IUserFacade {

    /*
    Return the Roles if users could be authenticated, otherwise null
     */
    List<String> authenticateUser(String userName, String password);
    IUser getUserByUserId(String id);
  public void addEntityManagerFactory(EntityManagerFactory emf);
  public EntityManager getEntityManager();
  public User addUser (User user);
  public User deleteUser (int id);
 // public User getUser (int id);
  public List<User> getAllUsers();
  public User editUser(User user);
}
