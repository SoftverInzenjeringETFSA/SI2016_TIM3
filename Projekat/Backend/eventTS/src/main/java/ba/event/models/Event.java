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

@Entity
@Table(name="Event")
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   
	@Column(name="idEventa")
	private Integer idEventa;
	
	@Column(name="reported")
	private Boolean reported;
	
	@Column(name="removed")
	private Boolean removed;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idEventa")
	private List<PrijavljeniEventi> prijavljeniEventi;
	
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

	public List<PrijavljeniEventi> getPrijavljeniEventi() {
		return prijavljeniEventi;
	}

	public void setPrijavljeniEventi(List<PrijavljeniEventi> prijavljeniEventi) {
		this.prijavljeniEventi = prijavljeniEventi;
	}


}
