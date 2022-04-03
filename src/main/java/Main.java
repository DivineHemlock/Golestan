import Amoozesh.Amoozesh;
import Amoozesh.Semester;
import Amoozesh.Faculty;
import Amoozesh.Course;
import Professor.Professor;
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
        amoozesh.makeStudent("ali" , "akar" , 1000 , "cs" , Faculty.getFaculty(223) ,1400 , 15 );
        System.out.println(Student.getStudent(1000).getName());
        amoozesh.makeProfessor("reza" , "kheradpishe" , Faculty.getFaculty(223) , "cs");
        amoozesh.addCourseToSemesterAndProfessor(23 , new Course("ap" , "dr.kheradpishe" , Faculty.getFaculty(223) , 122333 , 3) , "reza" ,"kheradpishe");
        Student.getStudent(1000).addCourse(Course.getCourse(23 , 122333));
        Professor.printStudentsInCourse(Professor.getProfessor("reza" , "kheradpishe") , Semester.getSemester(23) , Course.getCourse(23 ,122333));
        Semester.getSemester(23).printCoursesInSemester(23);






    }


}
