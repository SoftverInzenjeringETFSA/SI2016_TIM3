package ba.eventTS.models;

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
import java.util.Date;

@Entity
@Table(name="Event")
public class Event implements Serializable {

	
	//Univerzalni identifikator klase koja je serijalizirana
	//Deserijalizacija koristi ovaj broj da osigura da podaci unutar klase adekvatno reaguju sa serijaliziranim objektom
	//Ukoliko nema poklapanja baca se izuzetak: InvalidClassException
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   
	@Column(name="idEventa")
	private Integer idEventa;
	
	@Column(name="reported")
	private Boolean reported;
	
	@Column(name="removed")
	private Boolean removed;
	
	@Column(name="voteDeadline")
	private Date voteDeadline;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idEventa")
	private List<PrijavljeniEventi> prijavljeniEventi;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idEventa")
	private List<Detail> detail;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idEventa")
	private List<Messages> messages;
	
	public Event(){
		
	}
	public Integer getIdEventa() {
		return idEventa;
	}

	public void setIdEventa(Integer idEventa) {
		this.idEventa = idEventa;
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

	public Date getVoteDeadline(){
		return voteDeadline;
	}
	
	public void setVoteDeadline(Date date) {
		this.voteDeadline = date;
	}
	
	public List<PrijavljeniEventi> getPrijavljeniEventi() {
		return prijavljeniEventi;
	}

	public void setPrijavljeniEventi(List<PrijavljeniEventi> prijavljeniEventi) {
		this.prijavljeniEventi = prijavljeniEventi;
	}


}
