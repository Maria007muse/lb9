package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import dao.PersonDbDAO;

@WebServlet( "/deleteperson")
public class DeletePersonServlet extends HttpServlet {

private static final long serialVersionUID = 1L;


public DeletePersonServlet() throws FileNotFoundException,
IOException {
 }
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
	PersonDbDAO dao = new PersonDbDAO();
String strId = request.getParameter("id");
Long deleteid = null;
if(strId != null) {
deleteid = Long.parseLong(strId);
}
try {
dao.delete(deleteid);
} catch (Exception e) {
e.printStackTrace();
}
response.sendRedirect("/persons/person");
}
}

