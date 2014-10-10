<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/index.css" />">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<dir class="container-fluid">

		<div class="row">
			<h2 align="center">
				<a href="">Envio de Trabalhos</a>
			</h2>
		</div>

		<div class="row">
			<div class="col-md-7 col-md-offset-2">
				<p>
				<h3>Esta é a sua primeira vez aqui?</h3>
				Olá! Para o acesso completo aos cursos, você precisará criar uma
				nova conta neste web site. Cada um dos cursos individuais pode
				também ter uma "chave de inscrição de uso único" que você não
				precisará até mais tarde. Aqui estão os passos:

				<ol id="">
					<li>Preencha o <a href="">Formulário de Cadastramento</a> com
						os seus detalhes.
					</li>
					<li>Uma mensagem de confirmação da inscrição será enviada
						imediatamente ao seu endereço de email.</li>
					<li>Acesse o seu curso clicando o nome correspondente na lista
						de cursos disponíveis.</li>
					<li>Quando você retornar ao site, para entrar no curso basta
						usar o seu Email e a sua senha nesta página de acesso.</li>
				</ol>

				Acesse o seu curso clicando o nome correspondente na lista de cursos
				disponíveis. Esta senha é reservada aos usuários do site inscritos
				no curso e será necessária apenas na primeira vez que você entrar no
				curso. Quando você retornar ao site, para entrar no curso basta usar
				o seu nome de usuário e a sua senha nesta página de acesso.
				<div align="center">
					<br>
					<button type="button" action="" class="btn btn-lg btn-primary">
						<span class="glyphicon glyphicon-user"></span> Cadastramento de
						Usuario
					</button>
				</div>
				</p>
			</div>

			<div class="col-md-3">
				<div class="wrapper">
					<form class="form-signin" method="POST"
						action="<c:url value='/SpringMVC/j_spring_security_check'/>"
						name="formLogin">
						<h2 class="form-signin-heading" align="center">Acesso</h2>
						<input type="text" class="form-control" name="j_username"
							id="j_username" placeholder="Nome do Usuario" required=""
							autofocus="" /> <input type="password" class="form-control"
							name="j_password" id="j_password" placeholder="Senha" required="" />
						<input type="checkbox" value="remember-me" id="rememberMe"
							name="rememberMe" class="chk"><label for="rememberMe">Remember
							me </label> <label><a align="center" href="">Esqueceu o seu
								usuário ou senha?</a></label>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Acesso</button>
					</form>
					<div class="panel panel-default">
						<div class="panel-body">
							<p>Essa é a plataforma de envio de trabalhos do Prof. Jarley
								Nóbrega. Os alunos matriculados no semestre deverão se cadastrar
								(apenas uma vez) para acessar a funcionalidade de envio de
								trabalhos.</p>
						</div>
					</div>
				</div>

			</div>
		</div>
</body>
</html>