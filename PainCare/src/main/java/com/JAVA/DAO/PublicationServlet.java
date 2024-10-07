package com.JAVA.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import com.JAVA.Bean.*;


/**
 * Servlet implementation class PublicationServlet
 */
public class PublicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		 

	        if ("addPub".equals(action)) {
	            try {
	                // Récupérer les valeurs du formulaire
	                String titre = request.getParameter("titre");
	                String description = request.getParameter("description");
	                int id_user = Integer.parseInt(request.getParameter("id_user"));

	                // Assurez-vous que les valeurs sont non nulles avant de les traiter
	                if (titre != null && description != null) {
	                    // Créer un objet représentant la publication
	                    PublicationBean newPub = new PublicationBean(0, id_user, titre, description);

	                    // Ajouter la publication à la base de données
	                    PublicationDaoImpl pubDao = DAOFactory.getInstance().getPublicationDao();
	                    pubDao.ajouterPub(newPub);

	                    request.setAttribute("message", "Publication ajoutée avec succès");
	                    // Rediriger vers la page de tableau de bord après l'ajout réussi
	                    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	                } else {
	                    // Gérer le cas où l'un des champs est vide
	                    request.setAttribute("error", "Veuillez remplir tous les champs du formulaire");
	                    request.getRequestDispatcher("/error.jsp").forward(request, response);
	                }
	            } catch (NumberFormatException | DAOException e) {
	                // Gérer les erreurs de la couche DAO
	                request.setAttribute("error", "Erreur lors de l'ajout de la publication : " + e.getMessage());
	                request.getRequestDispatcher("/error2.jsp").forward(request, response);
	            }
	            
	            
	        } else if (action.equals("insertPub")) {
	            String titre = request.getParameter("titre");
	            String description = request.getParameter("description");
	            int id_user = Integer.parseInt(request.getParameter("id_user"));

	            if (titre != null && description != null) {
	                try {
	                    PublicationDaoImpl publicationDao = new PublicationDaoImpl(DAOFactory.getInstance());
	                    PublicationBean newPublication = new PublicationBean(0, id_user, titre, description);
	                    publicationDao.insertPub(newPublication);

	                    request.setAttribute("message", "Publication ajoutée avec succès");
	                    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	                } catch (DAOException e) {
	                    request.setAttribute("error", "Erreur lors de l'ajout de la publication : " + e.getMessage());
	                    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	                }
	            } else {
	                request.setAttribute("error", "Informations de publication manquantes dans la requête");
	                request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	            }
	            
	            
	            
	        }else  if (action.equals("getAll")) {
	        	PublicationBean[] publications = null;

	        	try {
	        	    PublicationDaoImpl publicationDao = new PublicationDaoImpl(DAOFactory.getInstance());
	        	    publications = publicationDao.getAll(); // Assurez-vous d'avoir une méthode getAllPublications dans votre PublicationDaoImpl
	        	} catch (DAOException e) {
	        	    // Gérez les erreurs de la couche DAO
	        	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
	        	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	        	}

	        	request.setAttribute("publications", publications);
	        	request.getRequestDispatcher("/publication.jsp").forward(request, response);

	        	
	        }else  if (action.equals("getAllPublicationsWithUserNames")) {
	        	PublicationBean[] publications = null;

	        	try {
	        	    PublicationDaoImpl publicationDao = new PublicationDaoImpl(DAOFactory.getInstance());
	        	    publications = publicationDao.getAllPublicationsWithUserNames(); // Assurez-vous d'avoir une méthode getAllPublications dans votre PublicationDaoImpl
	        	} catch (DAOException e) {
	        	    // Gérez les erreurs de la couche DAO
	        	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
	        	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	        	}

	        	request.setAttribute("publications", publications);
	        	request.getRequestDispatcher("/publication.jsp").forward(request, response);

	        
//	        
//	        } else if (action.equals("getMine")) {
//	            PublicationBean[] publications = null;
//	            int id_user = Integer.parseInt(request.getParameter("id_user"));
//
//	            try {
//	                PublicationDaoImpl publicationDao = new PublicationDaoImpl(DAOFactory.getInstance());
//	                publications = publicationDao.getMinePub(id_user);
//	            } catch (DAOException e) {
//	                // Gérez les erreurs de la couche DAO
//	                request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
//	                request.getRequestDispatcher("/error.jsp").forward(request, response);
//	                return; // Ajoutez le return ici pour éviter tout envoi de données supplémentaires
//	            }
//
//	            request.setAttribute("publications", publications);
//	            request.getRequestDispatcher("/MesPublications.jsp").forward(request, response);
//	        }
	        
	        
	    	
    }else  if (action.equals("getMine")) {
    	PublicationBean[] publications = null;
        int id_user = Integer.parseInt(request.getParameter("id_user"));


    	try {
    	    PublicationDaoImpl publicationDao = new PublicationDaoImpl(DAOFactory.getInstance());
    	    publications = publicationDao.getMinePub(id_user); // Assurez-vous d'avoir une méthode getAllPublications dans votre PublicationDaoImpl
    	} catch (DAOException e) {
    	    // Gérez les erreurs de la couche DAO
    	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
    	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
    	}

    	request.setAttribute("publications", publications);
    	request.getRequestDispatcher("/MesPublications.jsp").forward(request, response);

	  
    } else  if (action.equals("deletePub")) {
    	PublicationBean[] publications = null;
        int id_publication = Integer.parseInt(request.getParameter("id_publication"));


    	try {
    	    PublicationDaoImpl publicationDao = new PublicationDaoImpl(DAOFactory.getInstance());
    	   publicationDao.deletePub(id_publication); // Assurez-vous d'avoir une méthode getAllPublications dans votre PublicationDaoImpl
    	} catch (DAOException e) {
    	    // Gérez les erreurs de la couche DAO
    	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
    	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
    	}

//    	request.setAttribute("publications", publications);
    	request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

	  
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
