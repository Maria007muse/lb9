package controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
	    // Выполните необходимую логику, если есть, перед перенаправлением

	    // Получите объект RequestDispatcher и укажите путь к "person.jsp"
	 RequestDispatcher dispatcher = request.getRequestDispatcher("/views/person.jsp");
	    // Вызовите метод forward, чтобы перенаправить запрос к "person.jsp"
	    dispatcher.forward(request, response);
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