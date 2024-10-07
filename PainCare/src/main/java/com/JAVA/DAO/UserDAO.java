package com.JAVA.DAO;

import com.JAVA.Bean.UserBean;

public interface UserDAO {
	
	void create( UserBean User ) throws DAOException;

	 UserBean find( String nom ) throws DAOException;
	 
	 UserBean[] getall() throws DAOException;

	 void delete(int id) throws DAOException;

	 void delete(String nom) throws DAOException;
	 
	 void loginUser() throws DAOException;

}
