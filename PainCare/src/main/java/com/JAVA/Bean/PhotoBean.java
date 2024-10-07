package com.JAVA.Bean;

public class PhotoBean {
	int id;
	int id_user;
	private byte[] photo; 
    
    private String photoBase64;
    
    
    
    

	public PhotoBean(int id, int id_user) {
		super();
		this.id = id;
		this.id_user = id_user;
	}

	public PhotoBean(int id, int id_user, byte[] photo) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.photo = photo;
	}

	public PhotoBean() {
		super();
	}

	public PhotoBean(int id, int id_user, byte[] photo, String photoBase64) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.photo = photo;
		this.photoBase64 = photoBase64;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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
    
    
    

}
