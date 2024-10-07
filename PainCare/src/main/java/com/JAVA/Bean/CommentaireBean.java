package com.JAVA.Bean;

public class CommentaireBean {
	
	int id;
	int id_publication;
	int id_user;
	String commentaire;
	String nom;
	String prenom;
	
	
	
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
	public CommentaireBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public CommentaireBean(int id, int id_publication, int id_user, String commentaire, String nom, String prenom) {
		super();
		this.id = id;
		this.id_publication = id_publication;
		this.id_user = id_user;
		this.commentaire = commentaire;
		this.nom = nom;
		this.prenom = prenom;
	}
	public CommentaireBean(int id, int id_publication, int id_user, String commentaire) {
		super();
		this.id = id;
		this.id_publication = id_publication;
		this.id_user = id_user;
		this.commentaire = commentaire;
	}
	@Override
	public String toString() {
		return "CommentaireBean [id=" + id + ", id_publication=" + id_publication + ", id_user=" + id_user
				+ ", commentaire=" + commentaire + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_publication() {
		return id_publication;
	}
	public void setId_publication(int id_publication) {
		this.id_publication = id_publication;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	

}
