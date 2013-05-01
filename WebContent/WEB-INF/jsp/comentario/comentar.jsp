<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Comente sobre</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" media="screen"></link>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="/comente-sobre/">Home</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="hero-unit">
					<form class="form-horizontal" action="" method="post">
						<div class="control-group">
							<label class="control-label">Email</label>
							<div class="controls">
								<input type="text" id="comentario.autor.email" name="comentario.email" 
								placeholder="Digite seu e-mail">
							</div>
							<label class="control-label">Seu comentario sobre <strong>${assunto}</strong></label>
							<div class="controls">
								<textarea rows="10" cols="10" name="comentario.descricao" placeholder="Vamo lá! ..." maxlength="290"></textarea> 
							</div>
							<input type="hidden" id="comentario.assunto" name="comentario.assunto" value="${assunto}">
							<div class="controls">
								<button type="submit" class="btn btn-primary">Postar</button>
							</div>
						</div>
					</form>
				</div>
		</div>
		<div class="row-fluid">
			<div>
				<p>Mais sobre <strong>${assunto}</strong></p>
				<hr>
				<table class="table table-striped table-condensed table-hover">
					<thead>
						<tr>
							<td>Autor</td>
							<td>Comentario</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="comentario" items="${comentarios}" varStatus="s">
							<tr>
								<td>${comentario.autor}</td>
								<td>${comentario.descricao}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>