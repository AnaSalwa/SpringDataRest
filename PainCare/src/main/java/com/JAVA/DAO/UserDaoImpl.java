package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import com.JAVA.Bean.UserBean;



public class UserDaoImpl {
	
	private DAOFactory          daoFactory;

    public UserDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void create(UserBean User) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static UserBean map( ResultSet resultSet ) throws SQLException {
			UserBean UserBean = new UserBean();
			UserBean.setId((int)resultSet.getLong( "id" ) );
			UserBean.setNom( resultSet.getString( "nom" ) );
			UserBean.setEmail( resultSet.getString( "email" ) );
			UserBean.setPrenom( resultSet.getString( "prenom" ) );
			return UserBean;
	}
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
		    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
		    for ( int i = 0; i < objets.length; i++ ) {
		        preparedStatement.setObject( i + 1, objets[i] );
		    }
		    return preparedStatement;
	}
	
	
	 public UserBean loginUser(String email, String password) {
	       	UserBean User = null;
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        try {
	            connection = daoFactory.getConnection();

	            String query = "SELECT * FROM User WHERE email = ? AND password = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                User = new UserBean();
	                User.setId(resultSet.getInt("id"));
	                User.setNom(resultSet.getString("nom"));
	                User.setPrenom(resultSet.getString("prenom"));
	                User.setEmail(resultSet.getString("email"));
	                
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	        }

	        return User;
	    }
	 
	 
	 


		
		public  void  deleteUser(String nom) throws DAOException {
		    final String SQL_DELETE = "DELETE FROM user WHERE nom = ?";

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
		
		
	    
	    public void updateUser(UserBean user) throws DAOException {
	        final String SQL_UPDATE = "UPDATE user SET nom=?, prenom=?, email=?, password=? WHERE id=?";

	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            /* Récupération d'une connexion depuis la Factory */
	            connection = daoFactory.getConnection();
	            preparedStatement = connection.prepareStatement(SQL_UPDATE);

	            preparedStatement.setString(1, user.getNom());
	            preparedStatement.setString(2, user.getPrenom());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getPassword());
	            preparedStatement.setInt(5, user.getId()); // Supposons que votre UserBean ait une propriété "id"

	            preparedStatement.executeUpdate(); // Exécute la mise à jour
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            // Fermez les ressources (PreparedStatement et Connection) dans le bloc finally
	            // ClosingAll(preparedStatement, connection);
	        }
	    }
	    
	    
	    
	    public void insertUser(UserBean user) throws DAOException {
	        final String SQL_UPDATE = "INSERT INTO user (nom, prenom, email, password) VALUES (?, ?, ?, ?)";

	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            /* Récupération d'une connexion depuis la Factory */
	            connection = daoFactory.getConnection();
	            preparedStatement = connection.prepareStatement(SQL_UPDATE);

	            preparedStatement.setString(1, user.getNom());
	            preparedStatement.setString(2, user.getPrenom());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getPassword());

	            preparedStatement.execute(); // Exécute la mise à jour
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            // Fermez les ressources (PreparedStatement et Connection) dans le bloc finally
	            // ClosingAll(preparedStatement, connection);
	        }
	    }
	    
	    
	    
	    

	    
	    
	    public boolean checkPassword(int userId, String enteredPassword) throws DAOException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = daoFactory.getConnection();
	            String query = "SELECT id FROM user WHERE id = ? AND password = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, userId);
	            preparedStatement.setString(2, enteredPassword);
	            resultSet = preparedStatement.executeQuery();

	            return resultSet.next(); // Returns true if a matching user is found
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
