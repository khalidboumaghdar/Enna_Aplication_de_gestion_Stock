package com.Gestion_Stock.model;

public class ProduitModel {
	private int id;
    private String nom;
    private String description;
    private int quantite;
    private double prix;
    private String categorie_produit;

    public ProduitModel(int id, String nom, String description, int quantite, double prix, String categorie_produit) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie_produit = categorie_produit;
    }
    public ProduitModel( String nom, String description, int quantite, double prix, String categorie_produit) {

        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie_produit = categorie_produit;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie_produit;
    }

    public void setCategorie(String categorie_produit) {
        this.categorie_produit = categorie_produit;
    }

    @Override
    public String toString() {
        return "produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                ", categorie='" + categorie_produit + '\'' +
                '}';
    }
}
