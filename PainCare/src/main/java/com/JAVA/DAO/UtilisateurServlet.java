package com.JAVA.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.JAVA.Bean.UtilisateurBean;
import com.JAVA.Bean.UtilisateurBean;

/**
 * Servlet implementation class UtilisateurServlet
 */
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getParameter("action");

		    
         
         if (action.equals("loginUtilisateur")) {
      		
  		  String email = request.getParameter("email");
            String password = request.getParameter("password");

            
            // Validation des paramètres (à adapter selon vos besoins)
            if (email != null && password != null) {
                UtilisateurDaoImpl UtilisateurDao = new UtilisateurDaoImpl(DAOFactory.getInstance());  // Vous devez obtenir cette instance d'une manière appropriée

                UtilisateurBean User = UtilisateurDao.loginUtilisateur(email, password);

                if (User != null) {
                    // L'authentification a réussi, vous pouvez rediriger ou effectuer d'autres actions ici
                    request.getSession().setAttribute("User", User);
                    request.getSession().setAttribute("UserId", User.getId());

                    response.sendRedirect("dashboard.jsp"); 
                } else {
                    // L'authentification a échoué, vous pouvez rediriger vers une page d'erreur ou effectuer d'autres actions
                    response.sendRedirect("error.jsp");
                }
            
            
            }else if (action.equals("logOut")) {
            	    // Invalider la session actuelle
            	    request.getSession().invalidate();

            	    // Rediriger vers la page de connexion ou une autre page appropriée
            	    response.sendRedirect("index.html");
            	
         
        
            }
         
 }else if ( action.equals("insertUtilisateur")) {
        // Récupérez les paramètres de la requête
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (nom != null && prenom != null && email != null) {
            try {
                UtilisateurDaoImpl test = new UtilisateurDaoImpl(DAOFactory.getInstance());

                // Créez un objet UtilisateurBean avec les informations de l'utilisateur
                UtilisateurBean newUtilisateur = new UtilisateurBean(0, nom, prenom, email, password);

                // Appelez la méthode insert pour ajouter l'utilisateur
                test.insertUtilisateur(newUtilisateur);

                // Redirigez vers une page de confirmation avec un message de succès
                request.setAttribute("message", "Utilisateur ajouté avec succès");
                this.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);

                // L'authentification a réussi, vous pouvez rediriger ou effectuer d'autres actions ici
				request.getSession().setAttribute("Utilisateur", newUtilisateur);
				request.getSession().setAttribute("UtilisateurId", newUtilisateur.getId());

				response.sendRedirect("dashboard.jsp");

            } catch (DAOException e) {
                // Gérez les erreurs de la couche DAO
                request.setAttribute("error", "Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());

                // Redirigez vers une page d'erreur en cas d'échec de l'ajout
                this.getServletContext().getRequestDispatcher("erreur.jsp").forward(request, response);
            }
        } else {
            // Gérez le cas où des informations obligatoires sont manquantes dans la requête
            request.setAttribute("error", "Informations d'utilisateur manquantes dans la requête");

            // Redirigez vers une page d'erreur en cas de données manquantes
            this.getServletContext().getRequestDispatcher("erreur.jsp").forward(request, response);
        }
        
        
        
 } else if (action.equals("deleteUtilisateur")) {
	    // Récupérez le nom de l'utilisateur à partir de l'URL
	    String nom = request.getParameter("nom");

	    if (nom != null && !nom.isEmpty()) {
	        try {
	            UtilisateurDaoImpl test = new UtilisateurDaoImpl(DAOFactory.getInstance());
	            test.deleteUtilisateur(nom); // Supprime l'utilisateur par nom

	            // Destruction de la session
	            HttpSession session = request.getSession(false); // récupère la session existante ou retourne null si elle n'existe pas
	            if (session != null) {
	                session.invalidate();
	            }

	            request.setAttribute("message", "Utilisateur supprimé avec succès");
	            response.sendRedirect("home.jsp");
	        } catch (DAOException e) {
	            request.setAttribute("error", "Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
	            response.sendRedirect("error.jsp");
	        }
	    } else {
	        request.setAttribute("error", "Le nom d'utilisateur ne peut pas être vide.");
	        response.sendRedirect("error2.jsp");
	    }
	


//this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

         
      // Dans votre méthode doPost de UtilisateurServlet
 } else if (action.equals("updateUtilisateur")) {
	    String nom = request.getParameter("nom");
	    
	    String prenom = request.getParameter("prenom");
	    String email = request.getParameter("email");
	    String newPassword = request.getParameter("password");

	    try {
	        UtilisateurDaoImpl UtilisateurDao = new UtilisateurDaoImpl(DAOFactory.getInstance());
	        UtilisateurBean Utilisateur = (UtilisateurBean) request.getSession().getAttribute("Utilisateur");

	        // Vérifier que le mot de passe entré correspond à celui stocké dans la base de données
	        String enteredPassword = request.getParameter("password");

	        if (enteredPassword != null && UtilisateurDao.checkPassword(Utilisateur.getId(), enteredPassword)) {
	            // Le mot de passe entré correspond, autoriser la mise à jour
	            Utilisateur.setNom(nom);
	            Utilisateur.setPrenom(prenom);
	            Utilisateur.setEmail(email);

	            // Vérifier si un nouveau mot de passe a été saisi
	            if (newPassword != null && !newPassword.isEmpty()) {
	                Utilisateur.setPassword(newPassword);
	            }

	            UtilisateurDao.updateUtilisateur(Utilisateur);

	            request.getSession().setAttribute("Utilisateur", Utilisateur);
	            request.setAttribute("message", "Informations mises à jour avec succès");
	            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	        } else {
	            // Le mot de passe entré ne correspond pas, afficher un message d'erreur
	            request.setAttribute("error", "Le mot de passe entré ne correspond pas à celui stocké dans la base de données");
	            request.getRequestDispatcher("errorUpdate.jsp").forward(request, response);
	        }
	    } catch (DAOException e) {
	        request.setAttribute("error", "Erreur lors de la mise à jour des informations : " + e.getMessage());
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }
	}
         
         
         
 else if(action.equals("diagnostic")) {
	 

          // Récupérer les valeurs des champs du formulaire
          String taille = request.getParameter("taille");
          String poids = request.getParameter("poids");
          String q3 = request.getParameter("q3");
          String q4 = request.getParameter("q4");
          String q5 = request.getParameter("q5");
          String q6 = request.getParameter("q6");    
          String q8 = request.getParameter("q8");
     
          // Convertir les valeurs en double
          double tailleDouble = Double.parseDouble(taille);
          double poidsDouble = Double.parseDouble(poids);

          // Calculer l'IMC
          double imc_calcul = calculerIMC(tailleDouble, poidsDouble);
       
          String imc = interpreterIMC(imc_calcul);
          request.setAttribute("imc", imc);


          // Effectuer le diagnostic en fonction des réponses
          String diagnostic = effectuerDiagnostic( q3,q4,q5,q6,q8);

          // Envoyer le diagnostic à la page JSP appropriée
          request.setAttribute("diagnostic", diagnostic);
          request.getRequestDispatcher("DiagnosticResponse.jsp").forward(request, response);
          
          
          
          
          
      } else {
          // Gérer d'autres actions ou rediriger vers une page d'erreur si nécessaire
          response.sendRedirect("error.jsp");
      }
 
  }

	public String interpreterIMC(double imc_calcul) {

		String resultat ="Acun resultat" ;
		
	    if (imc_calcul < 18.5) {
	        // Masse corporelle insuffisante
	        // Peut être associé à une évaluation spécifique de l'endométriose
	    	
	    	resultat ="Votre masse corporelle est inférieur à 18.5 :  Masse corporelle insuffisante  .  "
	    			;
	       
	    } else if (imc_calcul >= 18.5 && imc_calcul < 24.9) {
	        // Masse corporelle normale
	        // Peut être associé à une évaluation spécifique de l'endométriose
	    	
	    	resultat ="Votre masse corporelle est entre 18.5 et 24.9:  Masse corporelle normale . "
	    			;
	    	
	    	
	    } else if (imc_calcul >= 25 && imc_calcul < 29.9) {
	        // Surpoids
	        // Peut être associé à une évaluation spécifique de l'endométriose
	    	resultat ="Votre masse corporelle est entre 25 et 29.9:  Surpoids    "
	    			;
	    	
	    } else {
	    	
	    	resultat =" Votre masse corporelle est supérieur à 30 : Surpoids ." ;
	    }
	    
	    
	    return resultat;
	}

     
     
     
	public String effectuerDiagnostic(String q3,String q4, String q5, String q6 ,String q8) {
      // Effectuer le diagnostic en fonction des réponses
      // Exemple de traitement simplifié :
      String diagnostic = "Aucun diagnostic spécifique.";

      if ( 	  "oui".equals(q3) && 
    		  "non".equals(q4) &&
    		  "oui".equals(q5) && 
    		  "9-10".equals(q6) && 
    		  "9-10".equals(q8)  ){
    		
    	  
    	  
          diagnostic = "Vous présentez un grand risque d'être atteinte d'endométriose. Veuillez consultez un médecin le plus tôt possible.";
      } else if (
    		  "oui".equals(q3) && 
    		  "non".equals(q4) &&
    		  "oui".equals(q5) && 
    		  "9-10".equals(q6) && 
    		  "6-8".equals(q8) ) {
    	  
          diagnostic = "Il est fort probable que vous ayez l'endométriose, mais consultez un professionnel de la santé pour confirmer.";
      
      
      } else if (
    		  "oui".equals(q3) && 
    		  "non".equals(q4) &&
    		  "oui".equals(q5) && 
    		  "6-8".equals(q6) && 
    		  "9-10".equals(q8) ) {
    	  
          diagnostic = "Il est fortement probable que vous ayez l'endométriose, mais consultez un professionnel de la santé pour confirmer.";
      
      
		} else if ( 
				"oui".equals(q3) && 
				  "oui".equals(q4) &&
				  "non".equals(q5) && 
				  "9-10".equals(q6) && 
				  "9-10".equals(q8) ) {
			  
		    diagnostic = "Il est  probable que vous ayez l'endométriose, mais consultez un professionnel de la santé pour confirmer.";
		

      } else if ( 
    		  "oui".equals(q3) && 
    		  "non".equals(q4) &&
    		  "non".equals(q5) && 
    		  "9-10".equals(q6) && 
    		  "9-10".equals(q8) ) {
    	  
          diagnostic = "Il est probable que vous ayez l'endométriose, mais consultez un professionnel de la santé pour confirmer.";
      
      } else if (
    		  "oui".equals(q3) && 
    		  "non".equals(q4) &&
    		  "oui".equals(q5) && 
    		  "3-5".equals(q6) && 
    		  "3-5".equals(q8) ) {
    	  
          diagnostic = "Il est peu probable que vous ayez l'endométriose, mais consultez un professionnel de la santé pour confirmer.";
      }
      else { 
    	  diagnostic ="Vos symptômes sont normales vous n'aurez pas besion de consultez un médecin.";
      }
      return diagnostic;
  
	}
      
      public static double calculerIMC(double taille, double poids) {
          return poids / (taille * taille);
      }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
