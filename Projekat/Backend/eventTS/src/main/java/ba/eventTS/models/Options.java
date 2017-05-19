package ba.eventTS.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Options")
public class Options implements Serializable {
	
	//Univerzalni identifikator klase koja je serijalizirana
	//Deserijalizacija koristi ovaj broj da osigura da podaci unutar klase adekvatno reaguju sa serijaliziranim objektom
	//Ukoliko nema poklapanja baca se izuzetak: InvalidClassException
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   
	@Column(name="idOption")
	private Integer idOption;
	
	@Column(name="text")
	private String text;
	
	@ManyToOne(targetEntity=Detail.class)
	@JoinColumn(name="idDetail")
	private Event ideDetail;

	public Integer getIdOption() {
		return idOption;
	}

	public void setIdOption(Integer idOption) {
		this.idOption = idOption;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Event getIdeDetail() {
		return ideDetail;
	}

	public void setIdeDetail(Event ideDetail) {
		this.ideDetail = ideDetail;
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
