<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/library/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/css/action.js"></script>
	<title>NerdZonia</title>
</head>
<body>
	<section>
		<div class="sectionBox">
			<div class="boxRegister">
				<div class="registerField">
					<a href="cadastro"><img class="newUserImg" src="${pageContext.request.contextPath}/css/img/NewUser.png" onclick=""></a>
				</div>
			</div>
			<div class="box">
				<form class="form" method="post" action="logar">
					<div class="title">
						<h2>Logar-se ao NerdZonia</h2>
					</div>
					
					<div class="field">
						<label>Login</label><br>
						<input type="text" name="email" placeholder="Digite seu login" maxlength="50" required>
					</div>
					
					<div class="field">
						<label>Senha</label><br>
						<input type="password" name="password" placeholder="Digite sua senha" required>
					</div>
	
					<div class="button">
						<button>Logar</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>