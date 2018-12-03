<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%@include file="../include/head.jsp" %>

<body>
    <%@ include  file="../include/menu.jsp" %>    
    <section>
    	<span class="account"></span>
        <div class="box">
            <div class="boxAccoutSettings">
                <form action="atualizeProfile" method="post">
                    <div class="spaceBar">
                    	<input type="hidden" value="${userSession.person.code}">
                        <label>Nome:</label>
                        <div class="inputStyle">
                            <input type="text" name="name" placeholder="Digite seu nome" maxlength="150" value="${userSession.person.name}" required>
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Apelido:</label>
                        <div class="inputStyle">
                            <input type="text" name="nickname" maxlength="20" value="${userSession.person.profile.nickname}" placeholder="Digite seu apelido">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Aniversario:</label>
                        <div class="inputStyle">
                            <input type="date" name="birthday" maxlength="30" value="${userSession.person.profile.birthday}">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Gênero:</label>
                        <div class="inputStyle">
                            <input type="text" name="sex" maxlength="30" value="${userSession.person.profile.sex}" placeholder="Defina seu Gênero:">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Cidade:</label>
                        <div class="inputStyle">
                            <input type="text" name="city" maxlength="30" value="${userSession.person.address.city}" placeholder="Nome da cidade:">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Bairro:</label>
                        <div class="inputStyle">
                            <input type="text" name="neighborhood" maxlength="30" value="${userSession.person.address.neighborhood}" placeholder="Nome do bairro:">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Rua:</label>
                        <div class="inputStyle">
                            <input type="text" name="street" maxlength="100" value="${userSession.person.address.street}" placeholder="Nome da rua:">
                        </div>
                    </div>
                    <div class="spaceBar">
                        <label>Numero:</label>
                        <div class="inputStyle">
                            <input type="number" name="number" maxlength="10" value="${userSession.person.address.number}" placeholder="Numero da casa:">
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