package Student;

import Amoozesh.Amoozesh;
import Amoozesh.Course;
import Amoozesh.Faculty;

import java.util.ArrayList;

public class Student
{
    private String name;
    private String lastName;
    private int studentID;
    private String major;
    private Faculty faculty;
    private int yearOfEntry;
    private int GPA;
    private int unitsInCurrentSemester;
    private ArrayList<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public int getUnitsInCurrentSemester() {
        return unitsInCurrentSemester;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course)
    {
        this.courses.add(course);
    }

    public boolean removeCourse(Course course)
    {
        for (Course crs : this.courses)
        {
            if (Course.isEqual(crs,course))
            {
                this.courses.remove(course);
                return true;
            }
        }
        return false;
    }

    public void setUnitsInCurrentSemester(int unitsInCurrentSemester) {
        this.unitsInCurrentSemester = unitsInCurrentSemester;
    }

    public static Student getStudent(int studentID)
    {
        for (Student std : Amoozesh.students)
        {
            if (std.getStudentID() == studentID)
            {
                return std;
            }
        }
        return null;
    }

    public void printCoursesOfStudent(int studentID)
    {
        boolean exists = false;
        for (Student std : Amoozesh.students)
        {
            if (std.getStudentID() == studentID)
            {
                exists = true;
                for (int i = 0 ; i < std.courses.size() ; i++)
                {
                    System.out.println(std.courses.get(i).getName()+ "  " + std.courses.get(i).getFaculty().getName()+ "  " + std.courses.get(i).getProfessorName());
                }
            }
        }
        if (!exists)
        {
            System.out.println("no student with this ID has been registered");
        }

    }

    public Student(String name, String lastName, int studentID, String major, Faculty faculty, int yearOfEntry, int GPA)
    {
        this.name = name;
        this.lastName = lastName;
        this.studentID = studentID;
        this.major = major;
        this.faculty = faculty;
        this.yearOfEntry = yearOfEntry;
        this.GPA = GPA;
        this.unitsInCurrentSemester = 0;
        this.courses = new ArrayList<>();
    }
}
