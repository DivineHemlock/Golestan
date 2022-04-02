package Amoozesh;

import Student.Student;

import java.util.ArrayList;
import java.util.Stack;

public class Amoozesh
{
    private String name;
    protected static ArrayList<Semester> semesters;
    protected static ArrayList<Faculty> faculties;
    public static ArrayList<Student> students;
    public static boolean isAmoozeshMade = false;

    public static ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public static ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSemester(String name , int ID)
    {
        semesters.add(new Semester(name ,ID));
    }

    public void makeFaculty(String name , int ID)
    {
        faculties.add(new Faculty(name , ID));
    }

    public void makeStudent(String name , String lastName , int studentID , String major , Faculty faculty , int yearOfEntry , int GPA)
    {
        students.add(new Student(name,lastName, studentID ,major,faculty,yearOfEntry,GPA));
    }

    public boolean addCourseToSemester(int semesterID , Course course)
    {
        for (Semester smst : semesters)
        {
            if (semesterID == smst.getSemesterID())
            {
                smst.addCourse(course);
                return true;
            }
        }
        return false;
    }

    public Amoozesh(String name) {
        this.name = name;
        semesters = new ArrayList<>();
        faculties = new ArrayList<>();
        students = new ArrayList<>();
        isAmoozeshMade = true;
    }
}
