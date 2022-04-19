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
        for (Course crs : this.courses)
        {
            if (Course.isEqual(crs , course))
            {
                this.courses.remove(course);
                return;
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
        System.out.println("no such semester exists ! ");
        return null;
    }

    public static boolean isEqual(Semester smst1 , Semester smst2)
    {
        return smst1.semesterID == smst2.semesterID && smst1.name.equals(smst2.name);
    }



    public Semester(String name, int semesterID) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.semesterID = semesterID;
    }
}


