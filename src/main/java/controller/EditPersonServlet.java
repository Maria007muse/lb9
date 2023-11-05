package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import dao.PersonDbDAO;
import dao.VerietyDbDAO;
import domain.Person;
import domain.VerietyPerson;

@WebServlet("/editperson")
public class EditPersonServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

 public EditPersonServlet()
throws FileNotFoundException, IOException {

 }
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
String userPath;
List<VerietyPerson> verieties;
List<Person> persons = null;
Person editperson = null;
VerietyDbDAO daoVeriety = new VerietyDbDAO();
PersonDbDAO dao = new PersonDbDAO();
try {
	verieties = daoVeriety.findAll();
request.setAttribute("verieties", verieties);
} catch (Exception e) {
e.printStackTrace();
}
try {
persons = dao.findAll();
verieties = daoVeriety.findAll();
for (Person person: persons) {
person.setVeriety(daoVeriety.FindById(person.getIdVeriety(), verieties));
}
}catch (Exception e) {
e.printStackTrace();
}
String strId = request.getParameter("id");
Long id = null; // id редактируемого сотрудника
if(strId != null) {
id = Long.parseLong(strId);
}
try {
editperson = dao.findById(id);
} catch (Exception e) {
e.printStackTrace();
}
request.setAttribute("personEdit", editperson);
request.setAttribute("persons", persons);
userPath = request.getServletPath();
if ("/editperson".equals(userPath)) {
request.getRequestDispatcher("/views/editperson.jsp").forward(request, response);
}
}
protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
PersonDbDAO dao = new PersonDbDAO();
String strId = request.getParameter("id");
Long id = null;
if(strId != null) {
id = Long.parseLong(strId);
}
String firstName = request.getParameter("firstname");
String lastName = request.getParameter("lastname");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String veriety = request.getParameter("veriety");
int index1 = veriety.indexOf('=');
int index2 = veriety.indexOf(",");
if (index1 >= 0 && index2 >= 0) {
    String r1 = veriety.substring(index1 + 1, index2);
    Long idVeriety = Long.parseLong(r1.trim());
    VerietyPerson verietyPerson = new VerietyPerson(idVeriety, veriety);
    Person editPerson = new Person(id, firstName, lastName, phone, email, idVeriety, verietyPerson);
try {
dao.update(editPerson);
} catch (Exception e) {
e.printStackTrace();
}
response.sendRedirect("/persons/person");
}
}
}
