
package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DetailDao {
 
	  @Autowired
	  private SessionFactory _sessionFactory;
	  
	  private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }

	  public void save(Detail detail) {
	    getSession().save(detail);
	  }
	  
	  public void delete(Detail detail) {
	    getSession().delete(detail);
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List getAll() {
	    return getSession().createQuery("from Detail").list();
	  }
	  public User getById(Integer idDetail) {
		    return (Detail) getSession().load(Detail.class, idDetail);
		  }
 
	  public Detail getByDetailName(String detailName) {
		  return (Detail) getSession().createQuery(
			        "from Detail where detailName = :detailName")
			        .setParameter("detailName", detailName)
			        .uniqueResult();
			  }
	  public Detail getByDetailDescription(String detailDescription) { return (Detail) getSession().createQuery(
		        "from User where detailDescription = :detailDescription")
		        .setParameter("detailDescription", detailDescription)
		        .uniqueResult();
		
	  }
	  public Detail getByEvent(Event event) {
	    return (User) getSession().createQuery(
	        "from User where event = :event")
	        .setParameter("event", event)
	        .uniqueResult();
	  }
	  public void update(Detail detail) {
	    getSession().update(detail);
	  }
	 
	}
}  /* List<Messages> list = getSession.createCriteria(User.class)  
.add(Restrictions.eq("name", name))  
.list(); */ 
