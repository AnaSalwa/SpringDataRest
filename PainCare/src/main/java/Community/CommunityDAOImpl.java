package Community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.JAVA.Bean.*;
import com.JAVA.DAO.DAOFactory;

public class CommunityDAOImpl implements CommunityDAO {

    private Connection connection;

    public CommunityDAOImpl(DAOFactory daoFactory) {
        this.connection = (Connection) daoFactory;
    }

    

    @Override
    public List<Community> getAll() {
        List<Community> communities = new ArrayList<>();
        String sql = "SELECT c.*, u.name AS user_name FROM community c JOIN utilisateur u ON c.id_user = u.id_user";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Community community = new Community();
                community.setIdComm(resultSet.getInt("id_comm"));
                community.setTitle(resultSet.getString("title"));
                community.setDescription(resultSet.getString("description"));

                // Extract image
                byte[] imageBytes = resultSet.getBytes("image");
                if (imageBytes != null && imageBytes.length > 0) {
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    community.setImageBase64(base64Image);
                }

                // Create a new Utilisateur object
                UserBean user = new UserBean();
                user.setNom(resultSet.getString("user_name"));

                // Set the user for the community
                community.setUser(user);

                communities.add(community);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return communities;
    }


    @Override
    public List<Community> getByUserId(int id_user) {
        List<Community> communities = new ArrayList<>();
        String sql = "SELECT c.*, u.name AS user_name FROM community c JOIN utilisateur u ON c.id_user = u.id_user WHERE u.id_user = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_user);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Community community = new Community();
                community.setIdComm(resultSet.getInt("id_comm"));
                community.setTitle(resultSet.getString("title"));
                community.setDescription(resultSet.getString("description"));

                // Extract image
                byte[] imageBytes = resultSet.getBytes("image");
                if (imageBytes != null && imageBytes.length > 0) {
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    community.setImageBase64(base64Image);
                }

                // Add user name associated with the community
                community.getUser().setNom(resultSet.getString("user_name"));

                communities.add(community);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return communities;
    }
    @Override
    public void insert(Community community) {
        String sql = "INSERT INTO community (id_user, title, description, image) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Check for null user
            if (community.getUser() != null) {
                int userId = community.getUser().getId();
                System.out.println("User ID: " + userId);  // Log the user ID
                statement.setInt(1, userId);
            } else {
                statement.setNull(1, java.sql.Types.INTEGER);
            }

            statement.setString(2, community.getTitle());
            statement.setString(3, community.getDescription());

            // Add image
            if (community.getImageInputStream() != null) {
                statement.setBinaryStream(4, community.getImageInputStream());
            } else if (community.getImage() != null) {
                statement.setBytes(4, community.getImage());
            } else {
                statement.setNull(4, java.sql.Types.BLOB);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



   
}