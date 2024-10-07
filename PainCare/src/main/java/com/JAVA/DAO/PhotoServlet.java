package com.JAVA.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;

import com.JAVA.Bean.PhotoBean;
import com.JAVA.Bean.PubBean;

/**
 * Servlet implementation class PhotoServlet
 */


@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // Limite de taille du fichier (ici, 5 Mo)

//@MultipartConfig
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		 

    if (action.equals("insertPhoto")) {
            int id_user = Integer.parseInt(request.getParameter("id_user"));
            Part filePart = request.getPart("photo");

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
        	
    
	}else if (action.equals("getMyPic")) {
		int id_user= Integer.parseInt(request.getParameter("id_user"));
		
	    PhotoBean[] photos = null;

	    try {
	        PhotoDaoImpl photoDao = new PhotoDaoImpl(DAOFactory.getInstance());
	        photos = photoDao.getMinePhoto(id_user);

	        // Encodez les photos en Base64
	        for (PhotoBean photo : photos) {
	            byte[] photoBytes = photo.getPhoto();
	            if (photoBytes != null && photoBytes.length > 0) {
	                String base64Photo = Base64.getEncoder().encodeToString(photoBytes);
	                photo.setPhotoBase64(base64Photo);
	            }
	        }

	    } catch (DAOException e) {
	        // Gérez les erreurs de la couche DAO
	        request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
	        request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	    }

	    request.setAttribute("photos", photos);
	    request.getRequestDispatcher("/Tester.jsp").forward(request, response);
		
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
