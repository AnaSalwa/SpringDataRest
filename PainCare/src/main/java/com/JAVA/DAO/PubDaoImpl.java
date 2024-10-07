package com.JAVA.DAO;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.JAVA.Bean.PubBean;
import com.JAVA.Bean.UserBean;

	
public class PubDaoImpl {


	    private DAOFactory daoFactory;

	    public PubDaoImpl(DAOFactory daoFactory) {
	        this.daoFactory = daoFactory;
	    }
		

	    
		public PubDaoImpl() {
			// TODO Auto-generated constructor stub
		}

		public void create(PubBean Publication) throws DAOException {
			// TODO Auto-generated method stub
			
		}
		
		private static PubBean map( ResultSet resultSet ) throws SQLException {
				PubBean PubBean = new PubBean();
				PubBean.setId((int)resultSet.getInt( "id" ) );
				PubBean.setTitre( resultSet.getString( "titre" ) );
				PubBean.setDescription( resultSet.getString( "description" ) );
				
//				PubBean.setDate( resultSet.getDate( "date" ) );
				return PubBean;
		}
		
		
		public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
			    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
			    for ( int i = 0; i < objets.length; i++ ) {
			        preparedStatement.setObject( i + 1, objets[i] );
			    }
			    return preparedStatement;
		}
		
		
		 
		
//		 public void ajouterPub(PubBean Publication) {
//			 
//		        final String SQL_INSERT = "INSERT INTO publication (id_user, titre, description) VALUES (?, ?, ?)";
//		        
//		        Connection connexion = null;
//		        PreparedStatement preparedStatement = null;
	//
//		        try  {
//		        	
//		        	connexion = daoFactory.getConnection();
//			        preparedStatement = connexion.prepareStatement(SQL_INSERT);
	//
//		            preparedStatement.setInt(1, Publication.getId_user());
//		            preparedStatement.setString(2, Publication.getTitre());
//		            preparedStatement.setString(3, Publication.getDescription());
	//
//		         
	//
//		            preparedStatement.execute(); // Exécute l'insertion
//		        } catch (SQLException e) {
//		            throw new DAOException(e);
//		        }
//		    }
		
		
		
		public void ajouterPub(PubBean publication) throws DAOException {
			
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
			
			
		    
			public void insertPub(PubBean publication) throws DAOException {
			    final String SQL_INSERT = "INSERT INTO publication (id_user, titre, description, photo) VALUES (?, ?, ?, ?)";

			    Connection connection = null;
			    PreparedStatement preparedStatement = null;

			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connection = daoFactory.getConnection();
			        preparedStatement = connection.prepareStatement(SQL_INSERT);

			        preparedStatement.setInt(1, publication.getId_user());
			        preparedStatement.setString(2, publication.getTitre());
			        preparedStatement.setString(3, publication.getDescription());

			        // Ajout du champ photo (supposons que la méthode getPhoto retourne un tableau de bytes)
			        preparedStatement.setBytes(4, publication.getPhoto());

			        preparedStatement.executeUpdate(); // Utilisez executeUpdate pour les requêtes d'insertion

			    } catch (SQLException e) {
			        throw new DAOException(e);
			    } finally {
			       
			    }
			}

			 
			 
			  public PubBean[] getAll() throws DAOException {
			        Connection connection = null;
			        PreparedStatement preparedStatement = null;
			        ResultSet resultSet = null;

			        try {
			            connection = daoFactory.getConnection();
			            // Modifier la requête en fonction de la structure de votre table "publication"
			            String sql = "SELECT * FROM publication";
			            preparedStatement = connection.prepareStatement(sql);
			            resultSet = preparedStatement.executeQuery();

			            // Convertir le ResultSet en un tableau de PubBean
			            ArrayList<PubBean> publicationsList = new ArrayList<>();

			            while (resultSet.next()) {
			                PubBean publication = mapResultSetToPubBean(resultSet);
			                publicationsList.add(publication);
			            }

			            // Convertir la liste en tableau
			            PubBean[] publications = new PubBean[publicationsList.size()];
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
//			  public PubBean[] getMinePub(int id_user) throws DAOException {
//				    final String SQL_SELECT_ALL_WITH_USERS = "SELECT * FROM publication WHERE id_user = ?";
	//
//			        Connection connection = null;
//			        PreparedStatement preparedStatement = null;
//			        ResultSet resultSet = null;
	//
//			        try {
//			            connection = daoFactory.getConnection();
//			            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_WITH_USERS);
//			            resultSet = preparedStatement.executeQuery();
	//
//			            ArrayList<PubBean> publications = new ArrayList<>();
	//
//			            while (resultSet.next()) {
//			                // Mappez les données de la publication et de l'utilisateur à partir du ResultSet
//			                int id = resultSet.getInt("id");
//			                String titre = resultSet.getString("titre");
//			                String description = resultSet.getString("description");
	//
//			                // Créez un objet PubBean avec les informations récupérées
//			                PubBean publication = new PubBean(id, id_user, titre, description);
	//
//			                // Ajoutez la publication à la liste
//			                publications.add(publication);
//			            }
	//
//			            // Convertissez la liste en tableau
//			            PubBean[] publicationsArray = publications.toArray(new PubBean[0]);
	//
//			            return publicationsArray;
//			        } catch (SQLException e) {
//			            throw new DAOException(e);
//			        } finally {
//			            // Fermez les ressources dans le bloc finally
//			            // ClosingAll(resultSet, preparedStatement, connection);
//			        }
//			    }
////			  
			  
			  
			  
			  
			  
			  
			  public PubBean[] getMinePub(int id_user) throws DAOException {
				    final String SQL_SELECT_MINE_PUB = "SELECT * FROM publication WHERE id_user = ?";

				    Connection connection = null;
				    PreparedStatement preparedStatement = null;
				    ResultSet resultSet = null;

				    try {
				        connection = daoFactory.getConnection();
				        preparedStatement = connection.prepareStatement(SQL_SELECT_MINE_PUB);
				        preparedStatement.setInt(1, id_user);
				        resultSet = preparedStatement.executeQuery();

				        ArrayList<PubBean> publications = new ArrayList<>();

				        while (resultSet.next()) {
				            // Mappez les données de la publication à partir du ResultSet
				            int id = resultSet.getInt("id");
				            String titre = resultSet.getString("titre");
				            String description = resultSet.getString("description");
				            Blob photoBlob = resultSet.getBlob("photo");
				            byte[] photoBytes = null;
				            if (photoBlob != null) {
				                photoBytes = photoBlob.getBytes(1, (int) photoBlob.length());
				            }

				            // Créez un objet PubBean avec les informations récupérées
				            PubBean publication = new PubBean(id, id_user, titre, description);
				            publication.setPhoto(photoBytes);

				            // Ajoutez la publication à la liste
				            publications.add(publication);
				        }

				        // Convertissez la liste en tableau
				        PubBean[] publicationsArray = publications.toArray(new PubBean[0]);

				        return publicationsArray;
				    } catch (SQLException e) {
				        throw new DAOException(e);
				    } finally {
				        // Fermez les ressources dans le bloc finally
				        // ClosingAll(resultSet, preparedStatement, connection);
				    }
				}

			  
			  
			  public PubBean[] getAllPublicationsWithUserNames() throws DAOException {
				    final String SQL_SELECT_ALL_WITH_USERS = "SELECT publication.*, user.nom ,user.prenom FROM publication JOIN user ON publication.id_user = user.id";

				    Connection connection = null;
				    PreparedStatement preparedStatement = null;
				    ResultSet resultSet = null;

				    try {
				        connection = daoFactory.getConnection();
				        preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_WITH_USERS);
				        resultSet = preparedStatement.executeQuery();

				        ArrayList<PubBean> publications = new ArrayList<>();

				        while (resultSet.next()) {
				            // Mappez les données de la publication et de l'utilisateur à partir du ResultSet
				            int id = resultSet.getInt("id");
				            int id_user = resultSet.getInt("id_user");
				            String titre = resultSet.getString("titre");
				            String description = resultSet.getString("description");
				            String nomUtilisateur = resultSet.getString("nom");
				            String prenomUtilisateur = resultSet.getString("prenom");

				            // Récupérez les données de la photo
				            Blob photoBlob = resultSet.getBlob("photo");
				            byte[] photoBytes = null;
				            if (photoBlob != null) {
				                photoBytes = photoBlob.getBytes(1, (int) photoBlob.length());
				            }

				            // Créez un objet PubBean avec les informations récupérées
				            PubBean publication = new PubBean(id, id_user, titre, description);
				            publication.setNom(nomUtilisateur);
				            publication.setPrenom(prenomUtilisateur);
				            publication.setPhoto(photoBytes);

				            // Ajoutez la publication à la liste
				            publications.add(publication);
				        }

				        // Convertissez la liste en tableau
				        PubBean[] publicationsArray = publications.toArray(new PubBean[0]);

				        return publicationsArray;
				    } catch (SQLException e) {
				        throw new DAOException(e);
				    } finally {
				        // Fermez les ressources dans le bloc finally
				        // ClosingAll(resultSet, preparedStatement, connection);
				    }
				}

			  
			  
			  
			  
			  
			  

			    // Méthode pour convertir le ResultSet en un objet PubBean
			    private PubBean mapResultSetToPubBean(ResultSet resultSet) throws SQLException {
			        // Adapter cette méthode en fonction de la structure de votre table "publication"
			        int id = resultSet.getInt("id");
			        int id_user = resultSet.getInt("id_user");
			        String titre = resultSet.getString("titre");
			        String description = resultSet.getString("description");

			        // Créer et retourner un objet PubBean
			        return new PubBean(id, id_user, titre, description);
			    }

			    
		   
		    
		    
		 
		    
			    public void updatePub(int idPublication, String nouveauTitre, String nouvelleDescription, byte[] nouvellePhoto) throws DAOException {
			        final String SQL_UPDATE_PUB = "UPDATE publication SET titre = ?, description = ?, photo = ? WHERE id = ?";

			        Connection connection = null;
			        PreparedStatement preparedStatement = null;

			        try {
			            connection = daoFactory.getConnection();
			            preparedStatement = connection.prepareStatement(SQL_UPDATE_PUB);

			            preparedStatement.setString(1, nouveauTitre);
			            preparedStatement.setString(2, nouvelleDescription);
			            preparedStatement.setBytes(3, nouvellePhoto);
			            preparedStatement.setInt(4, idPublication);

			            preparedStatement.executeUpdate(); // Utilisez executeUpdate pour les requêtes de mise à jour

			        } catch (SQLException e) {
			            throw new DAOException(e);
			        } finally {
			            // Fermez les ressources dans le bloc finally
			            // ClosingAll(preparedStatement, connection);
			        }
			    }

		    
		
		
		
		
		
		
		
		
		
		
		
		
		

	


}
