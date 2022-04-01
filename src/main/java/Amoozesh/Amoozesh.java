package Amoozesh;

import java.util.ArrayList;

public class Amoozesh
{
    private String name;
    private static ArrayList<Semester> semesters;
    public static boolean isAmoozeshMade;

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    // adds semester to amoozesh list of semesters
    private void addSemesters(Semester semester) {
        semesters.add(semester);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSemester(String name , int ID)
    {
        new Semester(name , new ArrayList<>(), ID);
    }

    public Amoozesh(String name) {
        this.name = name;
        semesters = new ArrayList<>();
        isAmoozeshMade = true;
    }
}
