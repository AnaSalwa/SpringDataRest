package com.JAVA.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;

import com.JAVA.Bean.PhotoBean;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
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
	        	}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
