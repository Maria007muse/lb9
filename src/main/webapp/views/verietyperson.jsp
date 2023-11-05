<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.VerietyPerson"%>


<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Виды клиентов</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Verieties</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery -->
<script defer src="js/jquery.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>
</head>
<body>
 <div class="container-fluid">
 <jsp:include page="/views/header.jsp" />
 <div class="container-fluid">
 <div class="row justify-content-start ">
 <div class="col-8 border bg-light px-4">
 <h3>Список видов</h3>
 <table class="table">
 <thead>
 <th scope="col">Код</th>
 <th scope="col">Вид клиента</th>
 <th scope="col"> Редактировать</th>
 <th scope="col">Удалить</th>
 </thead>
 <tbody>
 <c:forEach var="verietyperson" items="${verieties}">
 
 <tr>
 <td>${verietyperson.getId()}</td>
 <td>${verietyperson.getNameveriety()}</td>
 <td width="20">
  <a href="#" role="button" class="btn btn-outline-primary">
    <img alt="Редактировать" src="images/icon-edit.png" style="width: 18px; height: 18px;">
  </a>
</td>
<td width="20">
  <a href="#" role="button" class="btn btn-outline-primary">
    <img alt="Удалить" src="images/icon-delete.png" style="width: 16px; height: 16px;">
  </a>
</td>
 </tr>
 </c:forEach>
 </tbody>
 </table>
 </div>
 <div class="col-4 border px-4">
 <form method="POST" action="">
 <h3>Новый вид клиента</h3>
 <div class="mb-3">
 <br> <label for="inputVerietyPerson" class="col-sm-3 col-form-label">Вид</label>
 <div class="col-sm-6">
 <input type="text" name="inputVerietyPerson" class="form-control" id="personVeriety" />
 </div>
 </div>
 <p>
 <br> <br> <br>
 <button type="submit"
 class="btn btn-primary">Добавить</button>
 <br>
 </p>
 </form>
 </div>
 </div>
 </div>
 <jsp:include page="/views/footer.jsp" />
 </div>
</body>
</html>