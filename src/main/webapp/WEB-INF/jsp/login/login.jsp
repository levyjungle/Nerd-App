<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../include/head.jsp"%>
<style>
body {
	display: flex;
	min-height: 100vh;
	flex-direction: column;
}

main {
	flex: 1 0 auto;
}

body {
	background: #eceff1;
}

.input-field input[type=date]:focus+label, .input-field input[type=text]:focus+label,
	.input-field input[type=email]:focus+label, .input-field input[type=password]:focus+label
	{
	color: #e91e63;
}

.input-field input[type=date]:focus, .input-field input[type=text]:focus,
	.input-field input[type=email]:focus, .input-field input[type=password]:focus
	{
	border-bottom: 2px solid #e91e63;
	box-shadow: none;
}
</style>
<body>
	<div class="section"></div>
	<main>
	<center>
		<img class="responsive-img" style="width: 250px;"
			src="https://res.cloudinary.com/nerdzonia/image/upload/v1543461601/nerdzoniaicon.ico" />
		<div class="section"></div>

		<h5 class="indigo-text">Entre na NerdZonia</h5>
		<div class="section"></div>

		<div class="container">
			<div class="z-depth-1 grey lighten-4 row"
				style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

				<form class="col s12" method="post" action="sendLogin">
					<div class='row'>
						<div class='col s12'></div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<i class="material-icons prefix">perm_identity</i> <input
								class='validate' type='email' name='email' id='email' /> <label
								for='email'>Insira seu email</label>
						</div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<i class="material-icons prefix">lock</i> <input class='validate'
								type='password' name='password' id='password' /> <label
								for='password'>Insira sua senha</label>
						</div>
						<label style='float: right;'> <a class='pink-text'
							href='#!'><b>Esqueceu sua senha?</b></a>
						</label>
					</div>

					<br />
					<center>
						<div class='row'>
							<button type='submit' name='btn_login'
								class='col s12 btn btn-large waves-effect indigo'>Entrar</button>
						</div>
					</center>
				</form>
			</div>
		</div>
		<a href="register">Crie uma conta</a>
	</center>

	<div class="section"></div>
	<div class="section"></div>

	<div class="footer-copyright grey darken-1">
		<div class="container">
			© 2018 Todos os direitos reservados <a
				class="grey-text text-lighten-5 right"
				href="https://materializecss.com/">Materialize</a>
		</div>
	</div>
	</main>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
</body>
</html>