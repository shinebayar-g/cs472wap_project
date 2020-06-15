package dao;

import model.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDAO {
    private static CourseDAO single_instance = null;

    private CourseDAO() {
    }

    public static CourseDAO CourseDAO() {
        if (single_instance == null)
            single_instance = new CourseDAO();
        return single_instance;
    }

    Map<Integer, Course> courseDb = new HashMap<>();

    {
        courseDb.put(1, new Course("CS472", "WAP"));
        courseDb.put(2, new Course("CS422", "DBMS"));
        courseDb.put(3, new Course("CS544", "WAA"));
    }

    public void addCourse(Course course) {
        courseDb.put(genId(), course);
    }

    public void deleteCourse(int courseId){
        courseDb.remove(courseId);
    }

    public void updateCourse(Course course){
        courseDb.put(genId(), course);
    }

    public List<Course> getAllCourses(){
        return new ArrayList<>(courseDb.values());
    }

    public Course getCourseById(int courseId){
        return courseDb.get(courseId);
    }

    public int genId() {
        return courseDb.size()+1;
    }
}
