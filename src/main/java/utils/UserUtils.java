package utils;

import java.util.Scanner;

public class UserUtils {

    public static String checkNames(String name){

        Scanner scanner = new Scanner(System.in);
        //Не могу придумать, как убрать сканнер
        while (!(name.toLowerCase().matches("(.*[a-z]+.*)"))){
            System.out.println("Please, use latin letters only!");
            System.out.println("Repeat enter: ");
            name = scanner.next();
        }

        return name;
    }
}
