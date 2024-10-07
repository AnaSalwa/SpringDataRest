package Community;


import java.util.List;

public interface CommunityDAO {
    
    List<Community> getAll();
    List<Community> getByUserId(int id_user);
    void insert(Community community);
}
