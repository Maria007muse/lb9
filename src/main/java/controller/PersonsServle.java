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
	 VerietyDbDAO daoVeriety = new VerietyDbDAO();
	 PersonDbDAO dao = new PersonDbDAO();
	 try {
		 verieties = daoVeriety.findAll();
		 request.setAttribute("verieties", verieties);
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

	 try {
	 persons = dao.findAll();
	 verieties = daoVeriety.findAll();
	 for (Person person: persons) {
	 person.setVeriety(daoVeriety.FindById(person.getIdVeriety(), verieties));
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
	PersonDbDAO dao = new PersonDbDAO();
    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastname");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String veriety = request.getParameter("veriety");
    int index1 = veriety.indexOf('=');
    int index2 = veriety.indexOf(",");
    String r1 = veriety.substring(index1 + 1, index2);
    Long idVeriety = Long.parseLong(r1.trim());
    VerietyPerson verietyPerson = new VerietyPerson(idVeriety, veriety);
    Person newPerson = new Person(idVeriety, firstName, lastName, phone, email, idVeriety, verietyPerson);
	try {
	Long index = dao.insert(newPerson);
	System.out.println("Adding result: " + index );
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
doGet(request, response);
}
}