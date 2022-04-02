package Amoozesh;

import java.util.ArrayList;

public class Semester
{
    private String name;
    private int semesterID;
    private ArrayList<Course> courses;

    public int getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(int semesterNumber) {
        this.semesterID = semesterNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void printCoursesInSemester (int semesterID)
    {
        for (Semester smst : Amoozesh.semesters)
        {
            if (smst.semesterID == semesterID)
            {
                for (int i = 0 ; i < smst.courses.size() ; i++)
                {
                    System.out.println(smst.courses.get(i).getName() + "  " + smst.courses.get(i).getFaculty().getName() + "  " + smst.courses.get(i).getProfessorName());
                }
            }
        }
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse (Course course){
        for (Course crs : courses)
        {
            if (Course.isEqual(crs , course))
            {
                courses.remove(course);
            }
        }
    }

    public static Semester getSemester(int ID)
    {
        for (Semester smst : Amoozesh.semesters)
        {
            if (smst.getSemesterID() == ID)
            {
                return smst;
            }
        }
        return null;
    }



    public Semester(String name, int semesterID) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.semesterID = semesterID;
    }
}


