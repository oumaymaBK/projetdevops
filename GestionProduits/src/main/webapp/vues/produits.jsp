<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.html"%>
<br><br>

<div class=container>
  <div class="row">


<form method=get action=produitmc>
<div class=container>
<div class="row mt-4 pl-2">
<div class="col-md-3">
<label for="mc" class="form-label">Mot Cle:</label>
</div>
<div class="col-md-6">
<input type="text" id="mc" class="form-control" name=mc>
</div>
<div class="col-md-3">
<button type="submit" class="btn btn-primary">Chercher</button>
</div> </div> </div> </form>



<form action="/apiproduit/produitParCategorie" method=get>
	<div class=container>
		<div class="row mt-4 pl-2">
			<div class="col-md-3">
				<label for="mc" class="form-label">Categories:</label>
			</div>
		<div class="col-md-8">
			<select class="form-control" name="categorie" onchange="submit()">
				<option selected hidden>${categorie}</option>
				<option value="0"> Toutes les categories </option>
				<c:forEach items="${categories}" var="cc">
					<option value="${cc.id}">${cc.nom}</option>
				</c:forEach>
			</select>
		</div>

		</div> 
	</div> 
</form>
</div>
</div>

<br><br><br><br>

<table class="table table-hover">
<tr>
<th>Photo</th> <th>Id</th><th>Nom</th><th>Prix</th><th>Quantite</th><th>Categorie</th><th>Action</th>
</tr>
<c:forEach items="${liste}" var="p">
<tr>
<td><c:choose>
	<c:when test="${p.photo==''}">
		<img src="/imagesdata/inconnu.jpg" width=50 height="50">
	</c:when>
	<c:when test="${p.photo!='' }">
		<img src="/imagesdata/${p.photo}" width=50 height="50">
	</c:when>
</c:choose>
</td>
<td>${p.id}</td>
<td>${p.nom}</td>
<td>${p.prix } TND</td>
<td>${p.quantite}</td>
<td>${p.categorie.nom}</td>
<td><a href="/apiproduit/supprimerproduit/${p.id}"
 class="btn btn-danger"><span class="fa fa-trash"></span></a>
 <a href="/apiproduit/modifierproduit/${p.id}" class="btn btn-warning">
 <span class="fa fa-edit"></span></a></td>
</tr>
</c:forEach>
</table>
</body>
</html>