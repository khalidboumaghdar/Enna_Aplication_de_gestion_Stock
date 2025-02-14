<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Application - Gestion de Stock</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <form action="insert" method="POST">
            <div class="mb-3">
                <h1>Ajouter Produit</h1>
            </div>
            <div class="mb-3">
                <label for="nom" class="form-label">Nom :</label>
                <input type="text" class="form-control" id="nom" name="nom">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description :</label>
                <input type="text" class="form-control" id="description" name="description">
            </div>
            <div class="mb-3">
                <label for="quantite" class="form-label">Quantité :</label>
                <input type="number" class="form-control" id="quantite" name="quantite">
            </div>
            <div class="mb-3">
                <label for="prix" class="form-label">Prix :</label>
                <input type="number" class="form-control" id="prix" name="prix">
            </div>
            <div class="mb-3">
                <label for="categorie_produit" class="form-label">Catégorie :</label>
                <input type="text" class="form-control" id="categorie_produit" name="categorie_produit">
            </div>
            <button type="submit" class="btn btn-primary">Envoyer</button>
        </form>

        <table class="table mt-4">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Quantité</th>
                    <th>Prix</th>
                    <th>Catégorie</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produit" items="${listProduit}">
                    <tr>
                        <td><c:out value="${produit.id}" /></td>
                        <td><c:out value="${produit.nom}" /></td>
                        <td><c:out value="${produit.description}" /></td>
                        <td><c:out value="${produit.quantite}" /></td>
                        <td><c:out value="${produit.prix}" /></td>
                        <td><c:out value="${produit.categorie}" /></td>
                        <td>
                            <button class="btn btn-primary btn-edit" 
                                    data-bs-toggle="modal" 
                                    data-bs-target="#editModal"
                                    data-id="${produit.id}"
                                    data-nom="${produit.nom}"
                                    data-description="${produit.description}"
                                    data-quantite="${produit.quantite}"
                                    data-prix="${produit.prix}"
                                    data-categorie="${produit.categorie}">
                                Modifier
                            </button> 
                            &nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${produit.id}' />" 
                               class="btn btn-danger"
                               onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?');">
                               Supprimer
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editModalLabel">Modifier Produit</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="update" method="POST">
            <input type="hidden" id="edit-id" name="id">
            
            <div class="mb-3">
                <label for="edit-nom" class="form-label">Nom :</label>
                <input type="text" class="form-control" id="edit-nom" name="nom">
            </div>
            <div class="mb-3">
                <label for="edit-description" class="form-label">Description :</label>
                <input type="text" class="form-control" id="edit-description" name="description">
            </div>
            <div class="mb-3">
                <label for="edit-quantite" class="form-label">Quantité :</label>
                <input type="number" class="form-control" id="edit-quantite" name="quantite">
            </div>
            <div class="mb-3">
                <label for="edit-prix" class="form-label">Prix :</label>
                <input type="number" class="form-control" id="edit-prix" name="prix">
            </div>
            <div class="mb-3">
                <label for="edit-categorie" class="form-label">Catégorie :</label>
                <input type="text" class="form-control" id="edit-categorie" name="categorie_produit">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                <button type="submit" class="btn btn-primary">Enregistrer</button>
            </div>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Script Bootstrap et JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        // Sélectionne tous les boutons Modifier
        document.querySelectorAll('.btn-edit').forEach(button => {
            button.addEventListener('click', function() {
                document.getElementById('edit-id').value = this.getAttribute('data-id');
                document.getElementById('edit-nom').value = this.getAttribute('data-nom');
                document.getElementById('edit-description').value = this.getAttribute('data-description');
                document.getElementById('edit-quantite').value = this.getAttribute('data-quantite');
                document.getElementById('edit-prix').value = this.getAttribute('data-prix');
                document.getElementById('edit-categorie').value = this.getAttribute('data-categorie');
            });
        });
    });
</script>

</body>
</html>
