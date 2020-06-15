package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dao.CourseDAO;
import misc.Helper;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("type") != null)
        {
            JsonArray array = Helper.getItemsJSON();
            resp.setContentType("text/json");
            PrintWriter out = resp.getWriter();
            out.print(array);
        }
        else
        {
            req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        String action = req.getParameter("action");
       // int selectedId = Integer.parseInt(req.getParameter("selected_id")) ;
        String obj ;

        if(action.equals("delete"))
        {
            String selectedId = req.getParameter("course_code");
            resp.setContentType("text/json");
            //Delete object to the DATABASE
            CourseDAO.CourseDAO().deleteCourse(selectedId);
            JsonArray array = Helper.getItemsJSON();
            out.print(array);
        }
        else if(action.equals("saveupdate")) {
            resp.setContentType("text/json");

            String code = req.getParameter("course_code");
            String name = req.getParameter("course_name");
            String credits = req.getParameter("course_credits");
            String instructor = req.getParameter("course_instructor");

            CourseDAO.CourseDAO().updateCourse((new Course(code,name,credits,instructor)));
            JsonArray array = Helper.getItemsJSON();
            out.print(array);
        }
        else if(action.equals("add"))
        {
            resp.setContentType("text/json");
            String code = req.getParameter("course_code");
            String name = req.getParameter("course_name");
            String credits = req.getParameter("course_credits");
            String instructor = req.getParameter("course_instructor");
            //Add object to the DATABASE

            CourseDAO.CourseDAO().addCourse(new Course(code,name,credits,instructor));
            JsonArray array = Helper.getItemsJSON();
            out.print(array);
        }
    }
}
