<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul id="slide-out" class="side-nav">
	    <li><div class="user-view">
	      <div class="background">
	        <img src="img/paisagem.jpg">
	      </div>
		  <c:choose>
		  	<c:when test="${foto eq ''}">
		  		<a href="/Teste/Perfil"><img class="circle" src="img/iconPadrao.jpg"></a>
		  	</c:when>
		  	<c:otherwise>
		  		<a href="/Teste/Perfil"><img class="circle" src= "${foto}"></a>
		  	</c:otherwise>
		  </c:choose>	      
	      <a href="/Teste/Perfil"><span class="white-text name">${nome}</span></a>
	      <a href="/Teste/Perfil"><span class="white-text email">${usuario}</span></a>
	    </div></li>
	    <li><a href="/Teste/Principal.jsp">Principal</a></li>
	    <li><a href="/Teste/Frontal?ex=Perfil">Perfil</a></li>
	    <li><a href="/Teste/Notificacao">Notificações</a></li>
	    <li><a href="/Teste/Frontal?ex=Solicitacao">Solicitações de amizade</a></li>
	    <li><a href="#" data-activates="slide-out2" class="button-collapse2 show-on-large">Pesquisa</a></li>
	    <li><a class="waves-effect" href="/Teste/Frontal?ex=Amigos">Amigos</a></li>
	    <li><a class="waves-effect" href="/Teste/Amigo">Conversas</a></li>
	    <li><a href="/Teste/Frontal?ex=Logout"><i class="material-icons">power_settings_new</i>Logout</a></li>
	  </ul>
	
	
	  <ul id="slide-out2" class="side-nav">
	    <form active="Frontal" method="post">
	    	<div class="row">
	    		<div class="input-field col s12">
	    			<input type="text" name="pesquisa">
	    		</div>
	    	</div>
	    	<div class="row">
	    		<div class="input-field col s12">
	    			<input type="hidden" name="ex" value="PesquisaUsuario">
	    			<input class="btn" type="submit" value="Pesquisar">
	    		</div>
	    	</div>
	    </form>
	  </ul>
	
	
  	<div class="navbar-fixed">
	    <nav>
	      <div class="nav-wrapper  teal darken-4">
	      	<a href="#" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons">menu</i></a>
	        <a href="#!" class="brand-logo"><img class="circle" alt="" src="img/logo.png" height="60px"></a>
	      </div>
	    </nav>
	  </div>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="materialize/js/plugin.js"></script>
</body>
</html>