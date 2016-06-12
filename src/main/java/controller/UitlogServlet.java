package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UitlogServlet extends HttpServlet{
	private static final long serialVersionUID = -2704675555080474509L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("user");
		req.getSession().invalidate();
		
		resp.sendRedirect(req.getContextPath() + "/"); 
		return;
	}
}
