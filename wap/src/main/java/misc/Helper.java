package misc;

public class Helper
{
    public static  JsonArray getItemsJSON(){
        JsonArray objToReturn = new JsonArray();
        List<Course> Courses = getCourses();
        for(int i = 0; i < Courses.size() ; i++){
            Course itm = Courses.get(i);
            JsonObject objToAdd = new JsonObject();

            objToAdd.addProperty("id", itm.getCourseid());
            objToAdd.addProperty("name", itm.getCourseName());
            objToAdd.addProperty("credit", itm.getCredithours());
            objToAdd.addProperty("instructor", itm.getCourseInstructor());

            objToReturn.add(objToAdd);
        }
        return objToReturn;
    }
}