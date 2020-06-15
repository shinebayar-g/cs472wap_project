package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private boolean isAdmin;
    private List<Course> courses = new ArrayList<>();

    public User() {
    }

    public User(Integer id, String username, String password,boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void deleteCourse(int courseNumber) {
        courses.remove(courseNumber);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean hasCourse(String courseCode)
    {
        for (Course c: getCourses()) {
            if(c.getCode().equals(courseCode))
                return true;
        }
        return false;
    }

}
