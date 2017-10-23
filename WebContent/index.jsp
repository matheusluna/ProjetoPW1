<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  	<div class="container">
      <div class="contanier">
        <div class="container">
          <div class="container">
            <div class="container">
              <br><br><br>
              <div class="row center-align">
                <img class="circle" src="img/logo.png" height="200px" alt="">
              </div>
              <div class="row">
                <form class="" action="Frontal" method="post">
                  <div class="row">
                    <div class="input-field col s12">
                      <input id="email" type="text" name="email" value="" required>
                      <label for="email">E-mail</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s12">
                      <input id="senha" type="password" name="senha" value="" required>
                      <label for="senha">Senha</label>
                    </div>
                  </div>
                  <div class="row">${mensagem}</div>
                  <div class="row">
                    <div class="col s12">
                      <label>Não possui conta? <a href="cadastro.jsp">Clique aqui</a></label>
                    </div>
                  </div>
                  <div class="row center-align">
                  	<input type="hidden" name="ex" value="Login">
                    <input class="btn" type="submit" name="" value="Login">
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
  </body>
</html>