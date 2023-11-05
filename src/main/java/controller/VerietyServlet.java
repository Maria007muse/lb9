package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import domain.VerietyPerson;
import dao.VerietyDbDAO;


@WebServlet("/verietyperson")
public class VerietyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String userPath;
        List<VerietyPerson> verieties;
        VerietyDbDAO dao = new VerietyDbDAO();
        
        try {
            verieties = dao.findAll();
            request.setAttribute("verieties", verieties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        userPath = request.getServletPath();
        if ("/verietyperson".equals(userPath)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/verietyperson.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	VerietyDbDAO dao = new VerietyDbDAO();
    	String name = request.getParameter("inputVerietyPerson");
    	VerietyPerson newVerietyPerson = new VerietyPerson(name);
    	try {
    	Long index = dao.insert(newVerietyPerson);
    	System.out.println("Adding result: " + index );
    	} catch (Exception e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	}
        doGet(request, response);
    }
}
