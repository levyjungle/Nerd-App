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
      <a href="#!" class="brand-logo">
      <img src="img/nerdzoniaicon.ico" width="30" height="30" class="d-inline-block align-top" alt="">NerdZonia
      </a>
      <a href="escorpo.html" data-target="slide-out" class="sidenav-trigger"><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
        <li><a href="escorpo.html"><i class="material-icons left">style</i>Home</a></li>
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
      <img src="img/lalatina.jpg">
    </div>
      <a href="#user#"><img class="circle" src="img/perfil.jpg"></a>
      <a href="#name"><span class="white-text name">Kazuma-kun</span></a>
      <a href="#email"><span class="white-text email">mattsooares@gmail.com</span></a>
    </li></div>
    <li><a href="#" class="waves-effect"><i class="material-icons">person</i>Perfil</a></li>
    <li><a href="#" class="waves-effect"><i class="material-icons">notifications</i>Notificações</a></li>
    <li><a href="#" class="waves-effect"><i class="material-icons">settings</i>Configurações</a></li>
    <li><div class="divider"></div></li>
    <li><a href="sair" class="waves-effect"><i class="material-icons">close</i>Sair</a></li>
  </ul>
  
  <!--CAROUSEL-SLIDER-->
  <div class="slider">
      <ul class="slides">
        <li>
          <img src="img/cartaz-aquaman-sdcc-2018.png" class="responsive-img">
          <div class="caption left-align black-text">
            <h3>Novidade - Aquaman</h3>
            <h5 class="light black-text text-lighten-3">Disponivel na NerdZonia</h5>
            <a class="waves-effect waves-light btn red"><i class="material-icons left">send</i>Assista Agora</a>
          </div>
        </li>
        <li>
          <img src="img/war.jpg" class="responsive-img">
          <div class="caption left-align white-text">
            <h3>Novidade - Guerra Infinita</h3>
            <h5 class="light grey-text text-lighten-3">Disponivel na NerdZonia</h5>
            <a class="waves-effect waves-light btn red"><i class="material-icons left">send</i>Assista Agora</a>
          </div>
        </li>
        <li>
          <img src="img/cartaz-poster-jogador-n-1-brasil.png" class="responsive-img">
          <div class="caption left-align">
            <h3>Novidade - Jogador Numero 1º</h3>
            <h5 class="light grey-text text-lighten-3">Disponivel na NerdZonia</h5>
            <a class="waves-effect waves-light btn red"><i class="material-icons left">send</i>Assista Agora</a>
          </div>
        </li>
        <li>
          <img src="img/game.jpg" class="responsive-img">
          <div class="caption left-align white-text">
            <h3>Exclusivo - Game Of Thrones 8º Temporada</h3>
            <h5 class="light grey-text text-lighten-3">Exclusivo na NerdZonia</h5>
            <a class="waves-effect waves-light btn red"><i class="material-icons left">send</i>Assista Agora</a>
          </div>
        </li>
      </ul>
    </div>

    <!--CATALAGOS DE FILMES-->
    <section>
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
	                  <p><a href="${media.urlVideo}" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
	                </div>
	                <div class="card-reveal">
	                  <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
	                  <p>${media.synopsis}</p>
	                </div>
	              </div>
	          </div>
	     	</c:forEach>
        </div>
		
       <!--SEGUNDO PAINEL
        <div class="primary-1">
            <blockquote class="white-text">
              SÉRIES - SÉRIES ANIMADAS
            </blockquote>
            </div>
        
        <div class="row">
          <div class="grid-example col s12 m4">
              <div class="card">
                  <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="img/got.jpg" width="700" height="200">
                  </div>
                  <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Game Of Thrones - 8º Temporada<i class="material-icons right">more_vert</i></span>
                    <p><a href="#" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
                  </div>
                  <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
                    <p>Há muito tempo, em um tempo esquecido, uma força destruiu o equilíbrio das estações. Em uma terra onde os verões podem durar vários anos e o inverno toda uma vida, as reivindicações e as forças sobrenaturais correm as portas do Reino dos Sete Reinos. A irmandade da Patrulha da Noite busca proteger o reino de cada criatura que pode vir de lá da Muralha, mas já não tem os recursos necessários para garantir a segurança de todos. Depois de um verão de dez anos, um inverno rigoroso promete chegar com um futuro mais sombrio. Enquanto isso, conspirações e rivalidades correm no jogo político pela disputa do Trono de Ferro, o símbolo do poder absoluto.</p>
                  </div>
                </div>
          </div>

          <div class="grid-example col s12 m4">
              <div class="card">
                  <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="img/Mr.-Robot-Season-2-poster.jpg" width="700" height="200">
                  </div>
                  <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Mr. Robot 2º Temporada<i class="material-icons right">more_vert</i></span>
                    <p><a href="#" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
                  </div>
                  <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
                    <p>Elliot (Rami Malek) é um jovem programador que trabalha como engenheiro de segurança virtual durante o dia, e como hacker vigilante durante a noite. Elliot se vê numa encruzilhada quando o líder (Christian Slater) de um misterioso grupo de hacker o recruta para destruir a firma que ele é pago para proteger.</p>
                  </div>
                </div>
          </div>

          <div class="grid-example col s12 m4">
              <div class="card">
                  <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="img/caçadores.jpg" width="700" height="200">
                  </div>
                  <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Caçadores de Trolls 1º Temporada<i class="material-icons right">more_vert</i></span>
                    <p><a href="#" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
                  </div>
                  <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
                    <p>Jim é um garoto de 15 anos que é transformado em um caçador de trolls e defensor dos Trolls do bem, depois de encontrar sem querer um amuleto mágico. Enquanto luta ao lado do seu melhor amigo, Toby, e do Troll sabichão Blinky, ele precisa ao mesmo tempo conciliar os ensaios e deveres de casa da escola.</p>
                  </div>
                </div>
          </div>
        </div>
		-->
        <!--TERCEIRO PAINEL
        <div class="primary-1">
            <blockquote class="white-text">
              ANIMES - ANIMAÇÃO JAPONESA
            </blockquote>
            </div>

        <div class="row">
          <div class="grid-example col s12 m4">
              <div class="card">
                  <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="img/goblin.png" width="700" height="200">
                  </div>
                  <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Goblin Slayer 1º Temporada<i class="material-icons right">more_vert</i></span>
                    <p><a href="#" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
                  </div>
                  <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
                    <p>Em um mundo de fantasia, aventureiros vêm de longe para se juntar a Guilda, a fim de concluir contratos para os postos de trabalho que estão disponíveis. Uma sacerdotisa inexperiente, ingressa em sua primeira aventura, mas se veem em perigo depois que seu primeiro contrato de aventureiros que envolve goblins da errado e quase todo seu grupo é dizimado pelos goblins. Depois que o resto do seu grupo é abatido ela é salva por um homem conhecido como Goblin Slayer, um aventureiro, cujo único propósito é a erradicação dos goblins.</p>
                  </div>
                </div>
          </div>

          

          <div class="grid-example col s12 m4">
              <div class="card">
                  <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="img/fullmetal.jpg" width="700" height="200">
                  </div>
                  <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Fullmetal Alchemist Brotherhood<i class="material-icons right">more_vert</i></span>
                    <p><a href="#" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
                  </div>
                  <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
                    <p>série segue a história de dois irmãos alquimistas, Edward e Alphonse Elric, que querem recuperar seus corpos, após uma falha desastrosa na tentativa de trazer sua mãe de volta à vida através da alquimia. Diferentemente do primeiro anime, que teve sua própria história original, a segunda série segue fielmente a história do mangá.</p>
                  </div>
                </div>
          </div>

          <div class="grid-example col s12 m4">
              <div class="card">
                  <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="img/Kimi-no-Na-wa.jpg" width="700" height="200">
                  </div>
                  <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Kimi no Na wa<i class="material-icons right">more_vert</i></span>
                    <p><a href="#" class="waves-effect waves-light btn small red"><i class="material-icons left">play_arrow</i>Assista Agora</a></p>
                  </div>
                  <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Sinopse<i class="material-icons right">close</i></span>
                    <p>Mitsuha é a filha do prefeito de uma pequena cidade, mas sonha em tentar a sorte em Tóquio. Taki trabalha em um restaurante em Tóquio e deseja largar o seu emprego. Os dois não se conhecem, mas estão conectados pelas imagens de seus sonhos.</p>
                  </div>
                </div>
          </div>
        </div>    
 		-->
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