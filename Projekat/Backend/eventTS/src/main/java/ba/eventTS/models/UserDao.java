package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao {
 
	  @Autowired
	  private SessionFactory _sessionFactory;
	  
	  private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }

	  public void save(User user) {
	    getSession().save(user);
	  }
	  
	  public void delete(User user) {
	    getSession().delete(user);
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List getAll() {
	    return getSession().createQuery("from User").list();
	  }
	  public User getById(Integer idUsera) {
		    return (User) getSession().load(User.class, idUsera);
		  }
 
	  public User getByName(String name) {
		  return (User) getSession().createQuery(
			        "from User where name = :name")
			        .setParameter("name", name)
			        .uniqueResult();
			  }
	  public User getByLastname(String lastname) { return (User) getSession().createQuery(
		        "from User where lastname = :lastname")
		        .setParameter("lastname", lastname)
		        .uniqueResult();
		
	  }
	  public User getByEmail(String email) {
	    return (User) getSession().createQuery(
	        "from User where email = :email")
	        .setParameter("email", email)
	        .uniqueResult();
	  }
	  
	  public User getBy(String lastname) { return (User) getSession().createQuery(
		        "from User where lastname = :lastname")
		        .setParameter("lastname", lastname)
		        .uniqueResult();
		
	  }
	  public User getByPassword(String password) { return (User) getSession().createQuery(
		        "from User where password = :password")
		        .setParameter("password",password)
		        .uniqueResult();
	 }
	  public User getByRemoved(Boolean removed) {
		    return (User) getSession().load(User.class, removed);
		  }
	  
	  public User getByReported(Boolean reported) {
		    return (User) getSession().load(User.class, reported);
		  }
	  public User getByRole(Boolean role) {
		    return (User) getSession().load(User.class, role);
		  } 
	  
	  public void update(User user) {
	    getSession().update(user);
	  }
	 
	}
}  /* List<Messages> list = getSession.createCriteria(User.class)  
.add(Restrictions.eq("name", name))  
.list(); */ 
