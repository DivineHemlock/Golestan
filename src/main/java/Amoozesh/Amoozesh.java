package Amoozesh;

import Professor.Professor;
import Student.Student;

import java.util.ArrayList;
import java.util.Stack;

public class Amoozesh
{
    private String name;
    protected static ArrayList<Semester> semesters;
    protected static ArrayList<Faculty> faculties;
    public static ArrayList<Student> students;
    public static ArrayList<Professor> professors;
    public static boolean isAmoozeshMade = false;

    public static ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public static ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static ArrayList<Professor> getProfessors() {
        return professors;
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

    public void makeProfessor(String name , String lastName , Faculty faculty , String group)
    {
        professors.add(new Professor(name , lastName , faculty , group));
    }

   /* public void makeCourse(String name , String professorName , Faculty faculty , int courseID , int units )
    {
        new Course(name,professorName,faculty,courseID,units);
    }*/

    public boolean addCourseToSemesterAndProfessor(int semesterID , Course course , String professorName , String professorLastName)
    {
        for (Semester smst : semesters)
        {
            if (semesterID == smst.getSemesterID())
            {
                smst.addCourse(course); // adding course to the semester
                for (Professor dr : Amoozesh.professors) // adding course to professors course list
                {
                    if (dr.getName().equals(professorName) && dr.getLastName().equals(professorLastName))
                    {
                        dr.addCourse(course);
                    }
                }
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
        professors = new ArrayList<>();
        isAmoozeshMade = true;
    }
}
