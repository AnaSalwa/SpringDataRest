package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Bean.PublicationBean;
import com.JAVA.Bean.UserBean;

public class PublicationDaoImpl {


	
	

    private DAOFactory daoFactory;

    public PublicationDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	

    
	public PublicationDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void create(PublicationBean Publication) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static PublicationBean map( ResultSet resultSet ) throws SQLException {
			PublicationBean PublicationBean = new PublicationBean();
			PublicationBean.setId((int)resultSet.getInt( "id" ) );
			PublicationBean.setTitre( resultSet.getString( "titre" ) );
			PublicationBean.setDescription( resultSet.getString( "description" ) );
			
//			PublicationBean.setDate( resultSet.getDate( "date" ) );
			return PublicationBean;
	}
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
		    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
		    for ( int i = 0; i < objets.length; i++ ) {
		        preparedStatement.setObject( i + 1, objets[i] );
		    }
		    return preparedStatement;
	}
	
	
	 
	
//	 public void ajouterPub(PublicationBean Publication) {
//		 
//	        final String SQL_INSERT = "INSERT INTO publication (id_user, titre, description) VALUES (?, ?, ?)";
//	        
//	        Connection connexion = null;
//	        PreparedStatement preparedStatement = null;
//
//	        try  {
//	        	
//	        	connexion = daoFactory.getConnection();
//		        preparedStatement = connexion.prepareStatement(SQL_INSERT);
//
//	            preparedStatement.setInt(1, Publication.getId_user());
//	            preparedStatement.setString(2, Publication.getTitre());
//	            preparedStatement.setString(3, Publication.getDescription());
//
//	         
//
//	            preparedStatement.execute(); // Exécute l'insertion
//	        } catch (SQLException e) {
//	            throw new DAOException(e);
//	        }
//	    }
	
	
	
	public void ajouterPub(PublicationBean publication) throws DAOException {
		
        final String SQL_INSERT = "INSERT INTO publication (id_user, titre, description) VALUES (?, ?, ?)";
        
        try (Connection connexion = daoFactory.getConnection();
        		
             PreparedStatement preparedStatement = connexion.prepareStatement(SQL_INSERT)) {

            preparedStatement.setInt(1, publication.getId_user());
            preparedStatement.setString(2, publication.getTitre());
            preparedStatement.setString(3, publication.getDescription());

            preparedStatement.execute(); // Utilisez executeUpdate pour les opérations d'insertion
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de l'ajout de la publication", e);
        }
    }
	 
	 
	   
	    
	    
	    
	    

		
		public  void  deletePub(int id ) throws DAOException {
		    final String SQL_DELETE = "DELETE FROM Publication WHERE id = ?";

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
		
		
	    
		
		
		 public void insertPub(PublicationBean publication) throws DAOException {
		        final String SQL_INSERT = "INSERT INTO publication (id_user, titre, description) VALUES (?, ?, ?)";

		        Connection connection = null;
		        PreparedStatement preparedStatement = null;

		        try {
		            /* Récupération d'une connexion depuis la Factory */
		            connection = daoFactory.getConnection();
		            preparedStatement = connection.prepareStatement(SQL_INSERT);

		            preparedStatement.setInt(1, publication.getId_user());
		            preparedStatement.setString(2, publication.getTitre());
		            preparedStatement.setString(3, publication.getDescription());

		            preparedStatement.execute(); // Exécute la mise à jour
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        } finally {
		            // Fermez les ressources (PreparedStatement et Connection) dans le bloc finally
		            // ClosingAll(preparedStatement, connection);
		        }
		    }
		    
		 
		 
		 
		  public PublicationBean[] getAll() throws DAOException {
		        Connection connection = null;
		        PreparedStatement preparedStatement = null;
		        ResultSet resultSet = null;

		        try {
		            connection = daoFactory.getConnection();
		            // Modifier la requête en fonction de la structure de votre table "publication"
		            String sql = "SELECT * FROM publication";
		            preparedStatement = connection.prepareStatement(sql);
		            resultSet = preparedStatement.executeQuery();

		            // Convertir le ResultSet en un tableau de PublicationBean
		            ArrayList<PublicationBean> publicationsList = new ArrayList<>();

		            while (resultSet.next()) {
		                PublicationBean publication = mapResultSetToPublicationBean(resultSet);
		                publicationsList.add(publication);
		            }

		            // Convertir la liste en tableau
		            PublicationBean[] publications = new PublicationBean[publicationsList.size()];
		            publicationsList.toArray(publications);

		            return publications;
		        } catch (SQLException e) {
		            throw new DAOException("Erreur lors de la récupération des publications", e);
		        } finally {
		            // Fermer les ressources dans le bloc finally
		            // ClosingAll(preparedStatement, resultSet, connection);
		        }
		    }
		  
//		  
//		  public PublicationBean[] getMinePub(int id_user) throws DAOException {
//			    final String SQL_SELECT_ALL_WITH_USERS = "SELECT * FROM publication WHERE id_user = ?";
//
//		        Connection connection = null;
//		        PreparedStatement preparedStatement = null;
//		        ResultSet resultSet = null;
//
//		        try {
//		            connection = daoFactory.getConnection();
//		            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_WITH_USERS);
//		            resultSet = preparedStatement.executeQuery();
//
//		            ArrayList<PublicationBean> publications = new ArrayList<>();
//
//		            while (resultSet.next()) {
//		                // Mappez les données de la publication et de l'utilisateur à partir du ResultSet
//		                int id = resultSet.getInt("id");
//		                String titre = resultSet.getString("titre");
//		                String description = resultSet.getString("description");
//
//		                // Créez un objet PublicationBean avec les informations récupérées
//		                PublicationBean publication = new PublicationBean(id, id_user, titre, description);
//
//		                // Ajoutez la publication à la liste
//		                publications.add(publication);
//		            }
//
//		            // Convertissez la liste en tableau
//		            PublicationBean[] publicationsArray = publications.toArray(new PublicationBean[0]);
//
//		            return publicationsArray;
//		        } catch (SQLException e) {
//		            throw new DAOException(e);
//		        } finally {
//		            // Fermez les ressources dans le bloc finally
//		            // ClosingAll(resultSet, preparedStatement, connection);
//		        }
//		    }
////		  
		  
		  
		  
		  
		  
		  
		  public PublicationBean[] getMinePub(int id_user) throws DAOException {
			    final String SQL_SELECT_MINE_PUB = "SELECT id, titre, description FROM publication WHERE id_user = ?";

			    Connection connection = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;

			    try {
			        connection = daoFactory.getConnection();
			        preparedStatement = connection.prepareStatement(SQL_SELECT_MINE_PUB);
			        preparedStatement.setInt(1, id_user);
			        resultSet = preparedStatement.executeQuery();

			        ArrayList<PublicationBean> publications = new ArrayList<>();

			        while (resultSet.next()) {
			            // Mappez les données de la publication à partir du ResultSet
			            int id = resultSet.getInt("id");
			            String titre = resultSet.getString("titre");
			            String description = resultSet.getString("description");

			            // Créez un objet PublicationBean avec les informations récupérées
			            PublicationBean publication = new PublicationBean(id, id_user, titre, description);

			            // Ajoutez la publication à la liste
			            publications.add(publication);
			        }

			        // Convertissez la liste en tableau
			        PublicationBean[] publicationsArray = publications.toArray(new PublicationBean[0]);

			        return publicationsArray;
			    } catch (SQLException e) {
			        throw new DAOException(e);
			    } finally {
			        // Fermez les ressources dans le bloc finally
			        // ClosingAll(resultSet, preparedStatement, connection);
			    }
			}

		  
		  
		  public PublicationBean[] getAllPublicationsWithUserNames() throws DAOException {
		        final String SQL_SELECT_ALL_WITH_USERS = "SELECT publication.*, user.nom ,user.prenom FROM publication JOIN user ON publication.id_user = user.id";

		        Connection connection = null;
		        PreparedStatement preparedStatement = null;
		        ResultSet resultSet = null;

		        try {
		            connection = daoFactory.getConnection();
		            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_WITH_USERS);
		            resultSet = preparedStatement.executeQuery();

		            ArrayList<PublicationBean> publications = new ArrayList<>();

		            while (resultSet.next()) {
		                // Mappez les données de la publication et de l'utilisateur à partir du ResultSet
		                int id = resultSet.getInt("id");
		                int id_user = resultSet.getInt("id_user");
		                String titre = resultSet.getString("titre");
		                String description = resultSet.getString("description");
		                String nomUtilisateur = resultSet.getString("nom");
		                String prenomUtilisateur = resultSet.getString("prenom");


		                // Créez un objet PublicationBean avec les informations récupérées
		                PublicationBean publication = new PublicationBean(id, id_user, titre, description);
		                publication.setNom(nomUtilisateur);
		                publication.setPrenom(prenomUtilisateur);


		                // Ajoutez la publication à la liste
		                publications.add(publication);
		            }

		            // Convertissez la liste en tableau
		            PublicationBean[] publicationsArray = publications.toArray(new PublicationBean[0]);

		            return publicationsArray;
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        } finally {
		            // Fermez les ressources dans le bloc finally
		            // ClosingAll(resultSet, preparedStatement, connection);
		        }
		    }
		  
		  
		  
		  
		  
		  
		  

		    // Méthode pour convertir le ResultSet en un objet PublicationBean
		    private PublicationBean mapResultSetToPublicationBean(ResultSet resultSet) throws SQLException {
		        // Adapter cette méthode en fonction de la structure de votre table "publication"
		        int id = resultSet.getInt("id");
		        int id_user = resultSet.getInt("id_user");
		        String titre = resultSet.getString("titre");
		        String description = resultSet.getString("description");

		        // Créer et retourner un objet PublicationBean
		        return new PublicationBean(id, id_user, titre, description);
		    }

		    
	   
	    
	    
	 
	    
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	

}
