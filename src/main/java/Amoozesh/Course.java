package Amoozesh;

import java.util.Objects;

public class Course
{
    private String name;
    private String professorName;
    private Faculty faculty;
    private int courseID;
    private int units;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public static boolean isEqual(Course crs1 , Course crs2)
    {
        if (crs1.courseID == crs2.courseID && crs1.faculty == crs2.faculty)
        {
            if (crs1.name.equals(crs2.name) && crs1.units == crs2.units && crs1.professorName.equals(crs2.professorName))
            {
                return true;
            }
        }

        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static Course getCourse(int semesterID , int courseID)
    {
        for (Semester smst : Amoozesh.semesters)
        {
            if (smst.getSemesterID() == semesterID)
            {
                for (Course crs : Objects.requireNonNull(Semester.getSemester(semesterID)).getCourses())
                {
                    if (crs.getCourseID() == courseID)
                    {
                        return crs;
                    }
                }
            }
        }
        return null;
    }

    public Course(String name, String professorName, Faculty faculty, int courseID, int units) {
        this.name = name;
        this.professorName = professorName;
        this.faculty = faculty;
        this.courseID = courseID;
        this.units = units;
    }
}
