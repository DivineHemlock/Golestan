package Amoozesh;

import java.util.ArrayList;

public class Amoozesh
{
    private String name;
    private static ArrayList<Semester> semesters;
    private static ArrayList<Faculty> faculties;
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

    public Amoozesh(String name) {
        this.name = name;
        semesters = new ArrayList<>();
        faculties = new ArrayList<>();
        isAmoozeshMade = true;
    }
}
