create database db_gestion_stock;
use db_gestion_stock;
CREATE TABLE produits (
    id INT AUTO_INCREMENT PRIMARY KEY,          
    nom_produit VARCHAR(255) NOT NULL,           
    description TEXT,                            
    quantite_stock INT NOT NULL CHECK (quantite_stock > 0),
    prix_unitaire DECIMAL(10, 2) NOT NULL CHECK (prix_unitaire > 0), 
    categorie_produit ENUM('Électronique', 'Vêtements', 'Alimentation', 'Maison', 'Beauté', 'Sport') NOT NULL 
);


select * from produits;
