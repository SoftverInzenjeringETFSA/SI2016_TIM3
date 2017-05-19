package ba.eventTS.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="User_and_Event")
public class UsersAndEvents implements Serializable {
	
	//Univerzalni identifikator klase koja je serijalizirana
	//Deserijalizacija koristi ovaj broj da osigura da podaci unutar klase adekvatno reaguju sa serijaliziranim objektom
	//Ukoliko nema poklapanja baca se izuzetak: InvalidClassException
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="SharedPrimaryKeyGenerator")
	@GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="User"))
	@Column(name = "idUsera", unique = true, nullable = false)
	private Integer idUsera;
	/*
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="idUsera")
	private User user;
	
	@ManyToOne(targetEntity=Event.class)
	@JoinColumn(name="idEventa")
	private Event event;
*//*
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	*/
	public Integer getIdUsera() {
		return idUsera;
	}
	public void setIdUsera(Integer idUsera) {
		this.idUsera = idUsera;
	}
	
	//Ako ne bude radilo vidi ovo:
	/*	@Id
	@GeneratedValue(generator="SharedPrimaryKeyGenerator")
	@GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="", value=""))
	@Column(name = "", unique = , nullable = 
	private Integer ;
	 * 
	 * 
	 * 
	 * 
	 */

}
