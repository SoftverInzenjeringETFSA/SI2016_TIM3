package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MessagesDao {
 
	  @Autowired
	  private SessionFactory _sessionFactory;
	  
	  private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }

	  public void save(Messages messages) {
	    getSession().save(messages);
	  }
	  
	  public void delete(Messages messages) {
	    getSession().delete(messsages);
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List getAll() {
	    return getSession().createQuery("from Messagges").list();
	  }
	  public User getById(Integer idUsera) {
		    return (User) getSession().load(User.class, idUsera);
		  }
 
	  
	 public Messages getByText(String text) {
		  return (Messages) getSession().createQuery(
			        "from Messages where text = :text")
			        .setParameter("text", text)
			        .uniqueResult();
			  }
 
	  public Messages getByMessages(Date date) {
		  return (Messages) getSession().createQuery(
			        "from Messages where date = :date")
			        .setParameter("date", date)
			        .uniqueResult();
			  }
	  
	  public void update(Messages messages) {
	    getSession().update(messages);
	  }
	 
	}
}