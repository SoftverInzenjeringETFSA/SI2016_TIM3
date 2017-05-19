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
@Table(name="Prijavljeni_Korisnici")
public class PrijavljeniKorisnici implements Serializable{
	
	
	//Univerzalni identifikator klase koja je serijalizirana
	//Deserijalizacija koristi ovaj broj da osigura da podaci unutar klase adekvatno reaguju sa serijaliziranim objektom
	//Ukoliko nema poklapanja baca se izuzetak: InvalidClassException
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="SharedPrimaryKeyGenerator")
	@GenericGenerator(name="SharedPrimaryKeyGenerator",strategy="foreign",parameters =  @Parameter(name="property", value="Event"))
	@Column(name = "idEventa", unique = true, nullable = false)
	private Integer idEventa;
	/*
	@ManyToOne(targetEntity=Event.class)
	@JoinColumn(name="idEventa")
	private Event event;
	*/
	@Column(name="opisPrijave")
	private String opisPrijave;
	
	@Column(name="slika")
	private String slika;
/*
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
*/
	public String getOpisPrijave() {
		return opisPrijave;
	}

	public Integer getIdEventa() {
		return idEventa;
	}

	public void setIdEventa(Integer idEventa) {
		this.idEventa = idEventa;
	}

	public void setOpisPrijave(String opisPrijave) {
		this.opisPrijave = opisPrijave;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
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
