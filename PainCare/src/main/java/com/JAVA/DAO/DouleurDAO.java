package com.JAVA.DAO;

import com.JAVA.Bean.DouleurBean;

public interface DouleurDAO {
	
	void create( DouleurBean Douleur ) throws DAOException;

	 DouleurBean find( String nom ) throws DAOException;
	 
	 DouleurBean[] getall() throws DAOException;

	 void delete(int id) throws DAOException;

	 void delete(String nom) throws DAOException;
	 
	 void loginDouleur() throws DAOException;

	 void ajouterDouleur() throws DAOException;
}
