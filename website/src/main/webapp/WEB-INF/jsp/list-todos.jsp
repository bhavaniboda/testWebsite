<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Todo's for ${name}</title>
</head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

<body>
<div class="container">
<H1> Todo's for ${name}</H1>
<table class="table table-striped">
<caption>Your todo's are</caption>
<thead>
<tr> 
<th>Description</th>
<th>is it Done?</th>
<th>target date</th>
<th>can we delete</th>
</tr>
</thead>
<tbody>
	<c:forEach items="${todos}" var="todo">
		<tr>
		  <td>${todo.desc}</td>
		  <td>${todo.isdone}</td>
		  <td>${todo.targetDate}</td>
		  <td><a type="button" class="btn btn-warning" href="/delete-todo/?id=${todo.id}">Delete</a>
		</tr>
	</c:forEach>
	
</tbody>
</table>
 <br>

 <div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
 </div>
  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</div>
  </body>

</html>