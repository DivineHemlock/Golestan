import Amoozesh.Amoozesh;
import Amoozesh.Semester;
import Amoozesh.Faculty;
import Amoozesh.Course;
import Professor.Professor;
import Amoozesh.Student;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// note: add courses to semester and professor using only the addCourseToSemesterAndProfessor from the amoozesh class

public class Main
{
    public static void main(String[] args)
     {
        //temp statements
        if (!Amoozesh.isAmoozeshMade)
        {
            Amoozesh.makeAmoozesh("admin", "1234");
        }
        Amoozesh.getAmoozesh().makeFaculty("math" , 1);
        Amoozesh.getAmoozesh().makeStudent("mohsen" , "ansari" , 400 , "cs" , Faculty.getFaculty(1) , 1400 , 18);
        Amoozesh.getAmoozesh().makeStudent("mehdi" , "ahmadi" , 401 , "cs" , Faculty.getFaculty(1) , 1400 , 18);
        Amoozesh.getAmoozesh().makeFaculty("ce" , 2);
        Amoozesh.getAmoozesh().makeSemester("1400"  , 14001);
        Amoozesh.getAmoozesh().makeProfessor("iman" , "kherad" , Faculty.getFaculty(1) , "cs" , "1234");
        Amoozesh.getAmoozesh().addCourseToSemesterAndProfessor(14001,new Course("cns" , "iman" , Faculty.getFaculty(1) , 1 , 3),"iman" , "kherad");
        Amoozesh.getAmoozesh().addCourseToSemesterAndProfessor(14001,new Course("bp","iman" , Faculty.getFaculty(1) , 0 , 0),"iman" , "kherad");
        Amoozesh.getAmoozesh().addCourseToSemesterAndProfessor(14001, new Course("ap" , "iman" , Faculty.getFaculty(1), 2 , 3) ,"iman" , "kherad" );
        Objects.requireNonNull(Student.getStudent(400)).addCourse(Course.getCourse(14001,1));
        Objects.requireNonNull(Student.getStudent(401)).addCourse(Course.getCourse(14001, 1));
         //end of temp statements
        while (true) // main program loop , breaks when the program ends
        {
            System.out.println("welcome to the educational system");
            System.out.println("please enter the digit for the desired function :");
            System.out.println("1-login \n2-sign up \n3-quit");
            Scanner input = new Scanner(System.in);
            while (true) // getting the choice while
            {
                boolean goingBackToMainMenu = false;
                int choice = input.nextInt();
                boolean isChoiceValid = false;
                switch (choice)
                {
                    case 1:
                        loginFunction();
                        isChoiceValid = true;
                        break;
                    case 2:
                        //signupFunction();
                        isChoiceValid = true;
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        break;
                }
                if (isChoiceValid)
                {
                    break;
                }
                else
                {
                    System.out.println("invalid input try again : ");
                    continue;
                }

            }

        }
    }

    public static void loginFunction()
    {
        System.out.println("enter your class : \n1-amoozesh  \n2-professor \n3-student");
        Scanner loginFunctionScanner = new Scanner(System.in);
        boolean isChoiceValid = false;
        while(true)
        {
            int temp = loginFunctionScanner.nextInt();
            switch (temp)
            {
                case 1 :
                    if (Amoozesh.isAmoozeshMade)
                    {
                        amoozeshLoginFunction();
                        isChoiceValid = true;
                    }
                    else
                    {
                        System.out.println("there is no amoozesh account made !");
                        System.out.println("going back to the main menu...");
                        isChoiceValid = true;
                    }
                break;
                case 2 :
                    if (Amoozesh.isAmoozeshMade && !Amoozesh.professors.isEmpty())
                    {
                        professorLoginFunction();
                        isChoiceValid = true;
                    }
                    else
                    {
                        System.out.println("there is no professor account made !");
                        System.out.println("going back to the main menu...");
                        isChoiceValid = true;
                    }
                break;
                case 3 :
                    //studentLoginFunction();
                    isChoiceValid = true;
                break;
                default:
                break;
            }
            if (isChoiceValid)
            {
                break;
            }
            else
            {
                System.out.println("invalid input try again");
                continue;
            }
        }
    }

    public static void amoozeshLoginFunction()
    {
        while (true)
        {
            System.out.println("enter your account name :");
            Scanner amoozeshLoginFunctionScanner = new Scanner(System.in);
            String tempName = amoozeshLoginFunctionScanner.next();
            System.out.println("enter your password :");
            String tempPassword = amoozeshLoginFunctionScanner.next();
            if (Amoozesh.getAmoozesh().getName().equals(tempName) && Amoozesh.getAmoozesh().getPassword().equals(tempPassword))
            {
                System.out.println("login successful ! enter your statement : ");
                while (true)
                {
                    System.out.println("1-make faculty \n2-new semester \n3-new course \n4-edit \n5-quit");
                    int temp = amoozeshLoginFunctionScanner.nextInt();
                    boolean goBackToAmoozeshLoginFunction = false;
                    while (true)
                    {
                        int choice;
                        switch (temp)
                        {
                            case 1:
                                System.out.println("enter the faculty name :");
                                String tempFacultyName = amoozeshLoginFunctionScanner.next();
                                System.out.println("enter faculty ID (number)");
                                int tempFacultyID = amoozeshLoginFunctionScanner.nextInt();
                                Amoozesh.getAmoozesh().makeFaculty(tempFacultyName, tempFacultyID);
                                System.out.println("done !");
                                System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                choice = amoozeshLoginFunctionScanner.nextInt();
                                if (choice == 1)
                                {
                                    goBackToAmoozeshLoginFunction = true;
                                }
                                else
                                {
                                    return ;
                                }
                                break;
                            case 2:
                                System.out.println("enter semester name :");
                                String tempSemesterName = amoozeshLoginFunctionScanner.next();
                                System.out.println("enter semester ID");
                                int tempSemesterID = amoozeshLoginFunctionScanner.nextInt();
                                Amoozesh.getAmoozesh().makeSemester(tempSemesterName, tempSemesterID);
                                System.out.println("done !");
                                System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                choice = amoozeshLoginFunctionScanner.nextInt();
                                if (choice == 1)
                                {
                                    goBackToAmoozeshLoginFunction = true;
                                }
                                else
                                {
                                    return ;
                                }
                                break;
                            case 3:
                                System.out.println("enter semester ID :");
                                tempSemesterID = amoozeshLoginFunctionScanner.nextInt();
                                if (Semester.getSemester(tempSemesterID) != null)
                                {   System.out.println("enter professor name :");
                                    String tempProfessorName = amoozeshLoginFunctionScanner.next();
                                    System.out.println("enter professor last name :");
                                    String tempProfessorLastName = amoozeshLoginFunctionScanner.next();
                                    System.out.println("enter the course name :");
                                    String tempCourseName = amoozeshLoginFunctionScanner.next();
                                    System.out.println("enter the course faculty ID :");
                                    int tempCourseFacultyID = amoozeshLoginFunctionScanner.nextInt();
                                    System.out.println("enter the course ID :");
                                    int tempCourseID = amoozeshLoginFunctionScanner.nextInt();
                                    System.out.println("enter the course units :");
                                    int tempCourseUnits = amoozeshLoginFunctionScanner.nextInt();
                                    Amoozesh.getAmoozesh().addCourseToSemesterAndProfessor(tempSemesterID, new Course(tempCourseName, tempProfessorName, Faculty.getFaculty(tempCourseFacultyID), tempCourseID, tempCourseUnits), tempProfessorName, tempProfessorLastName);
                                    System.out.println("done !");
                                    System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                    choice = amoozeshLoginFunctionScanner.nextInt();
                                    if (choice == 1)
                                    {
                                        goBackToAmoozeshLoginFunction = true;
                                    }
                                    else
                                    {
                                        return ;
                                    }
                                }
                                System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                choice = amoozeshLoginFunctionScanner.nextInt();
                                if (choice == 1)
                                {
                                    goBackToAmoozeshLoginFunction = true;
                                }
                                else
                                {
                                    return ;
                                }
                                break;
                            case 4:
                                amoozeshEditFunction();
                                System.out.println("done !");
                                System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                choice = amoozeshLoginFunctionScanner.nextInt();
                                if (choice == 1)
                                {
                                    goBackToAmoozeshLoginFunction = true;
                                }
                                else
                                {
                                    return ;
                                }
                                break;
                            case 5:
                                System.exit(0);
                                break;
                        }
                        if (goBackToAmoozeshLoginFunction)
                        {
                            break;
                        }
                    }
                }
            }
            else
            {
                System.out.println("invalid input enter 1 to go back to main menu or enter any other integer to try again : ");
                int choice = amoozeshLoginFunctionScanner.nextInt();
                if (choice == 1)
                {
                    return ;
                }
                else
                {
                    continue;
                }
            }
        }
    }

    public static void amoozeshEditFunction()
    {
        Scanner amoozeshEditFunctionScanner = new Scanner(System.in);
        System.out.println("what do you want to edit ?");
        System.out.println("1-amoozesh name \n2-amoozesh password \n3-faculty \n4-student");
        System.out.println("5-semester \n6-professor ");
        int tempInt = amoozeshEditFunctionScanner.nextInt();
        String tempString;
        switch (tempInt)
        {
            case 1:
                System.out.println("enter your new name : ");
                tempString = amoozeshEditFunctionScanner.next();
                Amoozesh.getAmoozesh().setName(tempString);
                break;
            case 2:
                System.out.println("enter your new password :");
                tempString = amoozeshEditFunctionScanner.next();
                Amoozesh.getAmoozesh().setPassword(tempString);
                break;
            case 3:
                System.out.println("what do you want to edit ?");
                System.out.println("1-faculty name \n2-faculty ID");
                tempInt = amoozeshEditFunctionScanner.nextInt();
                if (tempInt == 1)
                {
                    System.out.println("enter the  old faculty name :");
                    tempString = amoozeshEditFunctionScanner.next();
                    for (Faculty fc : Amoozesh.getFaculties())
                    {
                        if (fc.getName().equals(tempString))
                        {
                            System.out.println("enter the new faculty name : ");
                            tempString = amoozeshEditFunctionScanner.next();
                            fc.setName(tempString);
                            return;
                        }
                    }
                    System.out.println("no faculty with this name exists !");
                    break;
                }
                else
                {
                    System.out.println("enter the old faculty ID");
                    tempInt = amoozeshEditFunctionScanner.nextInt();
                    if (Faculty.getFaculty(tempInt) != null)
                    {
                        System.out.println("enter the new faculty ID");
                        int tempInt_2 = amoozeshEditFunctionScanner.nextInt();
                        Objects.requireNonNull(Faculty.getFaculty(tempInt)).setFacultyID(tempInt_2);
                        return;
                    }
                    else
                    {
                        System.out.println("no faculty with this ID exists !");
                    }
                }
                break;
            case 4:
                System.out.println("what do you want to edit?");
                System.out.println("1-student name \n2-student last name \n3-student ID \n4-student major \n5-student faculty ");
                System.out.println("6-year of entry \n7-gpa \n8-student courses");
                tempInt = amoozeshEditFunctionScanner.nextInt();
                switch (tempInt)
                {
                    case 1:
                        System.out.println("enter the student ID");
                        tempInt = amoozeshEditFunctionScanner.nextInt();
                        if (Student.getStudent(tempInt) != null)
                        {
                            System.out.println("enter the new student name :");
                            tempString = amoozeshEditFunctionScanner.next();
                            Objects.requireNonNull(Student.getStudent(tempInt)).setName(tempString);
                        }
                        break;
                    case 2:
                        System.out.println("enter the student ID");
                        tempInt = amoozeshEditFunctionScanner.nextInt();
                        if (Student.getStudent(tempInt) != null)
                        {
                            System.out.println("enter the new student last name : ");
                            tempString = amoozeshEditFunctionScanner.next();
                            Objects.requireNonNull(Student.getStudent(tempInt)).setLastName(tempString);
                        }
                        break;
                    case 3:
                        System.out.println("enter the student old ID");
                        tempInt = amoozeshEditFunctionScanner.nextInt();
                        if (Student.getStudent(tempInt) != null)
                        {
                            System.out.println("enter the new student ID");
                            int tempInt_2 = amoozeshEditFunctionScanner.nextInt();
                            Objects.requireNonNull(Student.getStudent(tempInt)).setStudentID(tempInt_2);
                        }
                        break;
                    case 4:
                        System.out.println("enter the student ID");
                        tempInt = amoozeshEditFunctionScanner.nextInt();
                        if (Student.getStudent(tempInt) != null)
                        {
                            System.out.println("enter the new student major :");
                            tempString = amoozeshEditFunctionScanner.next();
                            Objects.requireNonNull(Student.getStudent(tempInt)).setMajor(tempString);
                        }
                        break;
                    case 5:
                        System.out.println("enter the student ID");
                        int tempStudentID = amoozeshEditFunctionScanner.nextInt();
                        if (Student.getStudent(tempStudentID) != null)
                        {
                            System.out.println("enter the new student faculty ID:");
                            int newFacultyID = amoozeshEditFunctionScanner.nextInt();
                            if (Faculty.getFaculty(newFacultyID) != null)
                            {
                                (Objects.requireNonNull(Student.getStudent(tempStudentID))).setFaculty(Faculty.getFaculty(newFacultyID));
                            }
                        }
                        break;
                    case 6:
                        System.out.println("enter the student ID");
                        tempStudentID = amoozeshEditFunctionScanner.nextInt();
                        if (Student.getStudent(tempStudentID) != null)
                        {
                            System.out.println("enter the new student year of entry :");
                            tempInt = amoozeshEditFunctionScanner.nextInt();
                            Objects.requireNonNull(Student.getStudent(tempStudentID)).setYearOfEntry(tempInt);
                        }
                        break;
                    case 7:
                        System.out.println("enter the student ID");
                        tempStudentID = amoozeshEditFunctionScanner.nextInt();
                        if (Student.getStudent(tempStudentID) != null)
                        {
                            System.out.println("enter the new student gpa , gpa should be between 0.0 to 20.0 :");
                            double tempDouble;
                            while (true)
                            {
                                tempDouble = amoozeshEditFunctionScanner.nextInt();
                                if (tempDouble >= 0.0 && tempDouble <= 20.0)
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("invalid input , gpa should be between 0.0 to 20.0 , try again :");
                                }
                            }
                            Objects.requireNonNull(Student.getStudent(tempStudentID)).setGPA(tempDouble);
                            System.out.println(Objects.requireNonNull(Student.getStudent(tempStudentID)).getGPA());
                        }
                        break;
                    case 8:
                        System.out.println("enter the student ID :");
                        tempStudentID = amoozeshEditFunctionScanner.nextInt();
                        if (Student.getStudent(tempStudentID) != null)
                        {
                            System.out.println("what do you want to do?");
                            System.out.println("1-add course \n2-remove course \n3-set course score");
                            int choice = amoozeshEditFunctionScanner.nextInt();
                            switch (choice)
                            {
                                case 1:
                                    System.out.println("enter the course semesters ID :");
                                    int tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                                    System.out.println("enter the course ID :");
                                    int tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                    if (Course.getCourse(tempSemesterID,tempCourseID) != null)
                                    {
                                        Objects.requireNonNull(Student.getStudent(tempStudentID)).addCourse(Course.getCourse(tempSemesterID,tempCourseID));
                                    }
                                    break;
                                case 2:
                                    System.out.println("enter the course semester ID :");
                                    tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                                    System.out.println("enter the course ID :");
                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                    if (Course.getCourse(tempSemesterID,tempCourseID) != null)
                                    {
                                        Objects.requireNonNull(Student.getStudent(tempStudentID)).removeCourse(Course.getCourse(tempSemesterID,tempCourseID));
                                    }
                                    break;
                                case 3:
                                    System.out.println("enter the course semester ID :");
                                    tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                                    System.out.println("enter the course ID :");
                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                    double tempScore;
                                    if (Objects.requireNonNull(Student.getStudent(tempStudentID)).getStudentCourse(tempSemesterID,tempCourseID) != null)
                                    {
                                        System.out.println("enter the course score , score should be between 0.0 and 20.0 :");
                                        while (true)
                                        {
                                            tempScore = amoozeshEditFunctionScanner.nextDouble();
                                            if (tempScore >= 0.0 && tempScore <= 20.0)
                                            {
                                                break;
                                            }
                                            else
                                            {
                                                System.out.println("invalid score , enter a score between 0.0 and 20.0 :");
                                            }
                                        }
                                        for (Course crs : Objects.requireNonNull(Student.getStudent(tempStudentID)).getCourses())
                                        {
                                            if (Course.isEqual(crs , Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID))))
                                            {
                                                crs.setScore(tempScore);
                                            }
                                        }

                                    }
                                    break;

                            }
                        }

                        break;

                }
                break;
            case 5: // editing semester
                System.out.println("what do you want to edit ?");
                System.out.println("1-semester name \n2-semester ID \n3-semester courses");
                tempInt = amoozeshEditFunctionScanner.nextInt();
                switch (tempInt)
                {
                    case 1:
                        System.out.println("enter the semester ID");
                        int tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                        if (Semester.getSemester(tempSemesterID) != null)
                        {
                            System.out.println("enter the new semester name :");
                            tempString = amoozeshEditFunctionScanner.next();
                            Objects.requireNonNull(Semester.getSemester(tempSemesterID)).setName(tempString);
                        }
                    break;
                    case 2:
                        System.out.println("enter the old semester ID");
                        tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                        if (Semester.getSemester(tempSemesterID) != null)
                        {
                            System.out.println("enter the new semester ID :");
                            tempInt = amoozeshEditFunctionScanner.nextInt();
                            Objects.requireNonNull(Semester.getSemester(tempSemesterID)).setSemesterID(tempInt);
                        }
                    break;
                    case 3:
                        System.out.println("enter the semester ID");
                        tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                        if (Semester.getSemester(tempSemesterID) != null)
                        {
                            System.out.println("what do you want to edit ?");
                            System.out.println("1-course name \n2-course professor name \n3-course faculty \n4-course ID \n5-units");
                            int choice = amoozeshEditFunctionScanner.nextInt();
                            switch (choice)
                            {
                                case 1:
                                    System.out.println("enter the course ID");
                                    int tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                    if (Course.getCourse(tempSemesterID , tempCourseID) != null)
                                    {
                                        System.out.println("enter the new course name :");
                                        tempString = amoozeshEditFunctionScanner.next();
                                        Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setName(tempString);
                                    }
                                break;
                                case 2:
                                    System.out.println("enter the course ID");
                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                    if (Course.getCourse(tempSemesterID , tempCourseID) != null)
                                    {
                                        System.out.println("enter the new course professor name :");
                                        tempString = amoozeshEditFunctionScanner.next();
                                        Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setProfessorName(tempString);
                                    }
                                break;
                                case 3:
                                    System.out.println("enter the course ID :");
                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                    if (Course.getCourse(tempSemesterID,tempCourseID) != null)
                                    {
                                        System.out.println("enter the new course faculty ID :");
                                        tempInt = amoozeshEditFunctionScanner.nextInt();
                                        Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setFaculty(Faculty.getFaculty(tempInt));
                                    }
                                break;
                                case 4:
                                    System.out.println("enter the old course ID :");
                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                    if (Course.getCourse(tempSemesterID,tempCourseID) != null)
                                    {
                                        System.out.println("enter the new course ID :");
                                        tempInt = amoozeshEditFunctionScanner.nextInt();
                                        Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setCourseID(tempInt);
                                    }
                                break;
                                case 5:
                                    System.out.println("enter the course ID :");
                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                    if (Course.getCourse(tempSemesterID,tempCourseID) != null)
                                    {
                                        System.out.println("enter the new course units :");
                                        tempInt = amoozeshEditFunctionScanner.nextInt();
                                        Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setUnits(tempInt);
                                    }
                                break;
                            }
                        }
                    break;

                }
            break;
            case 6: // editing the professor
                System.out.println("what do you want to edit ? ");
                System.out.println("1-professor name \n2-professor last name \n3-professor faculty \n4-professor group");
                System.out.println("5-remove professor courses");
                int choice = amoozeshEditFunctionScanner.nextInt();
                switch (choice)
                {
                    case 1:
                        System.out.println("enter professors old first name : ");
                        String tempFirstName = amoozeshEditFunctionScanner.next();
                        System.out.println("enter professors last name :  ");
                        String tempLastName = amoozeshEditFunctionScanner.next();
                        if (Professor.getProfessor(tempFirstName,tempLastName) != null)
                        {
                            System.out.println("enter the professors new name :");
                            String tempNewFirstName = amoozeshEditFunctionScanner.next();
                            Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).setName(tempNewFirstName);
                        }
                    break;
                    case 2:
                        System.out.println("enter professors first name : ");
                        tempFirstName = amoozeshEditFunctionScanner.next();
                        System.out.println("enter professors old last name :  ");
                        tempLastName = amoozeshEditFunctionScanner.next();
                        if (Professor.getProfessor(tempFirstName,tempLastName) != null)
                        {
                            System.out.println("enter the professors new last name :");
                            String tempNewLastName = amoozeshEditFunctionScanner.next();
                            Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).setLastName(tempNewLastName);
                        }
                    break;
                    case 3:
                        System.out.println("enter professors first name : ");
                        tempFirstName = amoozeshEditFunctionScanner.next();
                        System.out.println("enter professors last name :  ");
                        tempLastName = amoozeshEditFunctionScanner.next();
                        if (Professor.getProfessor(tempFirstName,tempLastName) != null)
                        {
                            System.out.println("enter the new faculty ID :");
                            int tempFacultyID = amoozeshEditFunctionScanner.nextInt();
                            Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).setFaculty(Faculty.getFaculty(tempFacultyID));
                        }
                    break;
                    case 4:
                        System.out.println("enter professors first name : ");
                        tempFirstName = amoozeshEditFunctionScanner.next();
                        System.out.println("enter professors last name :  ");
                        tempLastName = amoozeshEditFunctionScanner.next();
                        if (Professor.getProfessor(tempFirstName,tempLastName) != null)
                        {
                            System.out.println("enter the new group name :");
                            String tempGroupName = amoozeshEditFunctionScanner.next();
                            Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).setGroup(tempGroupName);
                        }
                    break;
                    case 5:
                        System.out.println("note : you can only remove courses from here , to add courses , go to : main menu > login > amoozesh > enter your user and password and select new course.");
                        System.out.println("enter professors first name : ");
                        tempFirstName = amoozeshEditFunctionScanner.next();
                        System.out.println("enter professors last name :  ");
                        tempLastName = amoozeshEditFunctionScanner.next();
                        if (Professor.getProfessor(tempFirstName,tempLastName) != null)
                        {
                            System.out.println("enter the course semesters ID :");
                            int tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                            System.out.println("enter the course ID :");
                            int tempCourseID = amoozeshEditFunctionScanner.nextInt();
                            Amoozesh.getAmoozesh().removeCourseFromSemesterAndProfessor(tempSemesterID , Course.getCourse(tempSemesterID,tempCourseID) , tempFirstName , tempLastName);
                            System.out.println("the current professor courses are : ");
                            Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).printCourses(Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)));
                        }
                    break;
                }
            break;
        }
    }

    public static void professorLoginFunction()
    {
        while (true)
        {
            ArrayList<Integer> tempArrayOfStudentID = new ArrayList<>();
            boolean doesAnyStudentHaveThisClass = false;
            Scanner professorLoginFunctionScanner = new Scanner(System.in);
            System.out.println("enter your first name :");
            String tempFirstName = professorLoginFunctionScanner.next();
            System.out.println("enter your last name :");
            String tempLastName = professorLoginFunctionScanner.next();
            System.out.println("enter your password :");
            String tempPassword = professorLoginFunctionScanner.next();
            for (Professor prof : Amoozesh.professors) {
                if (prof.getName().equals(tempFirstName) && prof.getLastName().equals(tempLastName) && prof.getPassword().equals(tempPassword)) {
                    System.out.println("login successful ! ");
                    while (true)
                    {
                        System.out.println("here is your class list : ");
                        Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).printCourses(Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)));
                        System.out.println("enter the name of a course to see all of the students in that course or enter \"none\" to go back to main menu :");
                        String tempCourseName = professorLoginFunctionScanner.next();
                        if (tempCourseName.equals("none"))
                        {
                            return;
                        }
                        for (Student std : Amoozesh.getStudents())
                        {
                            for (Course crs : std.getCourses())
                            {
                                if (crs.getName().equals(tempCourseName))
                                {
                                    doesAnyStudentHaveThisClass = true;
                                    System.out.println(std.getName() + "  " + std.getStudentID());
                                    tempArrayOfStudentID.add(std.getStudentID());
                                }
                            }
                        }
                        if (!doesAnyStudentHaveThisClass)
                        {
                            System.out.println("either no student is currently enrolled in this course or this course is not in your course list !");
                            System.out.println("going back to course list...");
                            continue;
                        }
                        int tempStudentID;
                        while (true)
                        {
                            System.out.println("enter the ID of the student which you would like to set the score for :");
                            tempStudentID = professorLoginFunctionScanner.nextInt();
                            if (tempArrayOfStudentID.contains(tempStudentID))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("this ID doesnt exist in this list ! , try again :");
                            }
                            // what if the ID is wrong?
                        }
                        System.out.println("enter a score between 0.0 and 20.0 :");
                        double tempScore;
                        while (true)
                        {
                            tempScore = professorLoginFunctionScanner.nextDouble();
                            if (tempScore >= 0.0 && tempScore <= 20.0)
                            {
                                break;
                            } else
                            {
                                System.out.println("invalid score , try again :");
                            }
                        }
                        for (Student std : Amoozesh.students) {
                            if (std.getStudentID() == tempStudentID)
                            {
                                for (Course crs : std.getCourses())
                                {
                                    if (crs.getName().equals(tempCourseName))
                                    {
                                        crs.setScore(tempScore);
                                    }
                                }
                            }
                        }
                        System.out.println("done !");
                        System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                        int choice = professorLoginFunctionScanner.nextInt();
                        if (choice != 1)
                        {
                            return;
                        }
                    }
                }
            }
            System.out.println("no such professor has been registered !");
            System.out.println("going back to main menu...");
            return;
        }
    }






}
// todo : add default case for switches ( so if we enter an invalid number we get an error )

//todo : remove redundant packages

// todo : input validation

// todo : add input validation for cases where an object is being duplicated in amoozeshLoginFunction

// todo : bug fix : when changing a name or string , spaces will ruin the input : if we enter ali reza , only ali will be input
