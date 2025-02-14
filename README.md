# StockMaster - Application de Gestion de Stock
# Description
StockMaster est une application simple de gestion de stock destinée aux entreprises de distribution. Elle permet aux gestionnaires de suivre et gérer leurs produits facilement grâce à une interface intuitive.
# Fonctionnalités
Ajouter un produit avec :
Nom du produit
Description
Quantité en stock (doit être un nombre positif)
Prix unitaire (doit être un nombre positif)
Catégorie (liste déroulante)
Modifier les informations d’un produit existant
Supprimer un produit du stock
Consulter une liste dynamique des produits avec leurs quantités disponibles
# Technologies utilisées
Backend : Java EE (Servlets, JSP, JDBC)
Base de données : MySQL / PostgreSQL
Frontend : HTML5, CSS3 (Bootstrap/Tailwind), JavaScript
Serveur d'application : Apache Tomcat
IDE recommandé : Eclipse ou IntelliJ IDEA
# Installation et exécution
1. Prérequis
Apache Tomcat installé et configuré
MySQL ou PostgreSQL installé
JDK 11 ou plus
IDE (Eclipse/IntelliJ IDEA)
2. Configuration de la base de données
3. Déploiement
Cloner le dépôt GitHub :
git clone https://github.com/khalidboumaghdar/Enna_Aplication_de_gestion_Stock.git
Importer le projet dans Eclipse/IntelliJ IDEA
Configurer web.xml et db.properties pour la connexion à la base de données
Démarrer Apache Tomcat
Déployer l'application et accéder à http://localhost:8080/StockMaster
# Structure du projet
StockMaster/
│── src/
│   ├── controllers/     # Servlets pour la gestion des requêtes HTTP  
│   ├── models/         # Classes représentant les objets métier  
│   ├── dao/            # Classes pour l'accès aux données (CRUD)  
│── web/
│   ├── index.jsp       # Page d'accueil  
│   ├── produits/       # Pages JSP pour la gestion des produits  
│── WEB-INF/
│   ├── web.xml         # Configuration des servlets  
│── db.properties       # Configuration de la connexion à la base de données  
│── README.md  


