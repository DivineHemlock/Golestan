import Amoozesh.Amoozesh;
import Amoozesh.Semester;
import Amoozesh.Faculty;
import Amoozesh.Course;
import Student.Student;
import java.util.ArrayList;
import java.util.Objects;

public class Main
{
    public static void main(String[] args)
    {
        Amoozesh amoozesh = new Amoozesh("ali");
        amoozesh.makeSemester("400" , 23);
        amoozesh.makeFaculty("riazi" , 223);
        amoozesh.addCourseToSemester(23,new Course("pizza pazi" , "pizaeean" , Faculty.getFaculty(223) , 1234 , 3  ));
        amoozesh.addCourseToSemester(23,new Course("agha" , "baba" , Faculty.getFaculty(223) , 12345 , 12));
        System.out.println(Amoozesh.isAmoozeshMade);
        amoozesh.makeStudent("ali" , "akar" , 1000 , "cs" , Faculty.getFaculty(223) ,1400 , 15 );
        Objects.requireNonNull(Student.getStudent(1000)).addCourse(Course.getCourse(23 , 1234));
        Objects.requireNonNull(Student.getStudent(1000)).printCoursesOfStudent(1000);
        Objects.requireNonNull(Semester.getSemester(23)).printCoursesInSemester(23);




    }


}
