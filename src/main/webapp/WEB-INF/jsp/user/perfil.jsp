<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <%@ include file="../include/menu.jsp" %>
        <section>
            <span class="perfil"></span>
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
                            <li><a href="upload">upload</a></li>
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
    </body>
</html>