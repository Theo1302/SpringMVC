<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../css.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SchoolDrive</title>
</head>
<body>

	<jsp:include page="../topoAdmin.jsp"></jsp:include>

	<!-- Corpo da pagina -->
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<div class="page-header">
					<h2>Cadastrar Disciplina</h2>
				</div>
				<form action="" method="get" role="form">
					<div class="form-group">
						<label for="nome">Nome da Disciplina</label> <input type="text"
							class="form-control" id="nome">
					</div>

					<div class="form-group">
						<label for="">Escolha o Curso</label> <select class="form-control">
							<option>Curso 1</option>
							<option>Curso 2</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-saved"></span>Cadastrar
						Disciplina
					</button>
					<a href="">Voltar</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>