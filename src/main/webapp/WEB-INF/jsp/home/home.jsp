<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../include/head.jsp"%>
<body>
	<script>
		$(document).ready(function() {
			$('.sidenav').sidenav();
		});
	</script>
	<nav>
		<div class="nav-wrapper">
			<a href="Home.html" class="brand-logo center">NerdZonia</a>
			<ul class="right">
				<li><a href="login" class="waves-effect waves-teal btn">ENTRAR</a></li>
			</ul>
		</div>
	</nav>
	<section></section>
	<style>
		nav {
			position: fixed;
			background: rgba(0, 0, 0, 0.2);
			padding: 0px 20px;
		}
		
		section {
			background-image:
				url(https://res.cloudinary.com/nerdzonia/image/upload/v1543774152/logoApp.jpg);
			background-size: cover;
			width: -100px;
			height: 800px;
		}
		
		.box {
			margin-top: 20px;
			height: 1000px;
		}
		
		.btn {
			background-color: #311b92;
		}
	</style>
	
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