package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EventDao {
 
	  @Autowired
	  private SessionFactory _sessionFactory;
	  
	  private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }

	  public void save(Event event) {
	    getSession().save(event);
	  }
	  
	  public void delete(Event event) {
	    getSession().delete(event);
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List getAll() {
	    return getSession().createQuery("from Event").list();
	  }
	  public User getByIdEventa(Integer idEventa) {
		    return (Event) getSession().load(User.class, idEventa);
		  }
 
	 
	  public User getByRemoved(Boolean removed) {
		    return (User) getSession().load(User.class, removed);
		  }
	  
	  public User getByReported(Boolean reported) {
		    return (User) getSession().load(User.class, reported);
		  }
	
	  public void update(Event event) {
	    getSession().update(event);
	  }
	 
	}
}  /* List<Messages> list = getSession.createCriteria(User.class)  
.add(Restrictions.eq("name", name))  
.list(); */ 
