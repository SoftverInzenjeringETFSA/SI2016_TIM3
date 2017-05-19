package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDetailsOptionsDao {
 
	  @Autowired
	  private SessionFactory _sessionFactory;
	  
	  private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }

	  public void save(UserDetailsOptions userDetailsOptions) {
	    getSession().save(userDetailsOptions);
	  }
	  
	  public void delete(UserDetailsOptions userDetailsOptions) {
	    getSession().delete(userDetailsOptions);
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List getAll() {
	    return getSession().createQuery("from UserDetailsOptions").list();
	  }
	  public UserDetailsOptions getByIdUsera(Integer idUsera){
		    return (UserDetailsOptions) getSession().load(UserDetailsOptions.class, idUsera);
		  }
 
	
	  public void update(UserDetailsOptions userDetailOptions) {
		    getSession().update(userDetailOptions);
		  }
       }
	  
	}
}   
