package service;

import repoSaver.SaveInMemory;

import java.util.HashMap;
import java.util.Scanner;

import static utils.UserUtils.checkNames;

public class UserService {

    Scanner scanner = new Scanner(System.in);
    Restore restore = new Restore();

    private HashMap enterData(){

        System.out.println("Please, write your name: ");
        String nameUser = checkNames(scanner.next());

        System.out.println("Please, write your age: ");
        String ageUser = String.valueOf(scanner.nextInt());

        System.out.println("Please, write your country: ");
        String countryUser = checkNames(scanner.next());

        return createUserDataPack(nameUser, ageUser, countryUser);
    }
    

    private HashMap createUserDataPack (String nameUser, String ageUser, String countyUser) {
        HashMap<String, String> userDataPack = new HashMap<>();

        userDataPack.put("nameUser", nameUser);
        userDataPack.put("ageUser", ageUser);
        userDataPack.put("countryUser", countyUser);

        return userDataPack;
    }

    public void transmisson(Short numOperation){
        SaveInMemory saveInMemory = new SaveInMemory();
        switch (numOperation){
            case 1:
                saveInMemory.saveUser(enterData());
                break;
            case 4:
                System.out.println("Enter userID: ");
                System.out.println(saveInMemory.getUser(scanner.nextInt()));
                restore.restart();
                break;
            default:
                System.out.println("Oopsss.... it's not work yet ^_^");
                restore.restart();
        }
    }
}
