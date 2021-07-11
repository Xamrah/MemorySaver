package repoSaver;

import utils.User;

import java.sql.*;
import java.util.Properties;

public class SaveInDatabase implements Repository {

    public static Connection connection() throws SQLException {
        String url = "jdbc:postgresql://localhost/elib_test";
        Properties props = new Properties();
        props.setProperty("user","elib_user");
        props.setProperty("password","elib123");
        props.setProperty("characterEncoding","UTF-8");
        Connection conn = DriverManager.getConnection(url, props);
        return conn;
    }

    public static Connection nowConnection;
    {
        try {
            nowConnection = connection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveUser(User user) throws SQLException {
        PreparedStatement ps = nowConnection.prepareStatement("insert into userlist (id, name, age, country) values (?, ?, ?, ?)");
        ps.setInt(1, user.getId());
        ps.setString(2, user.getName());
        ps.setInt(3, user.getAge());
        ps.setString(4, user.getCountry());
        boolean execute = ps.execute();
    }

    private User downloadUser(Integer userID, Connection nowConnection) throws SQLException {
        PreparedStatement statement = nowConnection.prepareStatement("select * from userlist where id = ?");
        statement.setInt(1, userID);
        boolean hasResult = statement.execute();

        if(hasResult) {
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
            return user;
        }
        return null;
    }

    @Override
    public String getUser(Integer userID) {
        User currentUser = null;
        try {
            currentUser = downloadUser(userID, nowConnection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (currentUser != null) {
            return currentUser.toString();
        } else {
            return "Not found user";
        }
    }
}
