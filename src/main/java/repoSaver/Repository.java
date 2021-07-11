package repoSaver;

import utils.User;

import java.sql.SQLException;

public interface Repository {
    void saveUser(User user) throws SQLException;
    String getUser(Integer userID);

}
