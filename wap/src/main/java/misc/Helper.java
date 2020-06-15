package misc;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dao.CourseDAO;
import model.Course;

import java.util.List;

public class Helper
{
    public static JsonArray getItemsJSON(){
        JsonArray objToReturn = new JsonArray();
        List<Course> Courses = CourseDAO.CourseDAO().getAllCourses();
        for(int i = 0; i < Courses.size() ; i++){
            Course itm = Courses.get(i);
            JsonObject objToAdd = new JsonObject();

            objToAdd.addProperty("code", itm.getCode());
            objToAdd.addProperty("name", itm.getName());
            objToAdd.addProperty("credit", itm.getCredits());
            objToAdd.addProperty("instructor", itm.getInstructor());

            objToReturn.add(objToAdd);
        }

        return objToReturn;
    }
}