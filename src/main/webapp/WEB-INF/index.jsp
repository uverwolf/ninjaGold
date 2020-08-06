<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilo.css">
<!-- JS, Popper.js, and jQuery -->

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Ninja Gold</title>
</head>
<body> 
	<div class="container-fluid">
        <div class="d-flex flex-row col-12">
            <p>Tu oro: <input type="text" value="<c:out value="${oro}"/>"></p>
        </div>
        <div class="d-flex flex-row">
            <form class="col-3" action="/granja" method="post">
               <h1 class="display-4">Granja</h1>
               <p>(gana entre 10-20 de oro)</p>
               <button class="btn btn-warning" type="submit">Encontrar Oro</button>      
            </form>
            <form class="col-3" action="/cueva" method="post">
                <h1 class="display-4">Cueva</h1>
                <p>(gana entre 5-10 de oro)</p>
                <button class="btn btn-warning" type="submit">Encontrar Oro</button>   
            </form>
            <form class="col-3" action="/casa" method="post">
                <h1 class="display-4">Casa</h1>
                <p>(gana entre 2-5 de oro)</p>
                <button class="btn btn-warning" type="submit">Encontrar Oro</button>   
            </form>
            <form class="col-3" action="/casino" method="post">
                <h1 class="display-4">Casino</h1>
                <p>(gana/pierde entre 0-50 de oro)</p>
                <button class="btn btn-warning" type="submit">Encontrar Oro</button>   
            </form>
        </div>
        <div class="d-flex flex-column">
            <p class="h1">Actividades</p> 
            <div class="overflow-auto actividades">   
              
            <c:forEach items="${actividades}" var="log">
				<p>${log}<% %></p> 

           	
            </c:forEach>
            
            </div>
 
           
        </div>

      
    </div>
</body>
</html>