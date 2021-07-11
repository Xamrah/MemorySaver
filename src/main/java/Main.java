import guiMenu.UserMenu;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserMenu userMenu = new UserMenu();
        userMenu.startMenu();
    }
}
