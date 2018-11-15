<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>NerdZonia</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="${pageContext.request.contextPath}/library/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/css/action.js"></script>
    <script src="${pageContext.request.contextPath}/css/events.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nerdZonia.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boxStyle.css">
</head>

<body>
	
	<%@ include file="../include/menu.jsp" %>
    <section>
    	<span class="home"></span>
        <div class="box">
            <div class="box-items news">
                <div class="contentBox newsBox">
                    <h2>Noticias</h2>
                </div>
                <div class="contentBox newsBoxBottom">

                </div>
            </div>
            <div class="box-items globalChatroom">
                <div class="contentBox welcomeBox">
                    <h2>Bem-vindo</h2>
                </div>
                <div class="contentBox chatBoxBottom">
                    <div class="contentChatBox">
                        <div class="messageBox" id="messageBox">
                        </div>
                    </div>
                    <div class="sendBox">
                        <div class="sendBox-textarea">
                            <input type="text" id="chat" placeholder="Digite sua mensagem..." >
                        </div>
                        <div class="sendBox-button">
                            <button id="buttonChat">Enviar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@ include file="../include/footer.jsp" %>
</body>

</html>