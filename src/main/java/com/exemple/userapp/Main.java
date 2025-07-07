package userapp;

import userapp.input.UserInputHandler;
import userapp.database.DatabaseManager;

public class Main {
    public static void main(String[] args) {
        UserInputHandler inputHandler = new UserInputHandler();
        String username = inputHandler.askForUsername();

        
        String whereClause = inputHandler.formatCondition(username);

        DatabaseManager db = new DatabaseManager();
        db.getUserInfo(whereClause);
    }
}
