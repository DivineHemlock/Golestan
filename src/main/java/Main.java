import Amoozesh.Amoozesh;
import Amoozesh.Semester;
import Amoozesh.Faculty;
import Amoozesh.Course;
import Professor.Professor;
import Student.Student;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
     {
        //temp statements
        Amoozesh.makeAmoozesh("admin" , "1234");
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
                    }
                    break;
                case 2 :
                    //professorLoginFunction();
                    isChoiceValid = true;
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

    public static int amoozeshLoginFunction() // if the func returns 1 , we should go back to main menu
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
                    System.out.println("1-make faculty \n2-new semester \n3-new course \n4-quit");
                    int temp = amoozeshLoginFunctionScanner.nextInt();
                    boolean goBackToMainMenu = false;
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
                                    goBackToMainMenu = true;
                                    return 1;
                                }
                                break;
                            case 2:
                                System.out.println("enter semester name :");
                                String tempSemesterName = amoozeshLoginFunctionScanner.next();
                                System.out.println("enter semester ID");
                                int tempSemesterID = amoozeshLoginFunctionScanner.nextInt();
                                if(Semester.getSemester(tempSemesterID) == null)
                                {

                                }
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
                                    goBackToMainMenu = true;
                                    return 1;
                                }
                                break;
                            case 3:
                                System.out.println("enter semester ID :");
                                tempSemesterID = amoozeshLoginFunctionScanner.nextInt();
                                System.out.println("enter professor name :");
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
                                    goBackToMainMenu = true;
                                    return 1;
                                }
                                break;
                            case 4:
                                System.exit(0);
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
                System.out.println("invalid input try again or enter 1 to go back to main menu : ");
                int choice = amoozeshLoginFunctionScanner.nextInt();
                if (choice == 1)
                {
                    return 1;
                }
                else
                {
                    continue;
                }
            }
        }
    }








}
//todo : remove redundant packages

// todo : go back to main menu in amoozeshLoginFunction
