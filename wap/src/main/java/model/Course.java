package model;

public class Course {
    private String code;
    private String name;
    private String credits;
    private String instructor;

    public void setName(String name) {
        this.name = name;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Course() {
    }

    public Course(String code, String name, String credits, String instructor) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.instructor = instructor;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
