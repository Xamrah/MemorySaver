package service;

import repoSaver.SaveInDatabase;
import repoSaver.SaveInFile;
import repoSaver.SaveInMemory;
import utils.User;
import java.sql.*;
import java.util.Scanner;

import static utils.UserUtils.checkNames;

public class UserService {
    SaveInMemory saveInMemory = new SaveInMemory();
    SaveInDatabase saveInDatabase = new SaveInDatabase();
    SaveInFile saveInFile = new SaveInFile();
    Scanner scanner = new Scanner(System.in);



    static Integer freeMemUserID = 0;
    static Integer freeFileUserID = 0;
    static Integer freeDBUserID = 0;


    private User enterData(Integer freeUserID){
        System.out.println("Please, write your name: ");
        String nameUser = checkNames(scanner.next());

        System.out.println("Please, write your age: ");
        Integer ageUser = scanner.nextInt();

        System.out.println("Please, write your country: ");
        String countryUser = checkNames(scanner.next());

        User user = new User(freeUserID, nameUser, ageUser, countryUser);

        return user;
    }


    public void transmisson(Short numOperation) {
        switch (numOperation){
            case 1:
                saveInMemory.saveUser(enterData(freeMemUserID));
                freeMemUserID++;
                break;
            case 2:
                saveInFile.saveUser(enterData(freeFileUserID));
                freeFileUserID++;
                break;
            case 3:
                try {
                    saveInDatabase.saveUser(enterData(freeDBUserID));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                freeDBUserID++;
                break;
            case 4:
                System.out.println("Enter userID: ");
                Integer userId = scanner.nextInt();
//                System.out.println(saveInMemory.getUser(userId));
                System.out.println(saveInDatabase.getUser(userId));
                System.out.println(saveInFile.getUser(userId));
                break;
            default:
                System.out.println("Oopsss.... it's not work yet ^_^");
        }
    }
}
