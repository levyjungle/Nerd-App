<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<%@include file="../include/head.jsp" %>
	<body>
		 <script>
      $(document).ready(function(){
          $('.sidenav').sidenav({
            draggable: true
          });
          $('.slider').slider();
        });

        $(document).ready(function(){
          $('.carousel').carousel({
            duration: 400,
            indicators: true  
          });
        });
    </script>

    <style>
       body{
         background-color: currentColor;
           }
       .primary{
        color: orange;
	      border-bottom: 2px solid red;
	      font-family: "Open Sans", sans-serif;
	      font-size: .9rem;
	      font-weight: 200;
	      letter-spacing: 0.2rem;
	      padding: .5rem 0;
	      text-align: left;
	      text-transform: uppercase;
       }
       .primary-1{
        color: orange;
        border-top: 3px solid red;
	      border-bottom: 2px solid red;
	      font-family: "Open Sans", sans-serif;
	      font-size: .9rem;
	      font-weight: 200;
	      letter-spacing: 0.2rem;
	      padding: .5rem 0;
	      text-align: left;
	      text-transform: uppercase;

       }
    </style>

<body>
  <nav class="red darken-4">
    <div class="nav-wrapper">
      <a href="/" class="brand-logo">
      <img src="https://res.cloudinary.com/nerdzonia/image/upload/v1543461601/nerdzoniaicon.ico" width="30" height="30" class="d-inline-block align-top" alt="">NerdZonia
      </a>
      <a href="escorpo.html" data-target="slide-out" class="sidenav-trigger"><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
        <li><a href="/"><i class="material-icons left">style</i>Home</a></li>
        <li><a href="conta"><i class="material-icons left">person</i>Perfil</a></li>
        <li><a href="#"><i class="material-icons left">notifications</i>Notifações</a></li>
        <li><a href="#"><i class="material-icons left">settings</i>Configurações</a></li>
        <li><a href="sair"><i class="material-icons left">close</i>Sair</a></li>
      </ul>
    </div>
  </nav>

  <ul class="sidenav" id="slide-out">
    <li><div class="user-view">
    <div class="background">
      <img src="${userSession.person.profile.urlBackground}">
    </div>
      <a href="conta"><img class="circle" src="${userSession.person.profile.urlProfile}"></a>
      <a href="conta"><span class="white-text name">${userSession.person.name}</span></a>
      <a href="conta"><span class="white-text email">${userSession.person.profile.email}</span></a>
    </li></div>
    <li><a href="conta" class="waves-effect"><i class="material-icons">person</i>Perfil</a></li>
    <li><a href="#" class="waves-effect"><i class="material-icons">notifications</i>Notificações</a></li>
    <li><a href="#" class="waves-effect"><i class="material-icons">settings</i>Configurações</a></li>
    <li><div class="divider"></div></li>
    <li><a href="sair" class="waves-effect"><i class="material-icons">close</i>Sair</a></li>
  </ul>
  
  <!--CAROUSEL-SLIDER-->
  <div class="slider">
      <ul class="slides">
      	<c:forEach items="${banner}" var="banner" end="3">
      		<li>
	          <img src="${banner.urlPhoto}" class="responsive-img">
	          <div class="caption left-align black-text">
	            <h3>${banner.name}</h3>
	            <h5 class="light black-text text-lighten-3">Disponivel na NerdZonia</h5>
	            <a class="waves-effect waves-light btn red" href="${pageContext.request.contextPath}/video/assistir/${banner.code}"><i class="material-icons left">send</i>Assista Agora</a>
	          </div>
        	</li>
      	</c:forEach>
      </ul>
    </div>

    <!--CATALAGOS DE FILMES-->
    <section> 
    	
        <form action="${pageContext.request.contextPath}/searchMediaByName" method="get" style="margin-top:70px;">
        	<input type="text" name="movieName" placeholder="Digite aqui o nome do filme que deseja encontrar" style="color:white; text-align:center;">
        </form>
        
        <c:if test="${movie != null}">
			<div class="primary-1">
				<blockquote class="white-text">
				Encontramos os seguintes filmes!
				</blockquote>
        	</div>
        </c:if>
   		
     <!--Resultado da Procura -->  
        <div class="row">
	        <c:forEach items="${movie}" var="movie">
	     		<div class="grid-example col s12 m4">
	            <div class="card">
	                <div class="card-image waves-effect waves-block waves-light">
	                  <img class="activator" src="${movie.urlPhoto}" width="700" height="199">
	                </div>
	                <div class="card-content">
	                  <span class="card-title activator grey-text text-darken-4">${movie.name}<i class="material-icons right">more_vert</i></span>
	                  <p><a href="${pageContext.request.contextPath}/video/assistir/${movie.code}" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
	                </div>
	                <div class="card-reveal">
	                  <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
	                  <p>${movie.synopsis}</p>
	                </div>
	              </div>
	          </div>
	     	</c:forEach>
        </div>	
    
      <div class="primary">
        <blockquote class="white-text">
          Filmes Disponiveis
        </blockquote>
        </div>

     <!--FILMES-->   
        <div class="row">
	        <c:forEach items="${media}" var="media">
	     		<div class="grid-example col s12 m4">
	            <div class="card">
	                <div class="card-image waves-effect waves-block waves-light">
	                  <img class="activator" src="${media.urlPhoto}" width="700" height="199">
	                </div>
	                <div class="card-content">
	                  <span class="card-title activator grey-text text-darken-4">${media.name}<i class="material-icons right">more_vert</i></span>
	                  <p><a href="${pageContext.request.contextPath}/video/assistir/${media.code}" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
	                </div>
	                <div class="card-reveal">
	                  <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
	                  <p>${media.synopsis}</p>
	                </div>
	              </div>
	          </div>
	     	</c:forEach>
        </div>	 
      </section>
	  
      <footer class="page-footer grey darken-4">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">NerdZonia</h5>
                <p class="grey-text text-lighten-4">Contato NerdZonia - (00) 0000-0000</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Dúvidas?</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Central</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Planos</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Termos de uso</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright grey darken-3">
            <div class="container">
            © 2018 Todos os direitos reservados
            <a class="grey-text text-lighten-4 right" href="https://materializecss.com/">Materialize</a>
            </div>
          </div>
        </footer>
	</body>

</html>