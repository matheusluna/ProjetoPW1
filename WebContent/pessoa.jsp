<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<p>${pessoa.nome}</p>
		<p>${pessoa.email}</p>
		<p>${pessoa.cidade}</p>
		<p><img class="circle" whidth="100px" height="100px" src="${pessoa.foto}"/></p>
		<c:choose>
			<c:when test="${amigo}">
				<a href="/Teste/Frontal?ex=DesfazerAmizade&pessoa2=${pessoa.email}">Desfazer amizade</a>
			</c:when>
			<c:when test="${solicitacao}">
				<a href="/Teste/Frontal?ex=DesfazerSolicitacao&receptor=${pessoa.email}">Desfazer solicitação</a>
			</c:when>
			<c:when test="${retorno}">
				<a href="/Teste/Frontal?ex=CriaAmizade&pessoa2=${pessoa.email}">Aceitar amizade</a>
				<a href="/Teste/Frontal?ex=RejeitarAmizade&emissor=${pessoa.email}">Rejeitar amizade</a>
			</c:when>
			<c:otherwise>
				<a href="/Teste/Frontal?ex=CriaSolicitacao&receptor=${pessoa.email}">Solicitar amizade</a>
			</c:otherwise>
		</c:choose>
	</div>
	</script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="materialize/js/plugin.js"></script>
</body>
</html>