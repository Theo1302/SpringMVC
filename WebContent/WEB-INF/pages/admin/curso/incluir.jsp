<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<div class="col-lg-7 col-lg-offset-1">

				<!-- mensagens -->
				<jsp:include page="../../mensagens.jsp">
					<jsp:param value="${tipo}" name="tipo" />
					<jsp:param value="${mensagens}" name="mensagens" />
				</jsp:include>


				<div class="page-header">
					<h3>Adcionar Curso</h3>
				</div>
				<form:form action="incluirCurso" method="post" role="form"
					modelAttribute="curso">
					<div class="form-group">
						<label for="nome">Nome Curso</label>
						<form:input type="text" class="form-control" id="nome" path="nome" />
					</div>
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-saved"></span>Cadastrar Curso
					</button>
					
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-7 col-lg-offset-1">
				<div class="page-header">
					<h3>Cursos Cadastrados</h3>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead align="center">
							<tr>
								<th>Nome Curso</th>
								<th>Excluir</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="curso" items="${cursos}">
								<tr>
									<td align="center">${curso.nome}</td>
									<td align="center"><a class="btn btn-danger"
										href="excluirCurso?id=${curso.id}"> <span
											class="glyphicon glyphicon-remove-sign"></span>Excluir
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>