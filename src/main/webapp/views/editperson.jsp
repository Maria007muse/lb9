<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.VerietyPerson"%>
<%@ page import="domain.Person"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Редактирование данных</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Persons</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery -->
<script defer src="js/jquery.min.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>
</head>
<body>
<body>
16
<div class="container-fluid">
<jsp:include page="/views/header.jsp" />
<div class="container-fluid">
<div class="row justify-content-start ">
<div class="col-8 border bg-light px-4">
<h3>Список сотрудников</h3>
<table class="table">
<thead>
<th scope="col">Код</th>
<th scope="col">Фамилия</th>
<th scope="col">Имя</th>
<th scope="col">Вид клиента</th>
<th scope="col">Телефон</th>
<th scope="col">Эл.почта</th>
</thead>
<tbody>
<c:forEach var="person" items="${persons}">
<tr>
<td>${person.getId()}</td>
<td>${person.getLastName()}</td>
<td>${person.getFirstName()}</td>
<td>${person.getVeriety()}</td>
<td>${person.getPhone()}</td>
<td>${person.getEmail()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div class="col-4 border px-4">
<form method="POST" action="">
<h3>Редактирование данных</h3>
<br>
<div class="mb-3 row">
<label for="idperson" class="col-sm-3 col-form-label">
Код клиента</label>
<div class="col-sm-7">
<input type="text" class="form-control" readonly
id="idperson" value="${personEdit.getId()}" />
</div>
</div>
<div class="mb-3 row">
<label for="lastname" class="col-sm-3 col-form-label">
Фамилия</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticLastname"
name="lastname" value="${personEdit.getLastName()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="firstname" class="col-sm-3 col-form-label">
Имя</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticFirstname"
name="firstname" value="${personEdit.getFirstName()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="rolename" class="col-sm-3 col-form-label">
Вид</label>
<div class="col-sm-7">
<select name="veriety" class="form-control">
<option>Выберите вид</option>
<c:forEach var="veriety" items="${verieties}">
<option value="${veriety}">
<c:out value="${veriety.getNameveriety()}"></c:out>
</option>
</c:forEach>
</select>
</div>
</div>
<div class="mb-3 row">
<label for="phone" class="col-sm-3 col-form-label">
Телефон</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticphone"
name="phone" value="${personEdit.getPhone()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="email" class="col-sm-3 col-form-label">Эл.почта
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticemail"
name="email" value="${personEdit.getEmail()}"/>
</div>
</div>
<p>
<br>
<button type="submit" class="btn btnprimary">Редактировать</button>
<a href='<c:url value="/person" />' role="button"
class="btn btn-secondary">Отменить</a>
</p>
</form>
</div>
</div>
</div>
<jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>