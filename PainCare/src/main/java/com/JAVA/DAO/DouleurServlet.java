package com.JAVA.DAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.JspTagException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.tomcat.dbcp.pool2.ObjectPool;

import com.JAVA.Bean.CommentaireBean;
import com.JAVA.Bean.DouleurBean;
import com.JAVA.Bean.PublicationBean;
import com.google.gson.Gson;

/**
 * Servlet implementation class DouleurServlet
 */
public class DouleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DouleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getParameter("action");
		 
		 if (action.equals("ajouterDouleur")) {
			    // Récupérer les valeurs du formulaire
			    String degre1 = request.getParameter("degre");
			    String localisation = request.getParameter("localisation");
			    String date = request.getParameter("date");

			    // Assurez-vous que les valeurs sont non nulles avant de les traiter
			    if (degre1 != null && localisation != null && date != null) {
			        try {
			        	
			            int degre = Integer.parseInt(degre1);
			            int id_user = Integer.parseInt(request.getParameter("id_user"));

			            // Créer un objet représentant la douleur

			            DouleurDaoImpl douleurDao = new DouleurDaoImpl(DAOFactory.getInstance());
//			            DouleurDaoImpl douleurDao = DAOFactory.getInstance().getDouleurDao();

			            DouleurBean newDouleur = new DouleurBean(0, id_user, degre, localisation, date);

			            // Ajouter la douleur à la base de données
			            douleurDao.insertDouleur(newDouleur);

			            request.setAttribute("message", "Douleur ajoutée avec succès");
			            // Rediriger vers la page de tableau de bord après l'ajout réussi
			            this.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
			        
			        } catch (DAOException e) {
			            // Gérer les erreurs de la couche DAO
			            request.setAttribute("error", "Erreur lors de l'ajout de la douleur : " + e.getMessage());
			            this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			        }
			    } else  {
			        // Gérer le cas où l'un des champs est vide
			        request.setAttribute("error", "Veuillez remplir tous les champs du formulaire");
//			        this.getServletContext().getRequestDispatcher("/error2.jsp").forward(request, response);
		
		} 
			    
		 } else if (action.equals("ajouterDouleur2")) {
			    String degre1 = request.getParameter("degre");
			    String localisation = request.getParameter("localisation");
			    String date = request.getParameter("date");
			    int degre = Integer.parseInt(degre1);
			    int id_user = Integer.parseInt(request.getParameter("id_user"));

			    if (degre1 != null && localisation != null && date != null) {
			        try {
			            DouleurDaoImpl douleurDao = new DouleurDaoImpl(DAOFactory.getInstance());
			            DouleurBean newDouleur = new DouleurBean(0, id_user, degre, localisation, date);
			            douleurDao.insertDouleur(newDouleur);

			            request.setAttribute("message", "Douleur ajoutée avec succès");
			            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			        } catch (DAOException e) {
			            request.setAttribute("error", "Erreur lors de l'ajout de la Douleur : " + e.getMessage());
			            request.getRequestDispatcher("/error.jsp").forward(request, response);
			        }
			    } else {
			        request.setAttribute("error", "Informations de Douleur manquantes dans la requête");
			        request.getRequestDispatcher("/error2.jsp").forward(request, response);
			    }
			}
		 else if  (action.equals("insertD")) {
			 String degre1 = request.getParameter("degre");
			    String localisation = request.getParameter("localisation");
			    String sentiment = request.getParameter("sentiment");
			    String date = request.getParameter("date");
			    int degre = Integer.parseInt(degre1);
			    int id_user = Integer.parseInt(request.getParameter("id_user"));

			    if (degre != 0 && sentiment != null && localisation != null && date != null) {
	               
	                    DouleurDaoImpl douleurDao = new DouleurDaoImpl(DAOFactory.getInstance());
	                    DouleurBean newDouleur = new DouleurBean(0, id_user, degre,sentiment ,localisation, date);
	                    douleurDao.insertDouleur(newDouleur);

	                    request.setAttribute("message", "Publication ajoutée avec succès");
	                    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	             
	            } else {
	                request.setAttribute("error", "Informations de publication manquantes dans la requête");
	                request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	            }
			    
			    
		 } else if (action.equals("afficherGraphe")) {
			    int id_user = Integer.parseInt(request.getParameter("id_user"));

			    // Récupérer les données de la base de données pour l'utilisateur spécifié
			    DouleurDaoImpl douleurDao = new DouleurDaoImpl(DAOFactory.getInstance());
			    DouleurBean[] douleursArray = douleurDao.getDouleursArrayByIdUser(id_user);

			    // Préparer les données pour le graphe
			    String[] dateStrings = new String[douleursArray.length];
			    int[] degres = new int[douleursArray.length];

			    for (int i = 0; i < douleursArray.length; i++) {
			        dateStrings[i] = douleursArray[i].getDate();
			        degres[i] = douleursArray[i].getDegre();
			    }

			    // Convertir les chaînes de date en objets Date
			    Date[] dates = new Date[dateStrings.length];
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			    for (int i = 0; i < dateStrings.length; i++) {
			        try {
			            dates[i] = dateFormat.parse(dateStrings[i]);
			        } catch (ParseException e) {
			            e.printStackTrace();  // Gérer l'erreur de conversion de date
			        }
			    }

			    // Stocker les données dans la session pour les utiliser dans la JSP
			    request.getSession().setAttribute("dates", dates);
			    request.getSession().setAttribute("degres", degres);

			    // Rediriger vers la JSP qui affiche le graphe
			    request.getRequestDispatcher("/graph.jsp").forward(request, response);
			    
			    
			
		 } else if (action.equals("getMyD")) {
	        	DouleurBean[] douleurs = null;

			    int id_user = Integer.parseInt(request.getParameter("id_user"));

			    try {
			        DouleurDaoImpl douleurDao = new DouleurDaoImpl(DAOFactory.getInstance());
	        	    douleurs = douleurDao.getMyD(id_user); 

//			        DouleurBean[] douleurs = douleurDao.getMyD(id_user); 
//			        
//			        request.setAttribute("douleurs", douleurs);
//			        request.getRequestDispatcher("/douleurs.jsp").forward(request, response);
			    } catch (DAOException e) {
			        e.printStackTrace();  // Log the exception for debugging
			        request.setAttribute("error", "Erreur lors de la récupération des douleurs : " + e.getMessage());
			        request.getRequestDispatcher("/error.jsp").forward(request, response);
			    }
				request.setAttribute("douleurs", douleurs);
//	        	request.getRequestDispatcher("/douleurs.jsp").forward(request, response);
	        	request.getRequestDispatcher("/Graphes.jsp").forward(request, response);

			
	 } else  if (action.equals("deleteDouleur")) {
	        int id_douleur = Integer.parseInt(request.getParameter("id_douleur"));


	    	try {
	    	    DouleurDaoImpl douleurDao = new DouleurDaoImpl(DAOFactory.getInstance());
	    	   douleurDao.deleteDouleur(id_douleur); // Assurez-vous d'avoir une méthode getAllPublications dans votre PublicationDaoImpl
	    	} catch (DAOException e) {
	    	    // Gérez les erreurs de la couche DAO
	    	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
	    	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	    	}

//	    	request.setAttribute("publications", publications);
	    	request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

		  
	 } else if (action.equals("updateDouleur")) {
		 
		    int id_douleur = Integer.parseInt(request.getParameter("id_douleur"));
		    int degre = Integer.parseInt(request.getParameter("degre"));

		    String newLocalisation = request.getParameter("localisation");
		    String newSentiment = request.getParameter("sentiment");
		    String newDate = request.getParameter("date");


		    try {
		        DouleurDaoImpl douleurDao = new DouleurDaoImpl(DAOFactory.getInstance());
		        douleurDao.updateDouleur(id_douleur, degre,newSentiment ,newLocalisation, newDate);
		    } catch (DAOException e) {
		        // Gérez les erreurs de la couche DAO
		        request.setAttribute("error", "Erreur lors de la mise à jour du commentaire : " + e.getMessage());
		        request.getRequestDispatcher("/erreur.jsp").forward(request, response);
		        return; // Ajoutez un return pour éviter de poursuivre l'exécution du code en cas d'erreur
		    }

		    // Redirigez vers la page appropriée après la mise à jour du commentaire
		    response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
		
		// Dans votre servlet
	 } else if (action.equals("graph")) {
		 	int id_user= Integer.parseInt(request.getParameter("id_user"));
		 	System.out.println("ID utilisateur : " + id_user);

		 
		    try {
		        DouleurDaoImpl douleurDao = new DouleurDaoImpl(DAOFactory.getInstance());
		        DouleurBean[] douleurs = douleurDao.getAllDouleurByUser(id_user);

		        // Convertir les données en format JSON
		        Gson gson = new Gson();
		        String jsonData = gson.toJson(douleurs);

		        request.setAttribute("jsonData", jsonData);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/graphFinal.jsp");
		        dispatcher.forward(request, response);
		    } catch (DAOException | IOException | ServletException e) {
		        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		        response.getWriter().write("Erreur lors de la récupération des données : " + e.getMessage());
		    }
		}


	}

	 // Méthode pour convertir les douleurs en format JSON (ex : en utilisant Jackson)
	private String convertToJson(DouleurBean[] douleurs) throws JspTagException {
	    Gson gson = new Gson();
	    return gson.toJson(douleurs);
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}