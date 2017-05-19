package ba.eventTS.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class testModelUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  @Size(min = 3, max = 80)
  private String email;
  
  @NotNull
  @Size(min = 2, max = 80)
  private String name;

  public testModelUser() { }

  public testModelUser(long id) { 
    this.id = id;
  }

  public testModelUser(String email, String name) {
    this.email = email;
    this.name = name;
  }

public char[] getId() {
	// TODO Auto-generated method stub
	return null;
}

  // Getter and setter methods ...
  
}