package com.JAVA.Bean;

import java.util.Date;

public class DouleurBean {
    private int id;
    private int id_user;  // Assurez-vous de remplacer le type par le type réel de votre identifiant utilisateur
    private int degre;
    private String sentiment;

    private String localisation;
    private String date;

    // Constructeur par défaut
    public DouleurBean() {
    }

    public DouleurBean(int id, int id_user, int degre, String sentiment, String localisation, String date) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.degre = degre;
		this.sentiment = sentiment;
		this.localisation = localisation;
		this.date = date;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	// Constructeur avec tous les champs
    public DouleurBean(int id, int id_user, int degre, String localisation, String date) {
        this.id = id;
        this.id_user = id_user;
        this.degre = degre;
        this.localisation = localisation;
        this.date = date;
    }

    // Getters et setters

    public DouleurBean(int i, int id_user2, int j, Object object, java.sql.Date date2) {
		// TODO Auto-generated constructor stub
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

    public int getDegre() {
        return degre;
    }

    public void setDegre(int degre) {
        this.degre = degre;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

	public void setDate(java.sql.Date date2) {
		// TODO Auto-generated method stub
		
	}

	
}
