package com.Gestion_Stock.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.Gestion_Stock.model.ProduitModel;

public class ProduitDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/db_gestion_stock?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String INSERT_SQL = "INSERT INTO produits (nom_produit, description, quantite_stock, prix_unitaire, categorie_produit) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM produits WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM produits";
    private static final String DELETE_SQL = "DELETE FROM produits WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE produits SET nom_produit = ?, description = ?, quantite_stock = ?, prix_unitaire = ?, categorie_produit = ? WHERE id = ?";

    public ProduitDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertProduit(ProduitModel pr) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, pr.getNom());
            preparedStatement.setString(2, pr.getDescription());
            preparedStatement.setInt(3, pr.getQuantite());
            preparedStatement.setDouble(4, pr.getPrix());
            preparedStatement.setString(5, pr.getCategorie());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public ProduitModel selectProduit(int id) {
        ProduitModel pr = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                pr = new ProduitModel(
                        rs.getInt("id"),
                        rs.getString("nom_produit"),
                        rs.getString("description"),
                        rs.getInt("quantite_stock"),
                        rs.getDouble("prix_unitaire"),
                        rs.getString("categorie_produit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pr;
    }

    public List<ProduitModel> selectAllProduits() {
        List<ProduitModel> produits = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
               
                        int id = rs.getInt("id");
                       String nom =  rs.getString("nom_produit");
                        String description = rs.getString("description");
                        int quantity = rs.getInt("quantite_stock");
                        Double prix  = rs.getDouble("prix_unitaire");
                        String category = rs.getString("categorie_produit");
                        produits.add(new ProduitModel(id,nom, description, quantity, prix, category));
                    	System.out.println("testmodel");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println( produits);

        return produits;
    }
    

    public boolean deleteProduit(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateProduit(ProduitModel pr) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, pr.getNom());
            preparedStatement.setString(2, pr.getDescription());
            preparedStatement.setInt(3, pr.getQuantite());
            preparedStatement.setDouble(4, pr.getPrix());
            preparedStatement.setString(5, pr.getCategorie());
            preparedStatement.setInt(6, pr.getId());  
            //rowUpdated = preparedStatement.executeUpdate() > 0;
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Nombre de lignes mises à jour : " + rowsAffected);
            rowUpdated = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Update successful: " + rowUpdated);
        return rowUpdated;
    }
}
