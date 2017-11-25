package com.telusko;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchUsersController
 */
@WebServlet("/fetchUsers")
public class FetchUsersController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String searchString = request.getParameter("txt");
		UserRepository userRepository = UserRepository.getRepository();
		List<User> usersList = userRepository.getUsersByContainedText(searchString);

		RequestDispatcher dispatcher = request.getRequestDispatcher("SearchResult.jsp");
		request.setAttribute("users", usersList);
		dispatcher.forward(request, response);
	}



}
