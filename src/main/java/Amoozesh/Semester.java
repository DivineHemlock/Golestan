package Amoozesh;

import java.util.ArrayList;

public class Semester
{
    private String name;
    private int semesterID;
    private ArrayList<Course> courses;

    public int getSemesterNumber() {
        return semesterID;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterID = semesterNumber;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected ArrayList<Course> getCourses() {
        return courses;
    }

    protected void addCourse(Course course) {
        this.courses.add(course);
    }

    protected void removeCourse (Course course){
        for (Course crs : courses)
        {
            if (Course.isEqual(crs , course))
            {
                courses.remove(course);
            }
        }
    }

    protected Semester(String name, ArrayList<String> courses , int semesterID) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.semesterID = semesterID;
    }
}
