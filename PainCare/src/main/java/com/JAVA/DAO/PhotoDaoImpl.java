package com.JAVA.DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Bean.PhotoBean;
import com.JAVA.Bean.PubBean;

public class PhotoDaoImpl {
	

    private DAOFactory daoFactory;

    public PhotoDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	
    
    public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
}

    
    public void insertPhoto(PhotoBean photo) throws DAOException {
	    final String SQL_INSERT = "INSERT INTO photo (id_user, photo) VALUES (?, ?)";

	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connection = daoFactory.getConnection();
	        preparedStatement = connection.prepareStatement(SQL_INSERT);

	        preparedStatement.setInt(1, photo.getId_user());
	        preparedStatement.setBytes(2, photo.getPhoto());

	        preparedStatement.executeUpdate(); // Utilisez executeUpdate pour les requêtes d'insertion

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	       
	    }
	}
    
    public PhotoBean[] getMinePhoto(int id_user) throws DAOException {
	    final String SQL_SELECT_MINE_PUB = "SELECT * FROM photo WHERE id_user = ?";

	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = daoFactory.getConnection();
	        preparedStatement = connection.prepareStatement(SQL_SELECT_MINE_PUB);
	        preparedStatement.setInt(1, id_user);
	        resultSet = preparedStatement.executeQuery();

	        ArrayList<PhotoBean> photos = new ArrayList<>();

	        while (resultSet.next()) {
	            // Mappez les données de la publication à partir du ResultSet
	            int id = resultSet.getInt("id");
	            Blob photoBlob = resultSet.getBlob("photo");
	            byte[] photoBytes = null;
	            if (photoBlob != null) {
	                photoBytes = photoBlob.getBytes(1, (int) photoBlob.length());
	            }

	            // Créez un objet PubBean avec les informations récupérées
	            PhotoBean photo = new PhotoBean(id, id_user);
	            photo.setPhoto(photoBytes);

	            // Ajoutez la publication à la liste
	            photos.add(photo);
	        }

	        // Convertissez la liste en tableau
	        PhotoBean[] photosArray = photos.toArray(new PhotoBean[0]);

	        return photosArray;
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	        // Fermez les ressources dans le bloc finally
	        // ClosingAll(resultSet, preparedStatement, connection);
	    }
	}

}
