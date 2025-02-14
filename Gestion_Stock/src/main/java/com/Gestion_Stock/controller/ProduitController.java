package com.Gestion_Stock.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Gestion_Stock.DAO.ProduitDAO;
import com.Gestion_Stock.model.ProduitModel;
@WebServlet("/")
public class ProduitController extends HttpServlet {
	 private  ProduitDAO prDAO;
	    public void init() {
	        prDAO = new ProduitDAO();
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
        	
	        try {
	            switch (action) {

	                case "/insert":
	                	insertproduit(request, response);
	                    break;
	                case "/delete":
	                	deleteproduit(request, response);
	                    break;
	                case "/update":
	                	updateProduit(request, response);
	                    break;
	               default :  
	                	listProduit(request, response);

	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	    private void deleteproduit(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        prDAO.deleteProduit(id);
	    	        response.sendRedirect("./");

	    	    }
	    private void insertproduit(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        String nom = request.getParameter("nom");
	        String description = request.getParameter("description");
	        int quantite = Integer.parseInt(request.getParameter("quantite"));
	        int prix = Integer.parseInt(request.getParameter("prix"));
	        String categorie = request.getParameter("categorie_produit");
	        ProduitModel pr = new ProduitModel(nom,description,quantite,prix,categorie);
	        ProduitDAO insert = new ProduitDAO();
	        insert.insertProduit(pr);
	        response.sendRedirect("./");
	        System.out.println(pr);
	    }
	    private void listProduit(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    	        List < ProduitModel > listProduit =prDAO.selectAllProduits();
	    	        request.setAttribute("listProduit", listProduit);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("gestion.jsp");

	    	        dispatcher.forward(request, response);
	    	        
	    	    }
	    private void updateProduit(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        String nom = request.getParameter("nom");
	    	        String description = request.getParameter("description");
	    	        int quantite = Integer.parseInt(request.getParameter("quantite"));
	    	        Double prix = Double.parseDouble(request.getParameter("prix"));
	    	        String categorie = request.getParameter("categorie_produit");

	    	        ProduitModel pr = new ProduitModel(id,nom,description,quantite,prix,categorie);
	    	        prDAO.updateProduit(pr);
	    	        System.out.println(pr);
	    	        response.sendRedirect("./");
	    	    }

}
