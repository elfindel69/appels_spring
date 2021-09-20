<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Appels</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<h1 class="text-center">LISTE DES APPELS</h1>

<form  action="appels" method="get" class="text-center mt-4 mx-auto">
    <label for = "nomAppelant">Nom de l'appelant</label>
    <input type="text" id="nomAppelant" name="nomAppelant" placeholder="nom de famille">
    <br>
    <label for="employeId">Employé Concerné</label>
    <select name="employeId" id="employeId">
        <option value="">Sélectionner un employé</option>
        <c:forEach items="${employes}" var="employe">
            <option value="${employe.id}">${employe.email}</option>
        </c:forEach>
    </select>
    <br>
    <button class="btn btn-primary" type="submit">Filter!</button>
</form>
<a href="tableauAppels" class="btn btn-primary text-center">Tous les appels</a>

<table class="table-striped text-center mt-5 mx-auto">
    <thead>
    <tr>
        <th>
            Date
            <a href="tableauAppels?sort=dateDebut">&#x2B07;</a>
        </th>
        <th>
            Appelant
            <a href="tableauAppels?sort=nomAppelant">&#x2B07;</a>
        </th>
        <th>
            Type Appelant
            <a href="tableauAppels?sort=typeAppelant.nom">&#x2B07;</a>
        </th>
        <th>Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${appels.content}" var="appel">
        <tr>
            <td>
                <fmt:formatDate type = "both" pattern="dd/MM/yyyy HH:mm:ss z" value = "${appel.dateDebut}" />
            </td>
            <td>
                    ${appel.prenomAppelant} ${appel.nomAppelant.toUpperCase()}
            </td>
            <td>
                    ${appel.typeAppelant.nom}
            </td>
            <td>
                <a class="btn btn-primary" href="appel?id=${appel.id}">Modifier</a>
                <a class="btn btn-danger" href="supprimerAppel?id=${appel.id}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="text-center">
    <c:if test="${!appels.first}">
        <a href="?page=0&sort=${appels.sort.iterator().next().property},${pageAppel.sort.iterator().next().direction}">
            &#x23EE;
        </a>
        <a href="?page=${appels.number-1}&sort=${appels.sort.iterator().next().property},${appels.sort.iterator().next().direction}">
            &#x23EA;
        </a>
    </c:if>
    <span class="dark"> ${appels.totalElements/appels.totalPages}de ${(appels.totalElements/appels.totalPages)*(appel.number+1)}  sur ${appels.totalElements}</span>

    <c:if test="${!appels.last}">
        <a href="?page=${appels.number+1}&sort=${appels.sort.iterator().next().property},${appels.sort.iterator().next().direction}">
            &#x23E9;
        </a>
        <a href="?page=${appels.totalPages-1}&sort=${appels.sort.iterator().next().property},${appels.sort.iterator().next().direction}">
            &#x23ED;
        </a>

    </c:if>
    <br>
    <a class="btn btn-primary" href="appel">Ajouter un appel</a><br>
    <a class="btn btn-danger" href="deconnexion">Déconnexion</a><br/>
</div>



<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</body>
</html>