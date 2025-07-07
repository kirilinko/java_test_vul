package userapp.input;

import java.util.Scanner;

public class UserInputHandler {
    public String askForUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre nom d'utilisateur : ");
        return scanner.nextLine();
    }

    public String formatCondition(String username) {
        return "username = '" + username + "'";
    }
}
