<%--@elvariable id="personne" type="fr.humanbooster.fx.katchaka.business.Personne"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Appels</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<h1 class="text-center">Ajout d'un appel</h1>


<form:form method="POST" action="appel"
           modelAttribute="appel" class="mt-1 mx-auto">
    <form:label path="employesConcernes">Employés Concernés</form:label>
    <form:select path="employesConcernes" multiple="true">
        <form:options items="${employes}" itemLabel="email" itemValue="id"/>
    </form:select>
    <br>
    <form:errors path="employesConcernes"/>
    <br>
    <form:label path="typeAppelant">Type d'appelant</form:label>
    <form:select path="typeAppelant">
        <form:options items="${types}" itemLabel="nom" itemValue="id"/>
    </form:select>
    <br>
    <form:errors path="typeAppelant"/>
    <br>
    <form:label path="nomAppelant">Nom de l'appelant</form:label>
    <form:input path="nomAppelant" />
    <br>
    <form:errors path="nomAppelant"/>
    <br>
    <form:label path="prenomAppelant">Prénom de l'appelant</form:label>
    <form:input path="prenomAppelant"/>
    <br>
    <form:errors path="prenomAppelant"/><br>
    <br>
    <form:label path="numeroDeTelephoneAppelant">Numéro de téléphone de l'appelant</form:label>
    <form:input path="numeroDeTelephoneAppelant"/>
    <br>
    <form:errors path="numeroDeTelephoneAppelant"/>
    <br>
    <form:label path="objet">Objet de l'appel</form:label>
    <form:textarea path="objet"/>
    <br>
    <form:errors path="objet"/>
    <br>
    <form:label path="supportPublicitaire">Support Pub</form:label>
    <form:select path="supportPublicitaire">
        <form:options items="${supports}" itemLabel="nom" itemValue="id"/>
    </form:select>
    <br>
    <form:errors path="supportPublicitaire"/>
    <br>
    <form:label path="operateur">Saisi par ${sessionScope.employe.email}</form:label>
    <form:hidden path="operateur" value="${sessionScope.employe.id}"/>
    <br>
    <form:errors path="operateur"/>
    <br>

    <form:label path="statut">Statut</form:label>
        <form:radiobuttons path="statut" itemLabel="nom" itemValue="id" items="${statuts}"/>
    <br>

    <form:hidden path="id"/>
    <form:button type="submit" class="btn btn-primary"> Enregistrer!</form:button>
</form:form>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</body>
</html>