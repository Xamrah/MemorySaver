package repoSaver;

import model.User;

import java.sql.SQLException;

public interface Repository {
    void saveUser(User user) throws SQLException;
    String getUsers() throws SQLException;

}
