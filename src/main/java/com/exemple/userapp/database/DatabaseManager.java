package userapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    public void executeUserQuery(String conditionClause) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            stmt = conn.createStatement();

            String baseQuery = "SELECT * FROM users WHERE ";
            String finalQuery = baseQuery + conditionClause;
            rs = stmt.executeQuery(finalQuery);

            while (rs.next()) {
                System.out.println("Utilisateur trouvé : " + rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("Erreur DB: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    }
}
