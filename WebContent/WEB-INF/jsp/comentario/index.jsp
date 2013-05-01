<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Comente sobre</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" media="screen"></link>
</head>
<body>
	<div class="container">
		<div class="row-fluid span4">
			&nbsp;
		</div>
		<h1>Quero comentar sobre...</h1>
		<div class="row-fluid input-append">
			<input type="text" name="comentario.assunto" id="assunto-js" placeholder="digite um assunto..." class="input-xxlarge">	
		 	<a class="btn btn-medium btn-primary" href="/comente-sobre/" id="comentar-js">Ir</a>
		</div>
		<div class="alert alert-error row-fluid input-xxlarge invisible">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <strong>don't be shame  :-) </strong> ...digite o assunto antes de comentar
		</div>
	</div>
</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</html>