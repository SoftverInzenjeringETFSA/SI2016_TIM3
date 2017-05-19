package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class OptionsDao {
 
	  @Autowired
	  private SessionFactory _sessionFactory;
	  
	  private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }

	  public void save(Options options) {
	    getSession().save(options);
	  }
	  
	  public void delete(Options options) {
	    getSession().delete(options);
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List getAll() {
	    return getSession().createQuery("from Options").list();
	  }
	  public Options getById(Integer idOption) {
		    return (Options) getSession().load(Options.class, idOption);
		  }
 
	  public Options getByText(String text) {
		  return (Options) getSession().createQuery(
			        "from Options where text = :text")
			        .setParameter("text", text)
			        .uniqueResult();
			  }
	  public Options getByIdeDetail(Event ideDetail) { return (Options) getSession().createQuery(
		        "from Options where ideDetail = :ideDetail")
		        .setParameter("ideDetail", ideDetail)
		        .uniqueResult();
		
	  }
	  public void update(Options options) {
	    getSession().update(options);
	  }
	 
	}
}   
