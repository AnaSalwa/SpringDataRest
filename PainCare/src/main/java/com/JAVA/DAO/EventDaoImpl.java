package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Bean.EventBean;
import com.JAVA.Bean.UserBean;

public class EventDaoImpl {


	
	

    private DAOFactory daoFactory;

    public EventDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	

  

	public void create(EventBean Event) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static EventBean map( ResultSet resultSet ) throws SQLException {
			EventBean EventBean = new EventBean();
			EventBean.setId((int)resultSet.getInt( "id" ) );
			EventBean.setTitre( resultSet.getString( "titre" ) );
			EventBean.setDescription( resultSet.getString( "description" ) );
			EventBean.setDate( resultSet.getString( "date" ) );
			return EventBean;
	}
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
		    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
		    for ( int i = 0; i < objets.length; i++ ) {
		        preparedStatement.setObject( i + 1, objets[i] );
		    }
		    return preparedStatement;
	}
	
	
	 
	
//	 public void ajouterPub(EventBean Event) {
//		 
//	        final String SQL_INSERT = "INSERT INTO Event (id_user, titre, description) VALUES (?, ?, ?)";
//	        
//	        Connection connexion = null;
//	        PreparedStatement preparedStatement = null;
//
//	        try  {
//	        	
//	        	connexion = daoFactory.getConnection();
//		        preparedStatement = connexion.prepareStatement(SQL_INSERT);
//
//	            preparedStatement.setInt(1, Event.getId_user());
//	            preparedStatement.setString(2, Event.getTitre());
//	            preparedStatement.setString(3, Event.getDescription());
//
//	         
//
//	            preparedStatement.execute(); // Exécute l'insertion
//	        } catch (SQLException e) {
//	            throw new DAOException(e);
//	        }
//	    }
	
	
	
	public void ajouterEvent(EventBean event) throws DAOException {
		
        final String SQL_INSERT = "INSERT INTO event (id_user, titre, description, date) VALUES (?, ?, ?, ?)";
        
        try (Connection connexion = daoFactory.getConnection();
        		
             PreparedStatement preparedStatement = connexion.prepareStatement(SQL_INSERT)) {

            preparedStatement.setInt(1, event.getId_user());
            preparedStatement.setString(2, event.getTitre());
            preparedStatement.setString(3, event.getDescription());
            preparedStatement.setString(4, event.getDate());

            preparedStatement.execute(); // Utilisez executeUpdate pour les opérations d'insertion
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de l'ajout de la Event", e);
        }
    }
	 
	 
	   
	    
	    
	    
	    

		
		public  void  deleteEvent(int eventId ) throws DAOException {
		    final String SQL_DELETE = "DELETE FROM event WHERE id = ?";

		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = connexion.prepareStatement(SQL_DELETE);
		        preparedStatement.setInt(1,eventId); // Utilisez l'ID de l'utilisateur à supprimer
		        preparedStatement.executeUpdate(); // Exécute la suppression
		    } catch (SQLException e) {
		        throw new DAOException(e);
		    } finally {
		        // ClosingAll(preparedStatement, connexion);
		    }
		}
		
		
	    
		
		
		 public void insertEvent(EventBean event) throws DAOException {
		        final String SQL_INSERT = "INSERT INTO event (id_user, titre, description, date) VALUES (?, ?, ?, ?)";

		        Connection connection = null;
		        PreparedStatement preparedStatement = null;

		        try {
		            /* Récupération d'une connexion depuis la Factory */
		            connection = daoFactory.getConnection();
		            preparedStatement = connection.prepareStatement(SQL_INSERT);

		            preparedStatement.setInt(1, event.getId_user());
		            preparedStatement.setString(2, event.getTitre());
		            preparedStatement.setString(3, event.getDescription());
		            preparedStatement.setString(4, event.getDate());

		            preparedStatement.execute(); // Exécute la mise à jour
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        } finally {
		            // Fermez les ressources (PreparedStatement et Connection) dans le bloc finally
		            // ClosingAll(preparedStatement, connection);
		        }
		    }
		    
		 
		 
		 
		  public EventBean[] getAll() throws DAOException {
		        Connection connection = null;
		        PreparedStatement preparedStatement = null;
		        ResultSet resultSet = null;

		        try {
		            connection = daoFactory.getConnection();
		            // Modifier la requête en fonction de la structure de votre table "Event"
		            String sql = "SELECT * FROM Event";
		            preparedStatement = connection.prepareStatement(sql);
		            resultSet = preparedStatement.executeQuery();

		            // Convertir le ResultSet en un tableau de EventBean
		            ArrayList<EventBean> EventsList = new ArrayList<>();

		            while (resultSet.next()) {
		                EventBean Event = mapResultSetToEventBean(resultSet);
		                EventsList.add(Event);
		            }

		            // Convertir la liste en tableau
		            EventBean[] Events = new EventBean[EventsList.size()];
		            EventsList.toArray(Events);

		            return Events;
		        } catch (SQLException e) {
		            throw new DAOException("Erreur lors de la récupération des Events", e);
		        } finally {
		            // Fermer les ressources dans le bloc finally
		            // ClosingAll(preparedStatement, resultSet, connection);
		        }
		    }
		  
//		  
//		  public EventBean[] getMinePub(int id_user) throws DAOException {
//			    final String SQL_SELECT_ALL_WITH_USERS = "SELECT * FROM Event WHERE id_user = ?";
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
//		            ArrayList<EventBean> Events = new ArrayList<>();
//
//		            while (resultSet.next()) {
//		                // Mappez les données de la Event et de l'utilisateur à partir du ResultSet
//		                int id = resultSet.getInt("id");
//		                String titre = resultSet.getString("titre");
//		                String description = resultSet.getString("description");
//
//		                // Créez un objet EventBean avec les informations récupérées
//		                EventBean Event = new EventBean(id, id_user, titre, description);
//
//		                // Ajoutez la Event à la liste
//		                Events.add(Event);
//		            }
//
//		            // Convertissez la liste en tableau
//		            EventBean[] EventsArray = Events.toArray(new EventBean[0]);
//
//		            return EventsArray;
//		        } catch (SQLException e) {
//		            throw new DAOException(e);
//		        } finally {
//		            // Fermez les ressources dans le bloc finally
//		            // ClosingAll(resultSet, preparedStatement, connection);
//		        }
//		    }
////		  
		  
		  
		  
		  
		  
		  
		  public EventBean[] getMineEvent(int id_user) throws DAOException {
			    final String SQL_SELECT_MINE_PUB = "SELECT id, titre, description, date FROM event WHERE id_user = ?";

			    Connection connection = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;

			    try {
			        connection = daoFactory.getConnection();
			        preparedStatement = connection.prepareStatement(SQL_SELECT_MINE_PUB);
			        preparedStatement.setInt(1, id_user);
			        resultSet = preparedStatement.executeQuery();

			        ArrayList<EventBean> events = new ArrayList<>();

			        while (resultSet.next()) {
			            // Mappez les données de la Event à partir du ResultSet
			            int id = resultSet.getInt("id");
			            String titre = resultSet.getString("titre");
			            String description = resultSet.getString("description");
			            String date = resultSet.getString("date");

			            // Créez un objet EventBean avec les informations récupérées
			            EventBean event = new EventBean(id, id_user, titre, description, date);

			            // Ajoutez la Event à la liste
			            events.add(event);
			        }

			        // Convertissez la liste en tableau
			        EventBean[] eventsArray = events.toArray(new EventBean[0]);

			        return eventsArray;
			    } catch (SQLException e) {
			        throw new DAOException(e);
			    } finally {
			        // Fermez les ressources dans le bloc finally
			        // ClosingAll(resultSet, preparedStatement, connection);
			    }
			}

		  
		  
		
		  
		  
		  
		  
		  

		    // Méthode pour convertir le ResultSet en un objet EventBean
		    private EventBean mapResultSetToEventBean(ResultSet resultSet) throws SQLException {
		        // Adapter cette méthode en fonction de la structure de votre table "Event"
		        int id = resultSet.getInt("id");
		        int id_user = resultSet.getInt("id_user");
		        String titre = resultSet.getString("titre");
		        String description = resultSet.getString("description");
		        String date = resultSet.getString("date");

		        // Créer et retourner un objet EventBean
		        return new EventBean(id, id_user, titre, description, date);
		    }

		    
	   
	    
	    
	 
	    
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	

}
