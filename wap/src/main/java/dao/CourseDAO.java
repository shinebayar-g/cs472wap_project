package dao;

import model.Course;

import java.util.*;

public class CourseDAO {
    private static CourseDAO single_instance = null;
    private Map<String, Course> courseDb = new HashMap<>();
    {
        courseDb.put("CS390", new Course("CS390", "Fundamental Programming Practices","4.0","Rakesh Shreshta"));
        courseDb.put("CS401", new Course("CS401", "Modern Programing Practices","4.0","Francis Mosse"));
        courseDb.put("CS422", new Course("CS422", "Database Management Systems","4.0","Rakesh Shreshta"));
        courseDb.put("CS545", new Course("CS545", "Web Application Architecture","4.0","Rujuan Xing"));
        courseDb.put("CS544", new Course("CS544", "Enterprise Architecture","4.0","Joseph Bruen"));
        courseDb.put("CS582", new Course("CS582", "Machine Learning","4.0","Emdad Khan"));
        courseDb.put("CS572", new Course("CS572", "Modern Web Applications","4.0","Asaad Saad"));
        courseDb.put("CS523", new Course("CS523", "Big Data Technology","4.0","Mrudula Mukadam"));
        courseDb.put("CS522", new Course("CS522", "Big Data","4.0","Premchand Nair"));
        courseDb.put("CS472", new Course("CS472", "Web Programming","4.0","Rakesh Shreshta"));
        courseDb.put("MGT5341", new Course("MGT5341", "Career Strategies for Information Technology","4.0","Sheryl Shulmier"));
        courseDb.put("CS435", new Course("CS435", "Algorithms","4.0","Paul Corazza"));
        courseDb.put("CS425", new Course("CS425", "Software Engineering","4.0","Emdad khan"));
        courseDb.put("CS525", new Course("CS525", "Advanced Software Development","4.0","Francis Mosse"));
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
