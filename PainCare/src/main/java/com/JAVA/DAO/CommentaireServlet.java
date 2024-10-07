package com.JAVA.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.JAVA.Bean.CommentaireBean;
import com.JAVA.Bean.PublicationBean;

/**
 * Servlet implementation class CommentaireServlet
 */
public class CommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		 

        if ("addComment2".equals(action)) {
            try {
                // Récupérer les valeurs du formulaire
                String commentaire= request.getParameter("commentaire");
                int id_user = Integer.parseInt(request.getParameter("id_user"));
                int id_publication = Integer.parseInt(request.getParameter("id_publication"));


                // Assurez-vous que les valeurs sont non nulles avant de les traiter
                if (commentaire != null && id_publication != 0 && id_user !=0) {
                	
                    CommentaireDaoImpl commentDao = DAOFactory.getInstance().getCommentaireDao();

                    // Créer un objet représentant la publication
                   CommentaireBean newComment = new CommentaireBean(0, id_publication, id_user, commentaire);

                    // Ajouter la publication à la base de données
                    commentDao.addComment(newComment);

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
            
            
        
	
			} else if (action.equals("addComment")) {
			     // Récupérer les valeurs du formulaire
                String commentaire= request.getParameter("commentaire");
                int id_user = Integer.parseInt(request.getParameter("id_user"));
                int id_publication = Integer.parseInt(request.getParameter("id_publication"));
			
                if (commentaire != null && id_publication != 0 && id_user !=0) {
			        try {
			            CommentaireDaoImpl commentDao = new CommentaireDaoImpl(DAOFactory.getInstance());
		                CommentaireBean newComment = new CommentaireBean(0, id_publication, id_user, commentaire);
			            commentDao.addComment(newComment);
			
			            request.setAttribute("message", "Publication ajoutée avec succès");
			            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			        } catch (DAOException e) {
			            request.setAttribute("error", "Erreur lors de l'ajout de la publication : " + e.getMessage());
			            request.getRequestDispatcher("/error.jsp").forward(request, response);
			        }
			    } else {
			        request.setAttribute("error", "Informations de publication manquantes dans la requête");
			        request.getRequestDispatcher("/error2.jsp").forward(request, response);
			    }
                
			}else  if (action.equals("getAllComments")) {
		        	CommentaireBean[] comments = null;
	                int id_publication = Integer.parseInt(request.getParameter("id_publication"));


		        	try {
		        	    CommentaireDaoImpl commentDao = new CommentaireDaoImpl(DAOFactory.getInstance());
		        	    comments = commentDao.getAllComments(id_publication); 
		        	} catch (DAOException e) {
		        	    // Gérez les erreurs de la couche DAO
		        	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
		        	    request.getRequestDispatcher("/error.jsp").forward(request, response);
		        	}

		        	request.setAttribute("comments", comments);
		        	request.getRequestDispatcher("/allComment.jsp").forward(request, response);

		        	
		        	
		        	
		        	
		        	
		        	
			
			}else  if (action.equals("getMyComments")) {
				
		        	CommentaireBean[] comments = null;
	                int id_publication = Integer.parseInt(request.getParameter("id_publication"));
	                int id_user = Integer.parseInt(request.getParameter("id_user"));



		        	try {
		        	    CommentaireDaoImpl commentDao = new CommentaireDaoImpl(DAOFactory.getInstance());
		        	    comments = commentDao.getMyComments(id_publication,id_user); 
		        	} catch (DAOException e) {
		        	    // Gérez les erreurs de la couche DAO
		        	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
		        	    request.getRequestDispatcher("/error.jsp").forward(request, response);
		        	}

		        	request.setAttribute("comments", comments);
		        	request.getRequestDispatcher("/MesCommentaires.jsp").forward(request, response);

		        	
		        
        
	
	 } else  if (action.equals("deleteComment")) {
	    	CommentaireBean[] comments = null;
	        int id_commentaire = Integer.parseInt(request.getParameter("id_commentaire"));


	    	try {
	    	    CommentaireDaoImpl commentaireDao = new CommentaireDaoImpl(DAOFactory.getInstance());
	    	   commentaireDao.deleteComment(id_commentaire); // Assurez-vous d'avoir une méthode getAllPublications dans votre PublicationDaoImpl
	    	} catch (DAOException e) {
	    	    // Gérez les erreurs de la couche DAO
	    	    request.setAttribute("error", "Erreur lors de la récupération des publications : " + e.getMessage());
	    	    request.getRequestDispatcher("/erreur.jsp").forward(request, response);
	    	}

//	    	request.setAttribute("publications", publications);
	    	request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

		  
	 } else if (action.equals("updateComment")) {
		    int id_commentaire = Integer.parseInt(request.getParameter("id_commentaire"));
		    String nouveauCommentaire = request.getParameter("commentaire");

		    try {
		        CommentaireDaoImpl commentaireDao = new CommentaireDaoImpl(DAOFactory.getInstance());
		        commentaireDao.updateComment(id_commentaire, nouveauCommentaire);
		    } catch (DAOException e) {
		        // Gérez les erreurs de la couche DAO
		        request.setAttribute("error", "Erreur lors de la mise à jour du commentaire : " + e.getMessage());
		        request.getRequestDispatcher("/erreur.jsp").forward(request, response);
		        return; // Ajoutez un return pour éviter de poursuivre l'exécution du code en cas d'erreur
		    }

		    // Redirigez vers la page appropriée après la mise à jour du commentaire
		    response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
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
