package dao;

import model.Course;

import java.util.*;

public class CourseDAO {
    private static CourseDAO single_instance = null;
    private Map<String, Course> courseDb = new HashMap<>();
    {
        courseDb.put("CS471", new Course("CS471", "WAP","4.0","Rakesh Shreshta"));
        courseDb.put("CS472", new Course("CS472", "DBMS","4.0","Paul Corraza"));
        courseDb.put("CS573", new Course("CS573", "WAA","4.0","Moses Francis"));
        courseDb.put("CS474", new Course("CS474", "Algoritham","4.0","Najeeb Najeeb"));
        courseDb.put("CS475", new Course("CS475", "Software Engineering","4.0","Emdad khan"));
        courseDb.put("CS576", new Course("CS576", "MWA","4.0","Robert Lewis"));
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
