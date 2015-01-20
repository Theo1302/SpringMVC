<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../css.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SchoolDrive</title>
</head>
<body>
	<jsp:include page="topoAluno.jsp"></jsp:include>
	<!-- Corpo da pagina -->
	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="MenuLateral.jsp"></jsp:include>
			<div class="col-md-8">
				<div class="row">
					<div align="center" class="page-header">
						<h2>Trabalho Recentes</h2>
					</div>
					<div class="col-md-7">
						<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
							<c:forEach var="disciplina" items="${disciplinas}">
								<div class="panel panel-default">
									<div class="panel-heading" role="tab" id="${disciplina.nome}">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion" href="#<c:out value="${disciplina.id}"></c:out>"
												aria-expanded="true" aria-controls="${disciplina.id}">${disciplina.nome} </a>
										</h4>
									</div>
									<div id="<c:out value="${disciplina.id}"></c:out>" class="panel-collapse collapse" role="tabpanel"
										aria-labelledby="${disciplina.nome}">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Titulo</th>
													<th>Data Limite</th>
													<th>Verificar</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="trabalho" items="${disciplina.trabalhos}">
													<tr>
														<td>${trabalho.titulo}</td>
														<td><fmt:formatDate pattern="dd/MM/yyyy" value="${trabalho.dataLimite}" /></td>
														<td><a href="formTrabalho?trabalhoId=${trabalho.id}" class="btn btn-primary"> Visualizar</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>