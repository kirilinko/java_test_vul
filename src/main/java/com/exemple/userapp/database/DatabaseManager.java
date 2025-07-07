package userapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    public void executeUserQuery(String conditionClause) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement stmt = conn.createStatement();

            String baseQuery = "SELECT * FROM users WHERE ";
            String finalQuery = baseQuery + conditionClause;

            // Injection possible si `conditionClause` est mal construit
            ResultSet rs = stmt.executeQuery(finalQuery);

            while (rs.next()) {
                System.out.println("Utilisateur trouvé : " + rs.getString("username"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erreur DB: " + e.getMessage());
        }
    }
}
