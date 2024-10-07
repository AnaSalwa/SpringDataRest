package com.JAVA.Bean;

public class PubBean {
	
		
		private int id;
		
		private int id_user;
		
		private String titre;
		
		private String description;
		
		private String nom ;
		
		private String prenom;
		
	    private byte[] photo; 
	    
	    private String photoBase64;


	    public String getPhotoBase64() {
	        return photoBase64;
	    }

	    public void setPhotoBase64(String photoBase64) {
	        this.photoBase64 = photoBase64;
	    }

		
		
		public byte[] getPhoto() {
			return photo;
		}

		public void setPhoto(byte[] photo) {
			this.photo = photo;
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
		
		
		
		
		
		public PubBean(int id, int id_user, String titre, String description, byte[] photo) {
			super();
			this.id = id;
			this.id_user = id_user;
			this.titre = titre;
			this.description = description;
			this.photo = photo;
		}
		
		

		public PubBean(int id, int id_user, String titre, String description, String nom, String prenom, byte[] photo) {
		    super();
		    this.id = id;
		    this.id_user = id_user;
		    this.titre = titre;
		    this.description = description;
		    this.nom = nom;
		    this.prenom = prenom;
		    this.photo = photo;
		}

		public PubBean(int id, int id_user, String titre, String description, String nom, byte[] photo) {
		    super();
		    this.id = id;
		    this.id_user = id_user;
		    this.titre = titre;
		    this.description = description;
		    this.nom = nom;
		    this.photo = photo;
		}


		public PubBean(int id, int id_user, String titre, String description, String nom, String prenom) {
			super();
			this.id = id;
			this.id_user = id_user;
			this.titre = titre;
			this.description = description;
			this.nom = nom;
			this.prenom = prenom;
		}

		public PubBean(int id, int id_user, String titre, String description, String nom) {
			super();
			this.id = id;
			this.id_user = id_user;
			this.titre = titre;
			this.description = description;
			this.nom = nom;
		}

		@Override
		public String toString() {
			return "PublicationBean [id=" + id + ", id_user=" + id_user + ", titre=" + titre + ", description="
					+ description + "]";
		}

		public PubBean() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PubBean(int id, int id_user, String titre, String description) {
			super();
			this.id = id;
			this.id_user = id_user;
			this.titre = titre;
			this.description = description;
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

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		
		
		
		
		

	


}
