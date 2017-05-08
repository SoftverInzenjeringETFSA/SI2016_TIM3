package com.tim3.dogovor_za_izlazak.entity;


public class ReportedUsers {
	
	int uid;
	String opisPrijave;
	String urlSlike;
	
	public ReportedUsers(String opisPrijave, String urlSlike) {
		super();
		this.opisPrijave = opisPrijave;
		this.urlSlike = urlSlike;
	}

	public String getOpisPrijave() {
		return opisPrijave;
	}

	public void setOpisPrijave(String opisPrijave) {
		this.opisPrijave = opisPrijave;
	}

	public String getUrlSlike() {
		return urlSlike;
	}

	public void setUrlSlike(String urlSlike) {
		this.urlSlike = urlSlike;
	}
	
	

}
