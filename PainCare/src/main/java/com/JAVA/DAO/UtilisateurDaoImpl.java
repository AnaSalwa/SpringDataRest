package com.JAVA.DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;



import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;

import com.JAVA.Bean.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


/**
 * Servlet implementation class PublicationServlet
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // Limite de taille du fichier (ici, 5 Mo)

public class UtilisateurDaoImpl {
	
	private DAOFactory          daoFactory;

    public UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	public UtilisateurDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void create(UtilisateurBean Utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static UtilisateurBean map( ResultSet resultSet ) throws SQLException {
			UtilisateurBean UtilisateurBean = new UtilisateurBean();
			UtilisateurBean.setId((int)resultSet.getLong( "id" ) );
			UtilisateurBean.setNom( resultSet.getString( "nom" ) );
			UtilisateurBean.setEmail( resultSet.getString( "email" ) );
			UtilisateurBean.setPrenom( resultSet.getString( "prenom" ) );
			return UtilisateurBean;
	}
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
		    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
		    for ( int i = 0; i < objets.length; i++ ) {
		        preparedStatement.setObject( i + 1, objets[i] );
		    }
		    return preparedStatement;
	}
	
	
	
	
	public UtilisateurBean loginUtilisateur(String email, String password) {
	    UtilisateurBean utilisateur = null;
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = daoFactory.getConnection();

	        // Mettez à jour votre requête SQL pour inclure la colonne de la photo
	        String query = "SELECT id, nom, prenom, email, photo FROM Utilisateur WHERE email = ? AND password = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, password);

	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            utilisateur = new UtilisateurBean();
	            utilisateur.setId(resultSet.getInt("id"));
	            utilisateur.setNom(resultSet.getString("nom"));
	            utilisateur.setPrenom(resultSet.getString("prenom"));
	            utilisateur.setEmail(resultSet.getString("email"));

	            // Récupérez la colonne de la photo comme tableau de bytes
	            Blob photoBlob = resultSet.getBlob("photo");
	          
	            byte[] photoBytes = null;
	            if (photoBlob != null) {
	                photoBytes = photoBlob.getBytes(1, (int) photoBlob.length());
	            }

	            // Définissez la photo dans l'objet UtilisateurBean
	            utilisateur.setPhoto(photoBytes);
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	        // Fermez les ressources dans le bloc finally
	        // ClosingAll(resultSet, preparedStatement, connection);
	    }

	    return utilisateur;
	}


	 
	 
	 


		
		public  void  deleteUtilisateur(String nom) throws DAOException {
		    final String SQL_DELETE = "DELETE FROM Utilisateur WHERE nom = ?";

		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = connexion.prepareStatement(SQL_DELETE);
		        preparedStatement.setString(1, nom); // Utilisez l'ID de l'utilisateur à supprimer
		        preparedStatement.executeUpdate(); // Exécute la suppression
		    } catch (SQLException e) {
		        throw new DAOException(e);
		    } finally {
		        // ClosingAll(preparedStatement, connexion);
		    }
		}
		
		
	    
	    public void updateUtilisateur(UtilisateurBean Utilisateur) throws DAOException {
	        final String SQL_UPDATE = "UPDATE Utilisateur SET nom=?, prenom=?, email=?, password=? WHERE id=?";

	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            /* Récupération d'une connexion depuis la Factory */
	            connection = daoFactory.getConnection();
	            preparedStatement = connection.prepareStatement(SQL_UPDATE);

	            preparedStatement.setString(1, Utilisateur.getNom());
	            preparedStatement.setString(2, Utilisateur.getPrenom());
	            preparedStatement.setString(3, Utilisateur.getEmail());
	            preparedStatement.setString(4, Utilisateur.getPassword());
	            preparedStatement.setInt(5, Utilisateur.getId()); // Supposons que votre UtilisateurBean ait une propriété "id"

	            preparedStatement.executeUpdate(); // Exécute la mise à jour
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            // Fermez les ressources (PreparedStatement et Connection) dans le bloc finally
	            // ClosingAll(preparedStatement, connection);
	        }
	    }
	    
	    
	    
	    public void insertUtilisateur(UtilisateurBean Utilisateur) throws DAOException {
	        final String SQL_UPDATE = "INSERT INTO Utilisateur (nom, prenom, email, password) VALUES (?, ?, ?, ?)";

	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            /* Récupération d'une connexion depuis la Factory */
	            connection = daoFactory.getConnection();
	            preparedStatement = connection.prepareStatement(SQL_UPDATE);

	            preparedStatement.setString(1, Utilisateur.getNom());
	            preparedStatement.setString(2, Utilisateur.getPrenom());
	            preparedStatement.setString(3, Utilisateur.getEmail());
	            preparedStatement.setString(4, Utilisateur.getPassword());

	            preparedStatement.execute(); // Exécute la mise à jour
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            // Fermez les ressources (PreparedStatement et Connection) dans le bloc finally
	            // ClosingAll(preparedStatement, connection);
	        }
	    }
	    
	    
	    
	    

	    
	    
	    public boolean checkPassword(int UtilisateurId, String enteredPassword) throws DAOException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = daoFactory.getConnection();
	            String query = "SELECT id FROM Utilisateur WHERE id = ? AND password = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, UtilisateurId);
	            preparedStatement.setString(2, enteredPassword);
	            resultSet = preparedStatement.executeQuery();

	            return resultSet.next(); // Returns true if a matching Utilisateur is found
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            // Close resources (ResultSet, PreparedStatement, and Connection) in the finally block
	        }
	    }
	    
	    
	    public String effectuerDiagnostic(String taille, String poids, String q1, String q2, String q3) {
	        // Effectuer le diagnostic en fonction des réponses
	        // Vous pouvez utiliser une structure de contrôle (if, switch) pour évaluer les réponses et générer le diagnostic.

	        // Exemple de traitement simplifié :
	        String diagnostic = "Aucun diagnostic spécifique.";

	        if (q1.equals("age1") && q2.equals("moinsDe27") && q3.equals("oui")) {
	            diagnostic = "Vous pourriez être à risque d'endométriose. Consultez un professionnel de la santé pour plus d'informations.";
	        } else if (q1.equals("age2") && q2.equals("plusDe27") && q3.equals("non")) {
	            diagnostic = "Il est peu probable que vous ayez l'endométriose, mais consultez un professionnel de la santé pour confirmer.";
	        }

	        return diagnostic;
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	

}
