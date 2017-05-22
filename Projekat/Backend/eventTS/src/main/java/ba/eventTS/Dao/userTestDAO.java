package ba.eventTS.models;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class userTestDAO {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private org.hibernate.Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(testModelUser user) {
    getSession().save(user);
  }
  
  public void delete(testModelUser user) {
    getSession().delete(user);
  }
  
  @SuppressWarnings("unchecked")
  public List getAll() {
    return getSession().createQuery("from testModelUser").list();
  }
  
  public testModelUser getByEmail(String email) {
    return (testModelUser) getSession().createQuery(
        "from testModelUser where email = :email")
        .setParameter("email", email)
        .uniqueResult();
  }

  public testModelUser getById(long id) {
    return (testModelUser) getSession().load(testModelUser.class, id);
  }

  public void update(testModelUser user) {
    getSession().update(user);
  }

}/****/