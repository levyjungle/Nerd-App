<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>NerdZonia</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="${pageContext.request.contextPath}/library/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/css/action.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nerdZonia.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myAccount.css">
    </head>

    <body>
        <%@ include  file="../include/menu.jsp" %>    
        <section>
            <span class="account"></span>
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
                            <label>Escreva algo sobre você:</label>
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
                            <label>Gênero:</label>
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
        <%@ include file="../include/footer.jsp" %>
    </body>

</html>