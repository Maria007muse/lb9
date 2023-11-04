package controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.PersonDbDAO;
import dao.VerietyDbDAO;
import domain.Person;
import domain.VerietyPerson;

/**
* Servlet implementation class RoleServlet_
*/
@WebServlet("/person")
public class PersonsServle extends HttpServlet {
private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public PersonsServle() {
 super();
 // TODO Auto-generated constructor stub
 }
/**
* @see HttpServlet#doGet(HttpServletRequest request,
HttpServletResponse response)
*/
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
	 String userPath;
	 List<Person> persons;
	 List<VerietyPerson> verieties;
	 VerietyDbDAO daoRole = new VerietyDbDAO();
	 PersonDbDAO dao = new PersonDbDAO();
	 try {
	 persons = dao.findAll();
	 verieties = daoRole.findAll();
	 for (Person person: persons) {
	 person.setVeriety(daoRole.FindById(person.getIdRole(), verieties));
	 }
	 request.setAttribute("persons", persons);
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	  userPath = request.getServletPath();
	 if("/person".equals(userPath)){
	 request.getRequestDispatcher("/views/person.jsp").forward(request
	 , response);
	 }
	}
/**
* @see HttpServlet#doPost(HttpServletRequest request,
HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}