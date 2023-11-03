<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.VerietyPerson"%>
<%@ page import="domain.Person"%>
<%
VerietyPerson r1 = new VerietyPerson(1l, "инвестор");
VerietyPerson r2 = new VerietyPerson(2l, "доверительное управление");
VerietyPerson[] verieties = new VerietyPerson[]{r1, r2};
pageContext.setAttribute("verieties", verieties);
Person p1 = new Person(1l, "Иван","Иванов", "ivanov@mail.ru", "+7(961)-289-55-24", 2334345, 1l, r1);
Person p2 = new Person(2l, "Петр","Петров", "petrov@mail.ru", "+7(961)-289-44-39",43534545, 2l, r2);
Person p3= new Person(3l, "Сидор","Сидоров", "sidorov@mail.ru", "+7(961)-289-33-57",839738453, 3l, r2);
Person p4 = new Person(4l, "Иван","Иванов", "ivanov@mail.ru", "+7(961)-289-44-39",298139823, 4l, r1);
Person[] persons = new Person[]{p1, p2, p3, p4};
pageContext.setAttribute("persons", persons);
%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Клиенты</title>
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
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.mi
n.js"></script>
</head>
<body>
<body>
 <div class="container-fluid">
 <jsp:include page="/views/header.jsp" />
 <div class="container-fluid">
 <div class="row justify-content-start ">
 <div class="col-8 border bg-light px-4">
 <h3>Список клиентов</h3>
 <table class="table">
 <thead>
 <th scope="col">Код</th>
 <th scope="col">Фамилия</th>
 <th scope="col">Имя</th>
 <th scope="col">Вид клиента</th>
 <th scope="col">Телефон</th>
 <th scope="col">Эл.почта</th>
 <th scope="col">ИНН</th>
 <th scope="col">Редактировать</th>
 <th scope="col">Удалить</th>
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
 <td>${person.getInn()}</td>
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
 <h3>Новый клиент</h3>
 <br>
 <div class="mb-3 row">
 <label for="lastname"
 class="col-sm-3 col-form-label">Фамилия</label>
 <div class="col-sm-7">
 <input type="text" class="form-control"
 id="staticLastname"name="lastname" />
 </div>
 </div>
 <div class="mb-3 row">
 <label for="firstname"
 class="col-sm-3 col-form-label">Имя</label>
 <div class="col-sm-7">
 <input type="text"
 class="form-control" id="staticFirstname"
 name="firstname" />
 </div>
 </div>
 <div class="mb-3 row">
 <label for="verietyname" class="col-sm-3 col-form-label">Вид клиента</label>
 <div class="col-sm-7">
 <select name="veriety" class="form-control">
 <option>Выберите вид</option>
 <c:forEach var="veriety" items="${verieties}">
 <option value="${veriety}">
<c:out value="${veriety.nameveriety}" />
 </option>
 </c:forEach>
 </select>
 </div>
 </div>

 <div class="mb-3 row">
 <label for="phone"
 class="col-sm-3 col-form-label">Телефон</label>
 <div class="col-sm-7">
 <input type="text"
 class="form-control" id="staticphone"
 name="phone" />
 </div>
 </div>
 <div class="mb-3 row">
 <label for="email"
 class="col-sm-3 col-form-label">Эл.почта</label>
 <div class="col-sm-7">
 <input type="text" class="form-control"
 id="staticemail" name="email" />
 </div>
 </div>
 <div class="mb-3 row">
 <label for="inn"
 class="col-sm-3 col-form-label">ИНН</label>
 <div class="col-sm-7">
 <input type="text" class="form-control"
 id="staticemail" name="inn" />
 </div>
 </div>
 <p> <br>
 <button type="submit"
 class="btn btn-primary">Добавить</button>
 </p>
 </form>
 </div>
 </div>
 </div>
 <jsp:include page="/views/footer.jsp" />
 </div>
</body>
</html>