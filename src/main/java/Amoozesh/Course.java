package Amoozesh;

public class Course
{
    private String name;
    private String professorName;
    private Faculty faculty;
    private int courseID;
    private int units;

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getProfessorName() {
        return professorName;
    }

    protected void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    protected Faculty getFaculty() {
        return faculty;
    }

    protected void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    protected int getCourseID() {
        return courseID;
    }

    protected void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    protected int getUnits() {
        return units;
    }

    protected void setUnits(int units) {
        this.units = units;
    }

    protected static boolean isEqual(Course crs1 , Course crs2)
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

    public Course(String name, String professorName, Faculty faculty, int courseID, int units) {
        this.name = name;
        this.professorName = professorName;
        this.faculty = faculty;
        this.courseID = courseID;
        this.units = units;
    }
}
