package Community;


import java.io.InputStream;

import com.JAVA.Bean.*;

public class Community {
    private int id_comm;
    private UserBean user;
    private String title;
    private String description;
    private byte[] image;  // Donn�es binaires de l'image
    private String imageBase64;

    // Ajout d'une propri�t� pour stocker le nom du fichier de l'image
    private String imageFileName;

    // Ajout d'une propri�t� pour stocker le flux d'entr�e de l'image
    private InputStream imageInputStream;

    public Community() {
        // Constructeur par d�faut
    }

    public Community(int id_comm, UserBean user, String title, String description, byte[] image, String imageFileName, InputStream imageInputStream) {
        this.id_comm = id_comm;
        this.user = user;
        this.title = title;
        this.description = description;
        this.image = image;
        this.imageFileName = imageFileName;
        this.imageInputStream = imageInputStream;
    }

    // Getters et Setters pour les nouvelles propri�t�s
    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public InputStream getImageInputStream() {
        return imageInputStream;
    }

    public void setImageInputStream(InputStream imageInputStream) {
        this.imageInputStream = imageInputStream;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    // Getters et Setters pour les propri�t�s existantes
    public int getIdComm() {
        return id_comm;
    }

    public void setIdComm(int id_comm) {
        this.id_comm = id_comm;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Reste du code inchang�...

    // Vous pouvez �galement ajouter des m�thodes pour traiter les donn�es de l'image si n�cessaire
}