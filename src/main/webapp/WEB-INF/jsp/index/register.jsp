<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <script type="text/javascript" src="${pageContext.request.contextPath}/library/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/css/action.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
        <title>NerdZonia</title>
    </head>
    <body>
        <section>
            <div class="sectionBox">
                <div class="boxRegister">
                    <div class="registerField">
                        <a href="${pageContext.request.contextPath}"><img class="newUserImg loginBack" src="${pageContext.request.contextPath}/css/img/backLogin.png"></a>
                    </div>
                </div>
                <div class="box">
                    <form class="form" method="post" action="sendRegister">
                        <div class="title">
                            <h2>Cadastra na NerdZonia</h2>
                        </div>

                        <div class="field">
                            <label>Nome</label><br>
                            <input type="text" name="name" placeholder="Digite seu nome" maxlength="50" required>
                        </div>

                        <div class="field">
                            <label>Apelido</label><br>
                            <input type="text" name="nickname" placeholder="Digite seu apelido" maxlength="50" required>
                        </div>

                        <div class="field">
                            <label>Email</label><br>
                            <input type="email" name="email" placeholder="Digite email valido" maxlength="50" required>
                        </div>

                        <div class="field">
                            <label>Senha</label><br>
                            <input type="password" name="password" placeholder="Digite sua senha" required>
                        </div>

                        <div class="field">
                            <label>Confirmar</label><br>
                            <input type="password" name="passwordConfirm" placeholder="Confirme a senha" required>
                        </div>

                        <div class="button">
                            <button>Registrar</button>
                        </div>
                    </form>
                </div>
            </div>

        </section>
    </body>
</html>