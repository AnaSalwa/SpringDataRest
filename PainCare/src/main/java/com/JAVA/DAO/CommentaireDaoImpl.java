package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Bean.*;

public class CommentaireDaoImpl {
	
	
    private DAOFactory daoFactory;

    public CommentaireDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	

    
	public CommentaireDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void create(CommentaireBean Commentaire) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	
	private static CommentaireBean map( ResultSet resultSet ) throws SQLException {
		CommentaireBean CommentaireBean = new CommentaireBean();
		CommentaireBean.setId((int)resultSet.getInt( "id" ) );
		CommentaireBean.setCommentaire( resultSet.getString( "commentaire" ) );
		
//		CommentaireBean.setDate( resultSet.getDate( "date" ) );
		return CommentaireBean;
	}
	
	
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}
	
	
	
	
	public void addComment(CommentaireBean commentaire) throws DAOException {
		
        final String SQL_INSERT = "INSERT INTO commentaire (id_publication,id_user, commentaire) VALUES (?, ?, ?)";
        
        try (Connection connexion = daoFactory.getConnection();
        		
             PreparedStatement preparedStatement = connexion.prepareStatement(SQL_INSERT)) {

            preparedStatement.setInt(1, commentaire.getId_publication());
            preparedStatement.setInt(2, commentaire.getId_user());
            preparedStatement.setString(3, commentaire.getCommentaire());

            preparedStatement.execute(); // Utilisez executeUpdate pour les opérations d'insertion
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de l'ajout de la Commentaire", e);
        }
    }

	
	
	
	public CommentaireBean[] getAllComments(int id_publication) throws DAOException {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = daoFactory.getConnection();
	        // Modifier la requête en fonction de la structure de votre table "commentaire"
	        String sql = "SELECT * FROM commentaire WHERE id_publication = ?";
	        preparedStatement = connection.prepareStatement(sql);
	        
	        // Set the parameter value
	        preparedStatement.setInt(1, id_publication);

	        resultSet = preparedStatement.executeQuery();

	        // Convertir le ResultSet en un tableau de CommentaireBean
	        ArrayList<CommentaireBean> commentsList = new ArrayList<>();

	        while (resultSet.next()) {
	            CommentaireBean comment = mapResultSetToCommentaireBean2(resultSet);
	            commentsList.add(comment);
	        }

	        // Convertir la liste en tableau
	        CommentaireBean[] comments = new CommentaireBean[commentsList.size()];
	        commentsList.toArray(comments);

	        return comments;
	    } catch (SQLException e) {
	        throw new DAOException("Erreur lors de la récupération des commentaires", e);
	    } finally {
	        // Fermer les ressources dans le bloc finally
	        // Uncomment and use your actual method to close resources
	        // ClosingAll(preparedStatement, resultSet, connection);
	    }
	    
	}
	
	
	
//	public CommentaireBean[] getMyComments2(int id_publication, int id_user) throws DAOException {
//	    Connection connection = null;
//	    PreparedStatement preparedStatement = null;
//	    ResultSet resultSet = null;
//
//	    try {
//	        connection = daoFactory.getConnection();
//	        // Modifier la requête en fonction de la structure de votre table "commentaire"
//	        String sql = "SELECT * FROM commentaire WHERE id_Commentaire = ?";
//	        preparedStatement = connection.prepareStatement(sql);
//	        
//	        // Set the parameter value
//	        preparedStatement.setInt(1, id_Commentaire);
//
//	        resultSet = preparedStatement.executeQuery();
//
//	        // Convertir le ResultSet en un tableau de CommentaireBean
//	        ArrayList<CommentaireBean> commentsList = new ArrayList<>();
//
//	        while (resultSet.next()) {
//	            CommentaireBean comment = mapResultSetToCommentaireBean2(resultSet);
//	            commentsList.add(comment);
//	        }
//
//	        // Convertir la liste en tableau
//	        CommentaireBean[] comments = new CommentaireBean[commentsList.size()];
//	        commentsList.toArray(comments);
//
//	        return comments;
//	    } catch (SQLException e) {
//	        throw new DAOException("Erreur lors de la récupération des commentaires", e);
//	    } finally {
//	        // Fermer les ressources dans le bloc finally
//	        // Uncomment and use your actual method to close resources
//	        // ClosingAll(preparedStatement, resultSet, connection);
//	    }
//	    
//	}
	
	
	
	  
	public CommentaireBean[] getComments(int idPublication) throws DAOException {
	    final String SQL_SELECT_BY_PUBLICATION = "SELECT commentaire.*, user.nom, user.prenom FROM commentaire " +
	            "JOIN user ON commentaire.id_user = user.id " +
	            "WHERE commentaire.id_publication = ?";

	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = daoFactory.getConnection();
	        preparedStatement = connection.prepareStatement(SQL_SELECT_BY_PUBLICATION);
	        preparedStatement.setInt(1, idPublication); // Set the id_publication parameter
	        resultSet = preparedStatement.executeQuery();

	        ArrayList<CommentaireBean> commentaires = new ArrayList<>();

	        while (resultSet.next()) {
	            // Mappez les données du commentaire et de l'utilisateur à partir du ResultSet
	            int id = resultSet.getInt("id");
	            int id_user = resultSet.getInt("id_user");
	            String commentaire = resultSet.getString("commentaire");
	            String nomUtilisateur = resultSet.getString("nom");
	            String prenomUtilisateur = resultSet.getString("prenom");

	            // Créez un objet CommentaireBean avec les informations récupérées
	            CommentaireBean commentaireBean = new CommentaireBean(id, idPublication,id_user, commentaire);
	            commentaireBean.setNom(nomUtilisateur);
	            commentaireBean.setPrenom(prenomUtilisateur);

	            // Ajoutez le commentaire à la liste
	            commentaires.add(commentaireBean);
	        }

	        // Convertissez la liste en tableau
	        CommentaireBean[] commentairesArray = commentaires.toArray(new CommentaireBean[0]);
	        System.out.println("Nombres des commentaires selectionnes est: " + commentairesArray.length);

	        return commentairesArray;
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	        // Fermez les ressources dans le bloc finally
	        // ClosingAll(resultSet, preparedStatement, connection);
	    }
	}

	
	
	
	public CommentaireBean[] getMyComments(int idPublication, int idUser) throws DAOException {
		final String SQL_SELECT_BY_PUBLICATION = "SELECT commentaire.*, user.nom, user.prenom FROM commentaire " +
		        "JOIN user ON commentaire.id_user = user.id " +
		        "WHERE commentaire.id_publication = ? AND user.id = ?";


	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = daoFactory.getConnection();
	        preparedStatement = connection.prepareStatement(SQL_SELECT_BY_PUBLICATION);
	        preparedStatement.setInt(1, idPublication); // Set the id_publication parameter
	        preparedStatement.setInt(2, idUser); // Set the id_publication parameter

	        resultSet = preparedStatement.executeQuery();

	        ArrayList<CommentaireBean> commentaires = new ArrayList<>();

	        while (resultSet.next()) {
	            // Mappez les données du commentaire et de l'utilisateur à partir du ResultSet
	            int id = resultSet.getInt("id");
	            int id_user = resultSet.getInt("id_user");
	            String commentaire = resultSet.getString("commentaire");
	            String nomUtilisateur = resultSet.getString("nom");
	            String prenomUtilisateur = resultSet.getString("prenom");

	            // Créez un objet CommentaireBean avec les informations récupérées
	            CommentaireBean commentaireBean = new CommentaireBean(id, idPublication,id_user, commentaire);
	            commentaireBean.setNom(nomUtilisateur);
	            commentaireBean.setPrenom(prenomUtilisateur);

	            // Ajoutez le commentaire à la liste
	            commentaires.add(commentaireBean);
	        }

	        // Convertissez la liste en tableau
	        CommentaireBean[] commentairesArray = commentaires.toArray(new CommentaireBean[0]);

	        return commentairesArray;
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	        // Fermez les ressources dans le bloc finally
	        // ClosingAll(resultSet, preparedStatement, connection);
	    }
	}

	
	
	
	  
	
	
    private CommentaireBean mapResultSetToCommentaireBean2(ResultSet resultSet) throws SQLException {
        // Adapter cette méthode en fonction de la structure de votre table "Commentaire"
        int id = resultSet.getInt("id");
        int id_publication= resultSet.getInt("id_publication");
        int id_user = resultSet.getInt("id_user");
        String commentaire = resultSet.getString("commentaire");

        // Créer et retourner un objet CommentaireBean
        return new CommentaireBean(id, id_publication,id_user, commentaire);
    }

	// Helper method to map a ResultSet row to a CommentaireBean
	private CommentaireBean mapResultSetToCommentaireBean(ResultSet resultSet) throws SQLException {
	    // Implement your mapping logic here based on your CommentaireBean class
	    CommentaireBean comment = new CommentaireBean();
	    comment.setId(resultSet.getInt("id"));
	    // Set other properties
	    return comment;
	}
	
	
	public  void  deleteComment(int id ) throws DAOException {
	    final String SQL_DELETE = "DELETE FROM commentaire WHERE id = ?";

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
	
	
	public void updateComment(int idCommentaire, String nouveauCommentaire) throws DAOException {
	    final String SQL_UPDATE_COMMENT = "UPDATE commentaire SET commentaire = ? WHERE id = ?";

	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = daoFactory.getConnection();
	        preparedStatement = connection.prepareStatement(SQL_UPDATE_COMMENT);

	        // Utilisez la valeur du paramètre "nouveauCommentaire" pour mettre à jour le commentaire
	        preparedStatement.setString(1, nouveauCommentaire);
	        preparedStatement.setInt(2, idCommentaire);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected == 0) {
	            throw new DAOException("Aucun commentaire trouvé avec l'ID : " + idCommentaire);
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Erreur lors de la mise à jour du commentaire", e);
	    } finally {
	        // Fermez les ressources dans le bloc finally
	    	//	        ClosingAll(preparedStatement, connection);
	    }
	}

}
