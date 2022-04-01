package Amoozesh;

import java.util.ArrayList;

public class Faculty
{
    private String name;
    private int facultyID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public Faculty(String name, int facultyID) {
        this.name = name;
        this.facultyID = facultyID;
    }
}
