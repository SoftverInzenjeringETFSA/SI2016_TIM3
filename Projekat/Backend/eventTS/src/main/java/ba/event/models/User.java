package ba.event.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



//TODO foreign kljuceve gdje treba 
//@OneToOne 1-1
//@OneToMany 1-n
//@ManyToOne n-1
//@JoinColumn(name="id primarnog kljuca, za ovo tabelu je id")



@Entity
@Table(name="User")
public class User implements Serializable {
	
	
	//Univerzalni identifikator klase koja je serijalizirana
	//Deserijalizacija koristi ovaj broj da osigura da podaci unutar klase adekvatno reaguju sa serijaliziranim objektom
	//Ukoliko nema poklapanja baca se izuzetak: InvalidClassException
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)     
	@Column(name="idUsera")
	private Integer idUsera;
	
	//Povezivanja sa ostalim tabelama, tj. UserAndEvents, Message, PrijavljeniKorisnici, UserDetailsOptions
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idUsera")
	private List<Messages> messages;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idUsera")
	private List<UsersAndEvents> usersAndEvents;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idUsera")
	private List<PrijavljeniKorisnici> prijavljeniKorisnici;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idUsera")
	private List<UserDetailsOptions> userDetailsOptions;
	
	@Column(name="name")    //@NotNull ako bude trebalo moze
	private String name;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="reported")
	private Boolean reported;
	
	@Column(name="removed")
	private Boolean removed;
	
	@Column(name="role")
	private Boolean role;
	
	public User(){
		//Treba nekad
	}
	public Integer getId() {
		return idUsera;
	}
	public void setId(Integer id) {
		this.idUsera = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getReported() {
		return reported;
	}
	
	public void setReported(Boolean reported) {
		this.reported = reported;
	}
	
	public Boolean getRemoved() {
		return removed;
	}
	
	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}
	
	public Boolean getRole() {
		return role;
	}
	
	public void setRole(Boolean role) {
		this.role = role;
	}
	

	

}
