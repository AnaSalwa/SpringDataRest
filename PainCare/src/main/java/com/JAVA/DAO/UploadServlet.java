package com.JAVA.DAO;

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

//@WebServlet("/UploadServlet")
//@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // Limite de taille du fichier (ici, 5 Mo)
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream inputStream = null;

        try {
            // Récupérer la partie (Part) de la requête
            Part filePart = request.getPart("photo");

            // Vérifier si le fichier a été sélectionné
            if (filePart != null && filePart.getSize() > 0) {
                inputStream = filePart.getInputStream();

                // Appeler la méthode pour insérer la photo dans la base de données
                insertPhoto(inputStream);

                response.getWriter().println("Photo téléchargée avec succès.");
            } else {
                response.getWriter().println("Veuillez choisir une photo.");
            }
        } catch (Exception e) {
            response.getWriter().println("Erreur lors du téléchargement de la photo : " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private void insertPhoto(InputStream inputStream) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Obtenez votre connexion à la base de données ici (remplacez le code ci-dessous)
            // connection = YourDatabaseConnection.getConnection();

            // Exemple de requête d'insertion
            String sql = "INSERT INTO photo (photo) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);

            // Paramètre pour la colonne de photo
            preparedStatement.setBlob(1, inputStream);

            // Exécutez la mise à jour
            preparedStatement.executeUpdate();
        } finally {
            // Fermez les ressources (PreparedStatement et Connection) ici
        }
    }
}
