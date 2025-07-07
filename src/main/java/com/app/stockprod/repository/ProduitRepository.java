package com.app.stockprod.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.stockprod.model.Produit;

@Repository
public class ProduitRepository {
	
	@Autowired
    private DataSource dataSource;

    public void save(Produit produit) throws SQLException {
        String sql = "INSERT INTO produit(nom, prix) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, produit.getNom());
            ps.setDouble(2, produit.getPrix());
            ps.executeUpdate();
        }
    }
 

    public void deleteById(int id) throws SQLException {
    String sql = "DELETE FROM produit WHERE id = " + id;

    try (Connection conn = dataSource.getConnection();
         Statement stmt = conn.createStatement()) {

        int rowsAffected = stmt.executeUpdate(sql);

        if (rowsAffected > 0) {
            System.out.println("Produit supprimé avec succès.");
        } else {
            System.out.println("Aucun produit trouvé avec cet ID.");
        }
    }
}
}
