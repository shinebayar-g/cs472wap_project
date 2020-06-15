package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
        JsonArray array = getItemsJSON();
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        out.print(array);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();

        String action = req.getParameter("action");
        int selectedId = Integer.parseInt(req.getParameter("course_id")) ;
        String obj ;

        if(action.equals("delete"))
        {
            resp.setContentType("text/json");
            //Delete object to the DATABASE
            JsonArray array = deleteRow(selectedId);
            out.print(array);
        }
        else if(action.equals("saveupdate")) {
            resp.setContentType("text/json");
            String name = req.getParameter("course_name");
            String credits = req.getParameter("course_credits");
            String instructor = req.getParameter("course_instructor");

            //Delete object to the DATABASE
            JsonArray array = editRow(selectedId,new Course(selectedId,name,credits,instructor));
            out.print(array);
        }
        else if(action.equals("add"))
        {
            resp.setContentType("text/json");
            String name = req.getParameter("course_name");
            String credits = req.getParameter("course_credits");
            String instructor = req.getParameter("course_instructor");
            //Add object to the DATABASE
            int counter = Courses.size()+1;
            Courses.add(new Course(counter,name,credits,instructor));
            //Post back to the Page
            JsonObject objToReturn = new JsonObject();
            objToReturn.addProperty("id", counter );
            objToReturn.addProperty("name", name);
            objToReturn.addProperty("credit", credits);
            objToReturn.addProperty("instructor", instructor);
            //
            out.print(objToReturn);
            //    doGet(req,resp);
        }
    }
}
