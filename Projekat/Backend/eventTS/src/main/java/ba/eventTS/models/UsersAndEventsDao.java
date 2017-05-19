package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserAndEventsDao {
 
	  @Autowired
	  private SessionFactory _sessionFactory;
	  
	  private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }

	  public void save(UserAndEvents UserAndEvents) {
	    getSession().save(userAndEvents);
	  }
	  
	  public void delete(UserAndEvents userAndEvents) {
	    getSession().delete(userAndEvents);
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List getAll() {
	    return getSession().createQuery("from UserAndEvents").list();
	  }
	  public UserAndEvents getByIdUsera(Integer idUsera){
		    return (UserAndEvents) getSession().load(UserAndEvents.class, idUsera);
		  }
 
	
	  public void update(UserAndEvents userAndEvents) {
		    getSession().update(userAndEvents);
		  }
       }
	  
	}
}   
