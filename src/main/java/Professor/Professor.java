package Professor;

import Amoozesh.Amoozesh;
import Amoozesh.Course;
import Amoozesh.Faculty;
import Student.Student;
import Amoozesh.Semester;

import java.util.ArrayList;

public class Professor
{
    private String name;
    private String lastName;
    private Faculty faculty;
    private String group;
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void addCourse(Course course)
    {
        this.courses.add(course);
    }

    public boolean setScore (Course course , Student student , int score)
    {
        for (Student std : Amoozesh.students)
        {
            if (Student.isEqual(std,student))
            {
                for (Course crs : std.getCourses())
                {
                    if (Course.isEqual(crs , course))
                    {
                        crs.setScore(score);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Professor getProfessor(String name , String lastName)
    {
        for (Professor dr : Amoozesh.professors)
        {
            if (dr.name.equals(name) && dr.lastName.equals(lastName))
            {
                return dr;
            }
        }
        System.out.println("no professor with this info has been registered");
        return null;
    }

    public void printCourses(Professor dr)
    {
        for (int i = 0 ; i < dr.courses.size() ; i++)
        {
            System.out.println(dr.courses.get(i).getName());
        }
    }

    public static void printStudentsInCourse(Professor doctor , Semester semester, Course course)
    {
        for (Professor dr : Amoozesh.professors)
        {
            if (Professor.isEqual(dr,doctor))
            {
                for (Semester smst : Amoozesh.getSemesters())
                {
                    if (Semester.isEqual(smst,semester))
                    {
                        for (Course crs : smst.getCourses())
                        {
                            if (Course.isEqual(crs,course))
                            {
                                for (Student std : Amoozesh.students)
                                {
                                    for (Course stdCrs : std.getCourses())
                                    {
                                        if (Course.isEqual(stdCrs,crs))
                                        {
                                            System.out.println(std.getName() + "  " + std.getLastName());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isEqual (Professor dr1 , Professor dr2)
    {
        return dr1.name.equals(dr2.name) && dr1.lastName.equals(dr2.lastName) && dr1.group.equals(dr2.group);
    }

    public Professor(String name, String lastName, Faculty faculty, String group) {
        this.name = name;
        this.lastName = lastName;
        this.faculty = faculty;
        this.group = group;
        this.courses = new ArrayList<>();
    }
}
