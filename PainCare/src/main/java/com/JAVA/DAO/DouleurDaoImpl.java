package com.JAVA.DAO;



import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.JAVA.Bean.CommentaireBean;
import com.JAVA.Bean.DouleurBean;




public class DouleurDaoImpl {
	
	

    private DAOFactory daoFactory;

    public DouleurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	

    
	public DouleurDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void create(DouleurBean Douleur) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static DouleurBean map( ResultSet resultSet ) throws SQLException {
			DouleurBean DouleurBean = new DouleurBean();
			DouleurBean.setId((int)resultSet.getInt( "id" ) );
			DouleurBean.setDegre( resultSet.getInt( "degre" ) );
			DouleurBean.setLocalisation( resultSet.getString( "localisation" ) );
			
//			DouleurBean.setDate( resultSet.getDate( "date" ) );
			return DouleurBean;
	}
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
		    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
		    for ( int i = 0; i < objets.length; i++ ) {
		        preparedStatement.setObject( i + 1, objets[i] );
		    }
		    return preparedStatement;
	}
	
	
	 
	 
	    public void insertDouleur(DouleurBean douleur) throws DAOException {
	        final String SQL_INSERT = "INSERT INTO douleur (id_user, degre,sentiment, localisation, date) VALUES (?, ?,?, ?, ?)";

	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = daoFactory.getConnection();
	            preparedStatement = connection.prepareStatement(SQL_INSERT);

	            preparedStatement.setInt(1, douleur.getId_user());
	            preparedStatement.setInt(2, douleur.getDegre());
	            preparedStatement.setString(3, douleur.getSentiment());
	            preparedStatement.setString(4, douleur.getLocalisation());
	            preparedStatement.setString(5, douleur.getDate());

	            preparedStatement.executeUpdate(); // Utilisez executeUpdate pour les requêtes d'insertion

	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            // Fermez les ressources dans le bloc finally
	            // ClosingAll(preparedStatement, connection);
	        }
	    }
	    
	    
	    public DouleurBean[] getDouleursArrayByIdUser(int id_user) throws DAOException {
	        final String SQL_SELECT_BY_ID_USER = "SELECT id, degre, localisation, date FROM douleur WHERE id_user = ?";

	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = daoFactory.getConnection();
	            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_USER, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            preparedStatement.setInt(1, id_user);
	            resultSet = preparedStatement.executeQuery();

	            // Obtenir la taille du résultat pour définir la taille des tableaux
	            int rowCount = 0;
	            while (resultSet.next()) {
	                rowCount++;
	            }
	            resultSet.beforeFirst();

	            // Créer des tableaux avec la taille déterminée
	            int[] ids = new int[rowCount];
	            int[] degres = new int[rowCount];
	            String[] localisations = new String[rowCount];
	            String[] dates = new String[rowCount];

	            int index = 0;

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                int degre = resultSet.getInt("degre");
	                String localisation = resultSet.getString("localisation");
	                java.sql.Timestamp timestamp = resultSet.getTimestamp("date");

	                // Utiliser SimpleDateFormat pour formater la date
	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                String date = dateFormat.format(timestamp);

	                // Remplir les tableaux avec les données
	                ids[index] = id;
	                degres[index] = degre;
	                localisations[index] = localisation;
	                dates[index] = date;

	                index++;
	            }

	            // Créer un tableau de DouleurBean avec les données
	            DouleurBean[] douleursArray = new DouleurBean[rowCount];
	            for (int i = 0; i < rowCount; i++) {
	                douleursArray[i] = new DouleurBean(ids[i], id_user, degres[i], localisations[i], dates[i]);
	            }

	            return douleursArray;

	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            // Fermez les ressources dans le bloc finally
	            // ClosingAll(resultSet, preparedStatement, connection);
	        }
	    }


	    
	    
	    
	    

		
		public  void  deleteDouleur(int id ) throws DAOException {
		    final String SQL_DELETE = "DELETE FROM douleur WHERE id = ?";

		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = connexion.prepareStatement(SQL_DELETE);
		        preparedStatement.setInt(1,id); // Utilisez l'ID de l'utilisateur à supprimer
		        preparedStatement.executeUpdate(); // Exécute la suppression
		    } catch (SQLException e) {
		        throw new DAOException(e);
		    } finally {
		        // ClosingAll(preparedStatement, connexion);
		    }
		}
		
		
	    
		
		public DouleurBean[] getMyD(int idUser) throws DAOException {
		    final String SQL_SELECT_BY_USER = "SELECT * FROM douleur WHERE id_user = ?";

		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = daoFactory.getConnection();
		        preparedStatement = connection.prepareStatement(SQL_SELECT_BY_USER);
		        preparedStatement.setInt(1, idUser); // Set the id_user parameter

		        resultSet = preparedStatement.executeQuery();

		        ArrayList<DouleurBean> douleurs = new ArrayList<>();

		        while (resultSet.next()) {
		            int id = resultSet.getInt("id");
		            int userId = resultSet.getInt("id_user");
		            int degre = resultSet.getInt("degre");
		            String sentiment = resultSet.getString("sentiment");
		            String localisation = resultSet.getString("localisation");
		            String date = resultSet.getString("date");

		            DouleurBean douleurBean = new DouleurBean(id, userId, degre,sentiment, localisation, date);
		            douleurs.add(douleurBean);
		        }

		        DouleurBean[] douleursArray = douleurs.toArray(new DouleurBean[0]);
		        System.out.println("Number of douleurs retrieved: " + douleursArray.length);

		        return douleursArray;
		    } catch (SQLException e) {
		        // Log the exception for debugging
		        e.printStackTrace();  // You can use a logger here for better logging
		        throw new DAOException(e);
		    } finally {
		        // Close resources in the finally block
		        // ClosingAll(resultSet, preparedStatement, connection);
		    }
		}
		
		
		
		public DouleurBean[] getAllDouleur() throws DAOException {
		    final String SQL_SELECT_ALL = "SELECT * FROM douleur";

		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = daoFactory.getConnection();
		        preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
		        
		        resultSet = preparedStatement.executeQuery();

		        ArrayList<DouleurBean> douleurs = new ArrayList<>();

		        while (resultSet.next()) {
		            int id = resultSet.getInt("id");
		            int userId = resultSet.getInt("id_user");
		            int degre = resultSet.getInt("degre");
		            String sentiment = resultSet.getString("sentiment");
		            String localisation = resultSet.getString("localisation");
		            String date = resultSet.getString("date");

		            DouleurBean douleurBean = new DouleurBean(id, userId, degre, sentiment, localisation, date);
		            douleurs.add(douleurBean);
		        }

		        DouleurBean[] douleursArray = douleurs.toArray(new DouleurBean[0]);
		        System.out.println("Number of douleurs retrieved All: " + douleursArray.length);

		        return douleursArray;
		    } catch (SQLException e) {
		        // Log the exception for debugging
		        e.printStackTrace();  // You can use a logger here for better logging
		        throw new DAOException(e);
		    } finally {
		        // Close resources in the finally block
		        // ClosingAll(resultSet, preparedStatement, connection);
		    }
		}
		
		
		
		public DouleurBean[] getAllDouleurByUser(int id_user) throws DAOException {
			final String SQL_SELECT_ALL = "SELECT * FROM douleur WHERE id_user = ?";


		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = daoFactory.getConnection();
		        preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
		        preparedStatement.setInt(1, id_user); 

		        resultSet = preparedStatement.executeQuery();

		        ArrayList<DouleurBean> douleurs = new ArrayList<>();

		        while (resultSet.next()) {
		            int id = resultSet.getInt("id");
		            int userId = resultSet.getInt("id_user");
		            int degre = resultSet.getInt("degre");
		            String sentiment = resultSet.getString("sentiment");
		            String localisation = resultSet.getString("localisation");
		            String date = resultSet.getString("date");

		            DouleurBean douleurBean = new DouleurBean(id, userId, degre, sentiment, localisation, date);
		            douleurs.add(douleurBean);
		        }

		        DouleurBean[] douleursArray = douleurs.toArray(new DouleurBean[0]);
		        System.out.println("Number of douleurs retrieved By id of user  : " + douleursArray.length);

		        return douleursArray;
		    } catch (SQLException e) {
		        // Log the exception for debugging
		        e.printStackTrace();  // You can use a logger here for better logging
		        throw new DAOException(e);
		    } finally {
		        // Close resources in the finally block
		        // ClosingAll(resultSet, preparedStatement, connection);
		    }
		}



		
		
//		public  void  deleteDouleur(int idDouleur ) throws DAOException {
//		    final String SQL_DELETE = "DELETE FROM douleur WHERE id = ?";
//
//		    Connection connexion = null;
//		    PreparedStatement preparedStatement = null;
//
//		    try {
//		        /* Récupération d'une connexion depuis la Factory */
//		        connexion = daoFactory.getConnection();
//		        preparedStatement = connexion.prepareStatement(SQL_DELETE);
//		        preparedStatement.setInt(1,idDouleur); // Utilisez l'ID de l'utilisateur à supprimer
//		        preparedStatement.executeUpdate(); // Exécute la suppression
//		    } catch (SQLException e) {
//		        throw new DAOException(e);
//		    } finally {
//		        // ClosingAll(preparedStatement, connexion);
//		    }
//		}
//		
	    
	    
		
		public void updateDouleur(int id_douleur, int degre, String sentiment, String localisation, String date) throws DAOException {
		    final String SQL_UPDATE_COMMENT = "UPDATE douleur SET degre = ?, sentiment = ?, localisation = ?, date = ? WHERE id = ?";

		    Connection connection = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        connection = daoFactory.getConnection();
		        preparedStatement = connection.prepareStatement(SQL_UPDATE_COMMENT);

		        // Utilisez la valeur du paramètre "nouveauCommentaire" pour mettre à jour le commentaire
		        preparedStatement.setInt(1, degre);
		        preparedStatement.setString(2, sentiment);
		        preparedStatement.setString(3, localisation);
		        preparedStatement.setString(4, date);
		        preparedStatement.setInt(5, id_douleur);

		        int rowsAffected = preparedStatement.executeUpdate();

		        if (rowsAffected == 0) {
		            throw new DAOException("Aucun commentaire trouvé avec l'ID : " + id_douleur);
		        }
		    } catch (SQLException e) {
		        throw new DAOException("Erreur lors de la mise à jour du commentaire", e);
		    } finally {
		        // Fermez les ressources dans le bloc finally
//		        ClosingAll(preparedStatement, connection);
		    }
		}



		

	 
	    
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	

}
