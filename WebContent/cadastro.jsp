
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
    <nav>
      <div class="nav-wrapper teal darken-3">
        <a href="index.jsp" class="brand-logo"><i class="material-icons">arrow_back</i><img class="circle" src="img/logo.png" height="60px" alt=""></a>
      </div>
    </nav>
    <div class="container">
      <h3 class="teal-text darken-1">Cadastro</h3>
      <div class="divider"></div>
      <div class="row"><label>${mensagem}</label></div>
      <div class="row">
        <form class="col s12" action="Frontal" method="post" enctype="multipart/form-data">
          <div class="row">
            <div class="input-field col s6">
              <input id="nome" type="text" name="nome" value="" required>
              <label for="nome">Nome</label>
            </div>
            <div class="input-field col s6">
              <input id="email" type="text" name="email" value="" required>
              <label for="email">E-mail</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <select name="sexo">
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
              </select>
              <label>Sexo</label>
            </div>
            <div class="input-field col s6">
              <input id="nascimento" type="text" name="nascimento" class="datepicker" required>
              <label for="nascimento">Data de nascimento</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <input id="cidade" type="text" name="cidade">
              <label for="cidade">Cidade</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="profissao" type="text" name="profissao">
              <label for="profissao">Profissão</label>
            </div>
            <div class="input-field col s6">
              <input id="senha" type="password" name="senha" required>
              <label for="senha">senha</label>
            </div>
          </div>
          <div class="row">
            <div class="file-field input-fiel col s12">
              <div class="btn">
                <span>Foto</span>
                <input name="foto" type="file">
              </div>
              <div class="file-path-wrapper">
                <input name="foto" class="file-path validate" type="text">
              </div>
            </div>
          </div>
          <div class="fixed-action-btn">
            <input type="hidden" name="ex" value="CadastroUsuario">
            <input class="btn" type="submit" value="Salvar">
          </div>
        </form>
      </div>
    </div>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/plugin.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
  </body>
</html>
