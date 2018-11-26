<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<header>
    <nav>
        <div class="menu">
            <div class="title">
                <span>NerdZonia</span>
            </div>
            <ul>
                <li><a href="home" class="myHome">Home</a></li>
                <li><a href="conta" class="myAccount">Minha Conta</a></li>
                <li><a href="perfil" class="myPerfil">${userSession.person.name}</a></li>
                <li><a href="sair">Log Out</a></li>
            </ul>
        </div>
    </nav>
</header>