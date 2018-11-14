<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>NerdZonia</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${pageContext.request.contextPath}/library/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/css/action.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nerdZonia.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfil.css">
</head>
<body>
    <header>
        <span class="perfil"></span>
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
        <div class="items items-fixed item-01">
            <div class="items-content item-content-01">
                <div class="item-content-references">
                    <h3>You like it!</h3>
                    <ul>
                        <li><a href="#">Icaro Online</a></li>
                        <li><a href="#">Poro Autista</a></li>
                        <li><a href="#">Matheus Gameplay</a></li>
                        <li><a href="#">Lucas Play</a></li>
                        <li><a href="#">Joyce Streamer</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="items items-fixed item-02">
            <div class="items-content item-content-02">
                <span>Anything</span>
            </div>
        </div>
        <div class="items item-03">
            <div class="items-content item-content-03">
                <div class="item-post">
                    <span>cwac</span>
                </div>
            </div>
        </div>
    </section>
    <footer>

    </footer>
</body>
</html>