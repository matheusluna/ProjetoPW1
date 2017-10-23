<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body>
  	<jsp:include page="header.jsp"></jsp:include>
    <div class="row container">
      <ul id="tabs-swipe-demo" class="tabs tabs-fixed-width">
        <li class="tab col s3"><a class="active" href="#test-swipe-1">Pessoas</a></li>
        <li class="tab col s3"><a href="#test-swipe-2">Locais</a></li>
        <li class="tab col s3"><a href="#test-swipe-3">Eventos</a></li>
      </ul>
      <div id="test-swipe-1" class="col s12">
          <div class="container">
            <ul class="collection">
              <c:forEach var="pessoa" items="${pessoas}">
              	
              	<li class="collection-item avatar">
	              	<c:choose>
					  <c:when test="${pessoa.foto eq ''}">
					 	<a href="/Teste/Frontal?ex=Pessoa&email=${pessoa.email}"><img class="circle" src="img/iconPadrao.jpg"></a>
					  </c:when>
					  <c:otherwise>
					 	<a href="/Teste/Frontal?ex=Pessoa&email=${pessoa.email}"><img class="circle" src= "${pessoa.foto}"></a>
					  </c:otherwise>
					</c:choose>
                	<span class="title"><a href="/Teste/Frontal?ex=Pessoa&email=${pessoa.email}">${pessoa.nome}</a></span>
                	<p>${pessoa.cidade}</p>
              	</li>
              </c:forEach>
              
              
            </ul>

          </div>

      </div>
      <div id="test-swipe-2" class="col s12">Test 2</div>
      <div id="test-swipe-3" class="col s12">
      	<div class="container">
            <ul class="collection">
              <c:forEach var="evento" items="${eventos}">
              	
              	<li class="collection-item avatar">
	              	
                	<span class="title"><a>${evento.nome}</a></span>
                	<p>${evento.descricao}</p>
              	</li>
              </c:forEach>
              
              
            </ul>

          </div>
      </div>
    </div>


    <!--Import jQuery before materialize.js-->
    </script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="materialize/js/plugin.js"></script>
  </body>
</html>