package userapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    public void executeUserQuery(String conditionClause) {
        String baseQuery = "SELECT * FROM users WHERE ";
        String finalQuery = baseQuery + conditionClause;

        // Utilisation du try-with-resources pour la gestion automatique des ressources
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(finalQuery)
        ) {
            while (rs.next()) {
                System.out.println("Utilisateur trouvé : " + rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("Erreur DB: " + e.getMessage());
        }
    }
}
sss