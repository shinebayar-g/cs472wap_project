package controller;

import com.google.gson.Gson;
import dao.CourseDAO;
import dao.UserDAO;
import model.Course;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class IndexController extends HttpServlet {
    private UserDAO userDao;
    private CourseDAO courseDao;

    @Override
    public void init() throws ServletException {
        userDao = UserDAO.UserDAO();
        courseDao = CourseDAO.CourseDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Course> courses = courseDao.getAllCourses();
        req.setAttribute("courses", courses);

        String username = (String) req.getSession().getAttribute("loggedInUser");
        User user = userDao.getUserByName(username);
        List<Course> myCourses = user.getCourses();
        req.setAttribute("myCourses", myCourses);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        }
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String jsonSting = req.getParameter("product");
////        req.getParameter("product");
////        model.Product product = mapper.fromJson(req.getParameter("product"), model.Product.class);
////        product.setId(dao.genId());
////        dao.addProduct(product);
////        PrintWriter out = resp.getWriter();
////        out.print(mapper.toJson(product));
//    }
}
