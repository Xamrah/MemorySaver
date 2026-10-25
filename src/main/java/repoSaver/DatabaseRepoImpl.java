package repoSaver;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseRepoImpl implements Repository {

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
    static {
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


    @Override
    public String getUsers() throws SQLException {
        PreparedStatement statement = nowConnection.prepareStatement("select * from userlist");
        boolean hasResult = statement.execute();

        if(hasResult) {
            List<User> users = new ArrayList<>();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                User U = new User();
                U.setId(resultSet.getInt(1));
                U.setName(resultSet.getString(2));
                U.setAge(resultSet.getInt(3));
                U.setCountry(resultSet.getString(4));
                users.add(U);
            }
            StringBuilder result = new StringBuilder();
            for (User user: users) {
                result.append(user.toString()).append("\n");
            }
            return result.toString();
        }

        return "DataBase is empty.";
    }
}
