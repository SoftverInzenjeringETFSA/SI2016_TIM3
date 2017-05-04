package com.Tim3.Model;

public class Detail {
	
	int detail_id;
	int event_id;
	String detailName;
	String detailDescription;
	
	public Detail(String detailName, String detailDescription) {
		super();
		this.detailName = detailName;
		this.detailDescription = detailDescription;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	
	

}
