package Community;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
//import org.apache.commons.io.IOUtils;

import com.JAVA.Bean.*;
import com.JAVA.DAO.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;



@WebServlet("/CommunityServle")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,   // 2 MB
        maxFileSize = 1024 * 1024 * 10,         // 10 MB
        maxRequestSize = 1024 * 1024 * 50)      // 50 MB
public class CommunityServle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // Default action
        }

//        try (Connection connection = pconnec.getConnection()) {
//            try  {

            CommunityDAO communityDAO = new CommunityDAOImpl(DAOFactory.getInstance());

            switch (action) {
                case "list":
                    listCommunities(request, response, communityDAO);
                    break;
               
                case "add":
                    showAddForm(request, response);
                    break;
                case "insert":
                    insertCommunity(request, response, communityDAO);
                    break;
                default:
                    listCommunities(request, response, communityDAO);
            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database connection error");
//        }
    }

    private void listCommunities(HttpServletRequest request, HttpServletResponse response, CommunityDAO communityDAO)
            throws ServletException, IOException {
        List<Community> communities = communityDAO.getAll();

        // Encode images to Base64 before forwarding to JSP
        for (Community community : communities) {
            byte[] imageBytes = community.getImage();
            if (imageBytes != null && imageBytes.length > 0) {
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                community.setImageBase64(base64Image);
            }
        }

        request.setAttribute("communities", communities);
        request.getRequestDispatcher("community-list.jsp").forward(request, response);
    }

   

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addCommunity.jsp").forward(request, response);
    }

    private void insertCommunity(HttpServletRequest request, HttpServletResponse response, CommunityDAO communityDAO)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // Retrieve the user ID from the session
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("utilisateur");
        // Log the values
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("User ID: " + (user != null ? user.getId() : "null"));

        // Get the image file from the request
        Part filePart = request.getPart("image");
        InputStream imageInputStream = filePart.getInputStream();
        byte[] imageBytes = IOUtils.toByteArray(imageInputStream);

        // Create a new Community object
        Community community = new Community();
        community.setTitle(title);
        community.setDescription(description);
        community.setImage(imageBytes);

        // Set the user from the session
        community.setUser(user);

        // Insert the community into the database
        communityDAO.insert(community);

        // Redirect to the community list page
        response.sendRedirect("CommunityServlet?action=list");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
