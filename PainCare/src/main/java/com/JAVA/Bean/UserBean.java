package com.JAVA.Bean;

public class UserBean {
	
	private int      id;
    private String    nom;
    private String    prenom;
    private String    email;
    private String    password;
    private byte[] photo; 
    
    private String photoBase64;
    
    
    
    
    
    
    
    
    
	public UserBean(int id, String nom, String prenom, String email, String password, byte[] photo) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.photo = photo;
	}






	public UserBean(int id, String nom, String prenom, String email, String password, byte[] photo,
			String photoBase64) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.photo = photo;
		this.photoBase64 = photoBase64;
	}






	public byte[] getPhoto() {
		return photo;
	}






	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}






	public String getPhotoBase64() {
		return photoBase64;
	}






	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}






	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	



	@Override
	public String toString() {
		return "UserBean [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + "]";
	}






	public UserBean(int id, String nom, String prenom, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
    
    
    

}
