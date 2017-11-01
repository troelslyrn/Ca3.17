package facades;

import security.IUserFacade;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

  EntityManagerFactory emf;

  public UserFacade(EntityManagerFactory emf) {
    this.emf = emf;   
  }

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  @Override
  public IUser getUserByUserId(String id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(User.class, id);
    } finally {
      em.close();
    }
  }

  /*
  Return the Roles if users could be authenticated, otherwise null
   */
  @Override
  public List<String> authenticateUser(String userName, String password) {
    try {
      System.out.println("User Before:" + userName+", "+password);
      IUser user = getUserByUserId(userName);  
      System.out.println("User After:" + user.getUserName()+", "+user.getPasswordHash());
      return user != null && PasswordStorage.verifyPassword(password, user.getPasswordHash()) ? user.getRolesAsStrings() : null;
    } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
      throw new NotAuthorizedException("Invalid username or password", Response.Status.FORBIDDEN);
    }
  }

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User addUser(User user) {
         EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public User deleteUser(int id) {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            em.remove(user);
            em.getTransaction().commit();
            return user;
        }
        finally
        {
            em.close();
        }  
    }

    @Override
    public List<User> getAllUsers() {
                  EntityManager em = emf.createEntityManager();

        try
        {
            return em.createQuery("SELECT user FROM User user").getResultList();
        }
        finally
        {
            em.close();
        }

    }

    @Override
    public User editUser(User user) {
         EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            User u = em.find(User.class, user.getId());
            if(user != null)
            {
               u = user;
               em.merge(u);
                em.getTransaction().commit();
                return u;
            }
        }
        finally
        {
            em.close();
        }  
        
        return null;
    }

   
//    @Override
//    public User editUser(User user) {
//        EntityManager em = emf.createEntityManager();
//
//        try
////        {
////            em.getTransaction().begin();
////            User u = em.find(User.class, user.getId());
//            if(user != null)
//            {
//                person = p;
//                em.merge(person);
//                em.getTransaction().commit();
//                return person;
//            }
//        }
//        finally
//        {
//            em.close();
//        }  
//        
//        return null;
//        
//    }

}