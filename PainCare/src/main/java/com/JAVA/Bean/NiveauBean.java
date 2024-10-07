package com.JAVA.Bean;

public class NiveauBean {
	
	public int id;
	public int id_candidat;
	public String date;
	public String description;
	
	
	public NiveauBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public NiveauBean(int id, int id_candidat, String date, String description) {
		super();
		this.id = id;
		this.id_candidat = id_candidat;
		this.date = date;
		this.description = description;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_candidat() {
		return id_candidat;
	}
	public void setId_candidat(int id_candidat) {
		this.id_candidat = id_candidat;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
