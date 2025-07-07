package com.app.stockprod.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
 
import java.util.ArrayList;
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.stockprod.model.User;
import com.app.stockprod.model.Produit;
@Repository
public class UserRepository {

	@Autowired
    DataSource dataSource;

    public void save(User utilisateur) throws SQLException {
        String sql = "INSERT INTO utilisateur(nom, email, mot_de_passe) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, utilisateur.getNom());
            ps.setString(2, utilisateur.getEmail());
            ps.setString(3, utilisateur.getMotDePasse());
            ps.executeUpdate();
        }
    }

    public User findByEmail(String email) throws SQLException {
    	String sql = "SELECT * FROM utilisateur WHERE email = '";
        String finalsql = sql + email + "'";
        
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(finalsql) ) {

                if (rs.next()) {
                    return new User(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe")
                    );
                }
        }
        return null;
    }

    public List<Produit> findByName(String name) throws SQLException {
        String sql = "SELECT * FROM produit WHERE nom = '" + name + "'";

        List<Produit> produits = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
  
        
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                produits.add(new Produit(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getDouble("prix")
                ));
            }
        }

        return produits;
    }
}
