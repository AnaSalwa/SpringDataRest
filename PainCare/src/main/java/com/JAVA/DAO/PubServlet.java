package com.JAVA.DAO;

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

//@MultipartConfig

public class PubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PubServlet() {
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
	                    PubBean newPub = new PubBean(0, id_user, titre, description);

	                    // Ajouter la publication à la base de données
	                    PubDaoImpl pubDao = DAOFactory.getInstance().getPubDao();
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
	            Part filePart = request.getPart("photo");

	            if (titre != null && description != null && filePart != null) {
	                try {
	                    InputStream imageInputStream = filePart.getInputStream();
	                    byte[] photoBytes = IOUtils.toByteArray(imageInputStream);

	                    PubDaoImpl publicationDao = new PubDaoImpl(DAOFactory.getInstance());

	                    // Création d'un objet PubBean avec la photo
	                    PubBean newPublication = new PubBean(0, id_user, titre, description, photoBytes);

	                    // Insertion de la publication avec la photo
	                    publicationDao.insertPub(newPublication);

	                    request.setAttribute("message", "Publication ajoutée avec succès");
	                    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	                } catch (IOException | ServletException | DAOException e) {
	                    // Gestion des exceptions lors de l'ajout de la publication
	                    e.printStackTrace(); // Affichez l'erreur dans les journaux du serveur
	                    request.setAttribute("error", "Erreur lors de l'ajout de la publication : " + e.getMessage());
	                    request.setAttribute("exception", e); // Ajoutez l'exception comme attribut pour l'afficher sur la page d'erreur
	                    request.getRequestDispatcher("/error1.jsp").forward(request, response);
	                }

	            } else {
	                request.setAttribute("error", "Informations de publication manquantes dans la requête");
	                request.getRequestDispatcher("/error2.jsp").forward(request, response);
	            }
	        
	
	
	            
	            
	            
			}else  if (action.equals("getAll")) {
	        	PubBean[] publications = null;

	        	try {
	        	    PubDaoImpl publicationDao = new PubDaoImpl(DAOFactory.getInstance());
	        	    publications = publicationDao.getAll(); // Assurez-vous d'avoir une méthode getAllPublications dans votre PubDaoImpl
	        	} catch (DAOException e) {
	        	    // Gérez les erreurs de la couche DAO
	        	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
	        	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	        	}

	        	request.setAttribute("publications", publications);
	        	request.getRequestDispatcher("/publication.jsp").forward(request, response);

	        	
	        	// ... (autre code)

			} else if (action.equals("getAllPublicationsWithUserNames")) {
			    PubBean[] publications = null;

			    try {
			        PubDaoImpl publicationDao = new PubDaoImpl(DAOFactory.getInstance());
			        publications = publicationDao.getAllPublicationsWithUserNames();

			        // Encodez les photos en Base64
			        for (PubBean publication : publications) {
			            byte[] photoBytes = publication.getPhoto();
			            if (photoBytes != null && photoBytes.length > 0) {
			                String base64Photo = Base64.getEncoder().encodeToString(photoBytes);
			                publication.setPhotoBase64(base64Photo);
			            }
			        }

			    } catch (DAOException e) {
			        // Gérez les erreurs de la couche DAO
			        request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
			        request.getRequestDispatcher("/error.jsp").forward(request, response);
			    }

			    request.setAttribute("publications", publications);
			    request.getRequestDispatcher("/publication.jsp").forward(request, response);
			
			// ... (autre code)


	        
//	        
//	        } else if (action.equals("getMine")) {
//	            PubBean[] publications = null;
//	            int id_user = Integer.parseInt(request.getParameter("id_user"));
//
//	            try {
//	                PubDaoImpl publicationDao = new PubDaoImpl(DAOFactory.getInstance());
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
	        
	
	    	
			} else if (action.equals("getMine")) {
			    PubBean[] publications = null;
			    int id_user = Integer.parseInt(request.getParameter("id_user"));

			    try {
			        PubDaoImpl publicationDao = new PubDaoImpl(DAOFactory.getInstance());
			        publications = publicationDao.getMinePub(id_user);

			        // Encodez les photos en Base64
			        for (PubBean publication : publications) {
			            byte[] photoBytes = publication.getPhoto();
			            if (photoBytes != null && photoBytes.length > 0) {
			                String base64Photo = Base64.getEncoder().encodeToString(photoBytes);
			                publication.setPhotoBase64(base64Photo);
			            }
			        }

			    } catch (DAOException e) {
			        // Gérez les erreurs de la couche DAO
			        request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
			        request.getRequestDispatcher("/erreur.jsp").forward(request, response);
			    }

			    request.setAttribute("publications", publications);
			    request.getRequestDispatcher("/MesPublications.jsp").forward(request, response);
			


	  
    } else  if (action.equals("deletePub")) {
    	PubBean[] publications = null;
        int id_publication = Integer.parseInt(request.getParameter("id_publication"));


    	try {
    	    PubDaoImpl publicationDao = new PubDaoImpl(DAOFactory.getInstance());
    	   publicationDao.deletePub(id_publication); // Assurez-vous d'avoir une méthode getAllPublications dans votre PubDaoImpl
    	} catch (DAOException e) {
    	    // Gérez les erreurs de la couche DAO
    	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
    	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
    	}

//    	request.setAttribute("publications", publications);
    	request.getRequestDispatcher("/MesPublications.jsp").forward(request, response);

	  
    
	} else if (action.equals("updatePub")) {
	    int id_publication = Integer.parseInt(request.getParameter("id_publication"));
	    String nouveauTitre = request.getParameter("titre");
	    String nouvelleDescription = request.getParameter("description");
        Part nouveaufilePart = request.getPart("photo");
        InputStream imageInputStream = nouveaufilePart.getInputStream();
        byte[] nouvellePhoto = IOUtils.toByteArray(imageInputStream);



	    try {
	        PubDaoImpl PubDao = new PubDaoImpl(DAOFactory.getInstance());
	        PubDao.updatePub(id_publication, nouveauTitre, nouvelleDescription, nouvellePhoto);
	    } catch (DAOException e) {
	        // Gérez les erreurs de la couche DAO
	        request.setAttribute("error", "Erreur lors de la mise à jour du commentaire : " + e.getMessage());
	        request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	        return; // Ajoutez un return pour éviter de poursuivre l'exécution du code en cas d'erreur
	    }

	    // Redirigez vers la page appropriée après la mise à jour du commentaire
	    response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
	}
	else if (action.equals("insertPhoto")) {
        int id_user = Integer.parseInt(request.getParameter("id_user"));
        Part filePart = request.getPart("upload");

        if (id_user != 0 && filePart != null) {
            try {
                InputStream imageInputStream = filePart.getInputStream();
                byte[] photoBytes = IOUtils.toByteArray(imageInputStream);

                PhotoDaoImpl photoDao = new PhotoDaoImpl(DAOFactory.getInstance());

                // Création d'un objet PubBean avec la photo
                PhotoBean newPhoto = new PhotoBean(0, id_user, photoBytes);

                // Insertion de la publication avec la photo
                photoDao.insertPhoto(newPhoto);

                request.setAttribute("message", "Photo ajoutée avec succès");
                request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
            } catch (IOException | ServletException | DAOException e) {
                // Gestion des exceptions lors de l'ajout de la publication
                e.printStackTrace(); // Affichez l'erreur dans les journaux du serveur
                request.setAttribute("error", "Erreur lors de l'ajout de la publication : " + e.getMessage());
                request.setAttribute("exception", e); // Ajoutez l'exception comme attribut pour l'afficher sur la page d'erreur
                request.getRequestDispatcher("/error1.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("error", "Informations de publication manquantes dans la requête");
            request.getRequestDispatcher("/error2.jsp").forward(request, response);
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
