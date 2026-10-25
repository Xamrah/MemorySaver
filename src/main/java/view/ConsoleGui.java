package view;

import model.User;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

import static utils.UserUtils.checkNames;

public class ConsoleGui {

    private static final Scanner sc = new Scanner(System.in);
    private static final UserService userService = new UserService();

    public void mainDialog(){
        int i = -1;
        while (i != 0){
            System.out.println("########################\n" +
            "1. Save data in memory\n" +
            "2. Save data in file\n" +
            "3. Save data in database\n" +
            "4. Save in ALL (Carefully! This function is unstable!)\n" +
                    "5. Show all user\n" +
            "########################\n" +
            "0. Exit\n");

            i = sc.nextInt();
            if (i >= 1 && i < 5 ) {
                userCreationDialog(i);
            } else if (i == 5)
                userShowDialog();
            }
        }


    void userCreationDialog(int direction){
        User user = new User();

        System.out.println("Please, write choice ID: ");
        user.setId(sc.nextInt());

        System.out.println("Please, write your name: ");
        user.setName(checkNames(sc.next()));

        System.out.println("Please, write your age: ");
        user.setAge(sc.nextInt());

        System.out.println("Please, write your country: ");
        user.setCountry(checkNames(sc.next()));

        switch (direction){
            case 1:
                userService.saveInMemory(user);
                break;
            case 2:
                userService.saveInFile(user);
                break;
            case 3:
                try {
                    userService.saveInDatabase(user);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    userService.saveAll(user);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    void userShowDialog() {
        try {
            userService.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
