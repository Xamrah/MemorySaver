package guiMenu;

import service.UserService;
import java.util.Scanner;

public class ChoiceMenu {

    UserService userService = new UserService();

    public void showChoice(){
        System.out.println("########################");
        System.out.println("1. Save data in memory");
        System.out.println("2. Save data in file");
        System.out.println("3. Save data in database");
        System.out.println("4. Show user");
        System.out.println("########################");
        System.out.println("Print 1, 2, 3 or 4 to make your choice!");

        userService.transmisson(getAction());
    }

    private Short getAction(){
        Scanner scanner = new Scanner(System.in);
        Short numAction = scanner.nextShort();
        while (numAction >= 4 || numAction <= 1){
            System.out.println("There is no such item! \nRepeat your choice: ");
            numAction = scanner.nextShort();
        }
        return numAction;
    }

}
