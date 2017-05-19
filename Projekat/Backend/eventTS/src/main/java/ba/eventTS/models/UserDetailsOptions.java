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
@Table(name="User_and_Options")
public class UserDetailsOptions implements Serializable{
	
	
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
	
	@ManyToOne(targetEntity=Options.class)
	@JoinColumn(name="idOption")
	private Options options;
*//*
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}
	*/
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

	public Integer getIdUsera() {
		return idUsera;
	}

	public void setIdUsera(Integer idUsera) {
		this.idUsera = idUsera;
	}

}
