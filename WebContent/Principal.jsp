<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  	
  	<!-- Modal Structure -->
	  <div id="modal1" class="modal">
	    <div class="row">
		    <div class="col s12">
		      <ul class="tabs tabs-fixed-width">
		        <li class="tab col s3"><a href="#test1">Evento</a></li>
		        <li class="tab col s3"><a class="active" href="#test2">Local</a></li>
		      </ul>
		    </div>
		    <div id="test1" class="col s12">
		    	<form action="Frontal" method="post">
		    		<div class="row">
		    			<div class="input-field col s12">
		    				<input type="text" name="nome" id="nome">
		    				<label for="nome">Nome</label>
		    			</div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s12">
		    				<input type="text" name="descricao" id="descricao">
		    				<label for="descricacao">Descrição</label>
		    			</div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s6">
		    				<input type="text" class="datepicker2" name="dia" id="dia">
		    				<label for="dia">Dia</label>
		    			</div>
		    			<div class="input-field col s6">
		    				 <input type="text" class="timepicker" name="hora" id="hora">
		    				<label for="hora">Hora</label>
		    			</div>
		    		</div>
		    		<div class="row">
		    			<div class="input-field col s4">
		    				<input type="text" name="rua" id="rua">
		    				<label for="rua">Rua</label>
		    			</div>
		    			<div class="input-field col s4">
		    				<input type="text" name="cidade" id="cidade">
		    				<label for="cidade">Cidade</label>
		    			</div>
		    			<div class="input-field col s4">
		    				<input type="text" name="estado" id="estado">
		    				<label for="estado">Estado</label>
		    			</div>
		    		</div>
		    		<div class="modal-footer">
		    			<input type="hidden" name="ex" value="CriaEvento">
		    			<input type="submit" class="modal-action modal-close waves-effect waves-green btn-flat" value="Salvar">
				      
				    </div>
		    	</form>
		    </div>
		    <div id="test2" class="col s12">Test 2</div>
		  </div>
	    
	  </div>
  	
  	
  	<div class="fixed-action-btn">
	    <a class="btn-floating btn-large red modal-trigger" href="#modal1">
	      <i class="large material-icons">add</i>
	    </a>
	  </div>
	  
	${mensagem}
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="materialize/js/plugin.js"></script>
  </body>
</html>