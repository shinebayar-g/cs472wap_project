package dao;

import model.Course;

import java.util.*;

public class CourseDAO {
    private static CourseDAO single_instance = null;
    private Map<String, Course> courseDb = new HashMap<>();
    {
        courseDb.put("CS472", new Course("CS472", "WAP","3","Ins 1"));
        courseDb.put("CS422", new Course("CS422", "DBMS","3","Ins 1"));
        courseDb.put("CS544", new Course("CS544", "WAA","3","Ins 1"));
    }

    private CourseDAO() {
        super();
    }

    public static CourseDAO CourseDAO() {
        if (single_instance == null)
            single_instance = new CourseDAO();
        return single_instance;
    }


    public void addCourse(Course course) {
        courseDb.put(course.getCode(), course);
    }

    public void deleteCourse(String courseCode){
        courseDb.remove(courseCode);
    }

    public void updateCourse(Course course){
        courseDb.put(course.getCode(),course);
    }

    public List<Course> getAllCourses(){
        List<Course> list;
        Collection<Course> values = courseDb.values();
        list = new ArrayList<Course>(values);
        return list;
    }

    public Course getCourseById(String courseCode){
        return courseDb.get(courseCode);
    }
}
