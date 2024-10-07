package com.JAVA.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import org.apache.catalina.User;

import com.JAVA.Bean.*;


/**
 * Servlet implementation class EventServlet
 */
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		 

	       if (action.equals("insertEvent")) {
	            String titre = request.getParameter("titre");
	            String description = request.getParameter("description");
	            String date = request.getParameter("date");
	            int id_user = Integer.parseInt(request.getParameter("id_user"));

	            if (titre != null && description != null && date != null) {
	                try {
	                    EventDaoImpl eventDao = new EventDaoImpl(DAOFactory.getInstance());
	                    EventBean newEvent = new EventBean(0, id_user, titre, description, date);
	                    eventDao.insertEvent(newEvent);

	                    request.setAttribute("message", "Event ajoutée avec succès");
	                    request.getRequestDispatcher("/calendar.jsp").forward(request, response);
	                } catch (DAOException e) {
	                    request.setAttribute("error", "Erreur lors de l'ajout de la Event : " + e.getMessage());
	                    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	                }
	            } else {
	                request.setAttribute("error", "Informations de Event manquantes dans la requête");
	                request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	            }
	            
	            
	            
	        }else  if (action.equals("getAll")) {
	        	EventBean[] Events = null;

	        	try {
	        	    EventDaoImpl EventDao = new EventDaoImpl(DAOFactory.getInstance());
	        	    Events = EventDao.getAll(); // Assurez-vous d'avoir une méthode getAllEvents dans votre EventDaoImpl
	        	} catch (DAOException e) {
	        	    // Gérez les erreurs de la couche DAO
	        	    request.setAttribute("error", "Erreur lors de la récupération des Events : " + e.getMessage());
	        	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	        	}

	        	request.setAttribute("Events", Events);
	        	request.getRequestDispatcher("/Event.jsp").forward(request, response);

	        	
	        }
//	        
//	        } else if (action.equals("getMine")) {
//	            EventBean[] Events = null;
//	            int id_user = Integer.parseInt(request.getParameter("id_user"));
//
//	            try {
//	                EventDaoImpl EventDao = new EventDaoImpl(DAOFactory.getInstance());
//	                Events = EventDao.getMinePub(id_user);
//	            } catch (DAOException e) {
//	                // Gérez les erreurs de la couche DAO
//	                request.setAttribute("error", "Erreur lors de la récupération des Events : " + e.getMessage());
//	                request.getRequestDispatcher("/error.jsp").forward(request, response);
//	                return; // Ajoutez le return ici pour éviter tout envoi de données supplémentaires
//	            }
//
//	            request.setAttribute("Events", Events);
//	            request.getRequestDispatcher("/MesEvents.jsp").forward(request, response);
//	        }
	        
	        
	    	
    else  if (action.equals("getMine")) {
    	EventBean[] events = null;
        int id_user = Integer.parseInt(request.getParameter("id_user"));


    	try {
    	    EventDaoImpl eventDao = new EventDaoImpl(DAOFactory.getInstance());
    	    events = eventDao.getMineEvent(id_user); // Assurez-vous d'avoir une méthode getAllEvents dans votre EventDaoImpl
    	} catch (DAOException e) {
    	    // Gérez les erreurs de la couche DAO
    	    request.setAttribute("error", "Erreur lors de la récupération des Events : " + e.getMessage());
    	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
    	}

    	request.setAttribute("events", events);
    	request.getRequestDispatcher("/MesEvents.jsp").forward(request, response);

	  
    }
	       
    else  if (action.equals("deleteEvent")) {
    	
    	 int eventId = Integer.parseInt(request.getParameter("id"));

         try {
             EventDaoImpl eventDao = new EventDaoImpl(DAOFactory.getInstance());
             eventDao.deleteEvent(eventId);
             
           
             // Redirection vers la page MesEvents après la suppression
            
                 // Gérer le cas où l'utilisateur n'est pas en session
                 response.sendRedirect(request.getContextPath() + "/calendar.jsp");
             
         } catch (DAOException e) {
             // Gérez les erreurs de la couche DAO
             request.setAttribute("error", "Erreur lors de la suppression de l'événement : " + e.getMessage());
             request.getRequestDispatcher("/erreur.jsp").forward(request, response);
         }
     }
    	
    	
    	
    }
    
	   
	
		
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
