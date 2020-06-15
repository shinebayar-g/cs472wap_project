package controller;

import dao.CourseDAO;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserDAO userDao;
    private CourseDAO courseDao;

    @Override
    public void init() throws ServletException {
        userDao = UserDAO.UserDAO();
        courseDao = CourseDAO.CourseDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        boolean isAdmin = userDao.getUserByName(username).isAdmin();

        if (userDao.isValidUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", username);

            Cookie c;
            if ("yes".equals(remember)) {
                c = new Cookie("user", username);
                c.setMaxAge(30*24*60*60);
            } else {
                c = new Cookie("user", null);
                c.setMaxAge(0);
            }
            response.addCookie(c);

        } else {
            request.getSession().setAttribute("err_msg", "Username or password is invalid.");
        }

        if (isAdmin) {
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/");
    }
}
