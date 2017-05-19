package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class prijavljeniKorisniciiDao {
 
	  @Autowired
	  private SessionFactory _sessionFactory;
	  
	  private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }

	  public void save(PrijavljeniKorisnici prijavljeniKorisnici) {
	    getSession().save(prijavljeniKorisnici);
	  }
	  
	  public void delete(PrijavljeniKorisnici prijavljeniKorisnici) {
	    getSession().delete(prijavljeniKorisnici);
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List getAll() {
	    return getSession().createQuery("from PrijavljeniKorisnici").list();
	  }
	  public PrijavljeniKorisnici getByIdEventa(Integer idEventa){
		    return (PrijavljeniKorisnici) getSession().load(PrijavljeniKorisnici.class, idEventa);
		  }
 
	  public PrijavljeniEventi getByOpisPrijave(String opisPrijave) {
		  return (PrijavljeniEventi) getSession().createQuery(
			        "from PrijavljeniEventi where opisPrijave = :opisPrijave")
			        .setParameter("opisPrijave", opisPrijave)
			        .uniqueResult();
			  }
	  public PrijavljeniEventi getBySlika(String slika) {
		  return (PrijavljeniEventi) getSession().createQuery(
			        "from PrijavljeniEventi where slika :=slika")
			        .setParameter("slika",slika)
			        .uniqueResult();
			  }

	  public void update(PrijavljeniEventi prijavljeniEventi) {
	    getSession().update(prijavljeniEventi);
	  }
	 
	}
}   
