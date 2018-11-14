<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>NerdZonia</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${contextPage.request.contextPage}/library/jquery-3.3.1.min.js"></script>
    <script src="${contextPage.reqeust.contextPage}/css/action.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nerdZonia.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myAccount.css">
</head>

<body>
    <header>
        <span class="userAccount"></span>
        <nav>
            <div class="menu">
                <div class="title">
                    <span>NerdZonia</span>
                </div>
                <ul>
                    <li><a href="#" class="myHome">Home</a></li>
                    <li><a href="#" class="myAccount">Minha Conta</a></li>
                    <li><a href="#" class="myPerfil">Nome do Usuario</a></li>
                    <li><a href="index.html">Log Out</a></li>
                </ul>
            </div>
        </nav>
    </header>
    <section>
        <div class="box">
            <div class="boxAccoutSettings">
                <form action="">
                    <div class="spaceBar">
                        <label>Nome:</label>
                        <div class="inputStyle">
                            <input type="text" name="name" placeholder="Digite seu nome" maxlength="150" required>
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Apelido:</label>
                        <div class="inputStyle">
                            <input type="text" name="nickname" maxlength="20" placeholder="Digite seu apelido">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Escreva algo sobre vocÃª:</label>
                        <div class="inputStyle">
                            <input type="text" name="aboutMe" maxlength="150" placeholder="Conte para os outros algo sobre vocÃª">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Aniversario:</label>
                        <div class="inputStyle">
                            <input type="date" name="birthday">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>GÃªnero:</label>
                        <div class="inputStyle">
                            <input type="text" name="sex" maxlength="10" placeholder="Defina seu gÃªnero">
                        </div>
                    </div>
                    <div class="submitButton">
                        <input type="submit">
                    </div>
                </form>
            </div>
        </div>
    </section>
    <footer>
        <div class="footer">
            <span>Bem Vindo ao NerdZonia</span>
        </div>
    </footer>
</body>

</html>