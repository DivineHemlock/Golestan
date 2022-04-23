import Amoozesh.Amoozesh;
import Amoozesh.Semester;
import Amoozesh.Faculty;
import Amoozesh.Course;
import Amoozesh.Professor;
import Amoozesh.Student;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// note: add courses to semester and professor using only the addCourseToSemesterAndProfessor from the amoozesh class

public class Main
{
    public static void main(String[] args)
     {
        while (true) // main program loop , breaks when the program ends
        {
            System.out.println("welcome to the educational system");
            System.out.println("please enter the digit for the desired function :");
            System.out.println("1-login \n2-sign up \n3-quit");
            Scanner input = new Scanner(System.in);
            while (true) // getting the choice while
            {
                boolean goingBackToMainMenu = false;
                String  choice = input.next();
                boolean isChoiceValid = false;
                switch (choice)
                {
                    case "1":
                        loginFunction();
                        isChoiceValid = true;
                    break;
                    case "2":
                        signupFunction();
                        isChoiceValid = true;
                    break;
                    case "3":
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
        System.out.println("enter your class : \n1-amoozesh  \n2-professor \n3-student \n4-return to main menu");
        Scanner loginFunctionScanner = new Scanner(System.in);
        while(true)
        {
            String  temp = loginFunctionScanner.next();
            switch (temp)
            {
                case "1" :
                    if (Amoozesh.isAmoozeshMade)
                    {
                        amoozeshLoginFunction();
                    }
                    else
                    {
                        System.out.println("there is no amoozesh account made !");
                        System.out.println("going back to the main menu...");
                    }
                break;
                case "2" :
                    if (Amoozesh.isAmoozeshMade && !Amoozesh.professors.isEmpty())
                    {
                        professorLoginFunction();
                    }
                    else
                    {
                        System.out.println("there is no professor account made !");
                        System.out.println("going back to the main menu...");
                    }
                break;
                case "3" :
                    if (Amoozesh.isAmoozeshMade && !Amoozesh.students.isEmpty())
                    {
                        studentLoginFunction();
                    }
                    else
                    {
                        System.out.println("there is no student account made !");
                        System.out.println("going back to the main menu...");
                    }
                break;
                case "4":
                return;
                default:
                    System.out.println("invalid input try again");
                break;
            }
            break;

        }
    }

    public static void amoozeshLoginFunction()
    {
        while (true)
        {
            boolean exceptionFlag = false;
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
                    String temp = amoozeshLoginFunctionScanner.next();
                    while (true)
                    {
                        String choice;
                        switch (temp)
                        {
                            case "1":
                                System.out.println("enter the faculty name :");
                                String tempFacultyName = amoozeshLoginFunctionScanner.next();
                                int tempFacultyID = 0;
                                while (true)
                                {
                                    System.out.println("enter faculty ID (number)");
                                    try {
                                        tempFacultyID = amoozeshLoginFunctionScanner.nextInt();
                                    }
                                    catch (Exception e)
                                    {
                                        amoozeshLoginFunctionScanner.next();
                                        System.out.println("invalid input type , returning to your account...");
                                        exceptionFlag = true;
                                        break;
                                    }
                                    if (Amoozesh.faculties.contains(Faculty.getFaculty(tempFacultyID)))
                                    {
                                        System.out.println("a faculty with this ID already exists! you cant create duplicate faculties!");
                                        System.out.println("enter 1 to try another ID or enter anything else to return to main menu:");
                                        String choice_2 = amoozeshLoginFunctionScanner.next();
                                        if (!choice_2.equals("1"))
                                        {
                                            return;
                                        }
                                    }
                                    else
                                    {
                                        break;
                                    }
                                }
                                if (exceptionFlag)
                                {
                                    break;
                                }
                                Amoozesh.getAmoozesh().makeFaculty(tempFacultyName, tempFacultyID);
                                System.out.println("done !");
                                System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                choice = amoozeshLoginFunctionScanner.next();
                                if (!choice.equals("1"))
                                {
                                    return;
                                }
                            break;
                            case "2":
                                System.out.println("enter semester name :");
                                String tempSemesterName = amoozeshLoginFunctionScanner.next();
                                int tempSemesterID = 0;
                                while (true)
                                {
                                    System.out.println("enter semester ID");
                                    try {
                                        tempSemesterID = amoozeshLoginFunctionScanner.nextInt();
                                    }
                                    catch (Exception e)
                                    {
                                        amoozeshLoginFunctionScanner.next();
                                        System.out.println("invalid input type , returning to your account...");
                                        exceptionFlag = true;
                                        break;
                                    }
                                    if (Amoozesh.semesters.contains(Semester.getSemester(tempSemesterID)))
                                    {
                                        System.out.println("a semester with this ID already exists! you cant create duplicate semesters!");
                                        System.out.println("enter 1 to try another ID or enter anything else to go back to main menu:");
                                        choice = amoozeshLoginFunctionScanner.next();
                                        if (!choice.equals("1"))
                                        {
                                            return;
                                        }
                                    }
                                    else
                                    {
                                        break;
                                    }
                                }
                                if (exceptionFlag)
                                {
                                    break;
                                }
                                Amoozesh.getAmoozesh().makeSemester(tempSemesterName, tempSemesterID);
                                System.out.println("done !");
                                System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                choice = amoozeshLoginFunctionScanner.next();
                                if (!choice.equals("1"))
                                {
                                    return;
                                }
                            break;
                            case "3":
                                if (!Amoozesh.semesters.isEmpty())
                                {
                                    System.out.println("enter semester ID :");
                                    try {
                                        tempSemesterID = amoozeshLoginFunctionScanner.nextInt();
                                    }
                                    catch (Exception e)
                                    {
                                        amoozeshLoginFunctionScanner.next();
                                        System.out.println("invalid input type , returning to your account...");
                                        exceptionFlag = true;
                                        break;
                                    }
                                    if (Semester.getSemester(tempSemesterID) != null) {
                                        System.out.println("enter professor name :");
                                        String tempProfessorName = amoozeshLoginFunctionScanner.next();
                                        System.out.println("enter professor last name :");
                                        String tempProfessorLastName = amoozeshLoginFunctionScanner.next();
                                        System.out.println("enter the course name :");
                                        String tempCourseName = amoozeshLoginFunctionScanner.next();
                                        System.out.println("enter the course faculty ID :");
                                        int tempCourseFacultyID;
                                        try {
                                            tempCourseFacultyID = amoozeshLoginFunctionScanner.nextInt();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshLoginFunctionScanner.next();
                                            System.out.println("invalid input type , returning to your account...");
                                            exceptionFlag = true;
                                            break;
                                        }
                                        int tempCourseID = 0;
                                        while (true)
                                        {
                                            System.out.println("enter the course ID :");
                                            try {
                                                tempCourseID = amoozeshLoginFunctionScanner.nextInt();
                                            }
                                            catch (Exception e)
                                            {
                                                amoozeshLoginFunctionScanner.next();
                                                System.out.println("invalid input type , returning to your account...");
                                                exceptionFlag = true;
                                                break;
                                            }
                                            if (Objects.requireNonNull(Semester.getSemester(tempSemesterID)).getCourses().contains(Course.getCourse(tempSemesterID,tempCourseID)))
                                            {
                                                System.out.println("this course already exists!");
                                                System.out.println("enter 1 to try again or enter any other thing to go back to main menu : ");
                                                choice = amoozeshLoginFunctionScanner.next();
                                                if (!choice.equals("1"))
                                                {
                                                    return;
                                                }
                                            }
                                            else
                                            {
                                                break;
                                            }
                                        }
                                        if (exceptionFlag)
                                        {
                                            break;
                                        }
                                        System.out.println("enter the course units :");
                                        int tempCourseUnits = 0;
                                        try{
                                            tempCourseUnits = amoozeshLoginFunctionScanner.nextInt();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshLoginFunctionScanner.next();
                                            System.out.println("invalid input type , returning to your account...");
                                            exceptionFlag = true;
                                            break;
                                        }
                                        Amoozesh.getAmoozesh().addCourseToSemesterAndProfessor(tempSemesterID, new Course(tempCourseName, tempProfessorName, Faculty.getFaculty(tempCourseFacultyID), tempCourseID, tempCourseUnits), tempProfessorName, tempProfessorLastName);
                                        System.out.println("done !");
                                        System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                        choice = amoozeshLoginFunctionScanner.next();
                                        if (!choice.equals("1")) {
                                            return;
                                        }
                                    }
                                    System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                    choice = amoozeshLoginFunctionScanner.next();
                                    if (!choice.equals("1")) {
                                        return;
                                    }
                                }
                                else
                                {
                                    System.out.println("no semester exists! , to make a course you need to make at least one semester !");
                                }
                            break;
                            case "4":
                                amoozeshEditFunction();
                                System.out.println("done !");
                                System.out.println("enter 1 to stay in your account , enter any other integer to go back to main menu :");
                                choice = amoozeshLoginFunctionScanner.next();
                                if (!choice.equals("1"))
                                {
                                    return;
                                }
                                break;
                            case "5":
                                System.exit(0);
                            break;
                            default:
                                System.out.println("invalid input ! try again : ");
                            break;
                        }
                        break;
                    }
                }
            }
            else
            {
                System.out.println("invalid input enter 1 to go back to main menu or enter any other thing to try again : ");
                String choice = amoozeshLoginFunctionScanner.next();
                if (choice.equals("1"))
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
        int tempInt = 0;
        try {
            tempInt = amoozeshEditFunctionScanner.nextInt();
        }
        catch (Exception e)
        {
            amoozeshEditFunctionScanner.next();
            System.out.println("invalid input type !");
            return;
        }
        String tempString;
        while (true) {
            switch (tempInt) {
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
                    try {
                        tempInt = amoozeshEditFunctionScanner.nextInt();
                    }
                    catch (Exception e)
                    {
                        amoozeshEditFunctionScanner.next();
                        System.out.println("invalid input type !");
                        return;
                    }
                    if (tempInt == 1) {
                        System.out.println("enter the  old faculty name :");
                        tempString = amoozeshEditFunctionScanner.next();
                        for (Faculty fc : Amoozesh.getFaculties()) {
                            if (fc.getName().equals(tempString)) {
                                System.out.println("enter the new faculty name : ");
                                tempString = amoozeshEditFunctionScanner.next();
                                fc.setName(tempString);
                                return;
                            }
                        }
                        System.out.println("no faculty with this name exists !");
                        break;
                    } else {
                        System.out.println("enter the old faculty ID");
                        try{
                            tempInt = amoozeshEditFunctionScanner.nextInt();
                        }
                        catch (Exception e)
                        {
                            amoozeshEditFunctionScanner.next();
                            System.out.println("invalid input type !");
                            return;
                        }
                        int tempInt_2;
                        if (Faculty.getFaculty(tempInt) != null) {
                            System.out.println("enter the new faculty ID");
                            while (true) {
                                try {
                                    tempInt_2 = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Amoozesh.faculties.contains(Faculty.getFaculty(tempInt_2))) {
                                    System.out.println("a faculty with this ID already exists!");
                                    System.out.println("try another ID :");
                                } else {
                                    break;
                                }
                            }
                            Objects.requireNonNull(Faculty.getFaculty(tempInt)).setFacultyID(tempInt_2);
                            return;
                        } else {
                            System.out.println("no faculty with this ID exists !");
                        }
                    }
                    break;
                case 4:
                    System.out.println("what do you want to edit?");
                    System.out.println("1-student name \n2-student last name \n3-student ID \n4-student major \n5-student faculty ");
                    System.out.println("6-year of entry \n7-gpa \n8-student courses \n9-student password");
                    tempInt = amoozeshEditFunctionScanner.nextInt();
                    while (true) {
                        switch (tempInt) {
                            case 1:
                                System.out.println("enter the student ID");
                                try {
                                    tempInt = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Student.getStudent(tempInt) != null) {
                                    System.out.println("enter the new student name :");
                                    try {
                                        tempString = amoozeshEditFunctionScanner.next();
                                    }
                                    catch (Exception e)
                                    {
                                        amoozeshEditFunctionScanner.next();
                                        System.out.println("invalid input type !");
                                        return;
                                    }
                                    Objects.requireNonNull(Student.getStudent(tempInt)).setName(tempString);
                                }
                                break;
                            case 2:
                                System.out.println("enter the student ID");
                                try {
                                    tempInt = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Student.getStudent(tempInt) != null) {
                                    System.out.println("enter the new student last name : ");
                                    tempString = amoozeshEditFunctionScanner.next();
                                    Objects.requireNonNull(Student.getStudent(tempInt)).setLastName(tempString);
                                }
                                break;
                            case 3:
                                System.out.println("enter the student old ID");
                                try {
                                    tempInt = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                int tempInt_2;
                                if (Student.getStudent(tempInt) != null) {
                                    System.out.println("enter the new student ID");
                                    while (true) {
                                        try {
                                            tempInt_2 = amoozeshEditFunctionScanner.nextInt();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshEditFunctionScanner.next();
                                            System.out.println("invalid input type !");
                                            return;
                                        }
                                        if (Amoozesh.students.contains(Student.getStudent(tempInt_2))) {
                                            System.out.println("a student with this ID already exists!");
                                            System.out.println("try another ID :");
                                        } else {
                                            break;
                                        }
                                    }
                                    Objects.requireNonNull(Student.getStudent(tempInt)).setStudentID(tempInt_2);
                                }
                                break;
                            case 4:
                                System.out.println("enter the student ID");
                                try {
                                    tempInt = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Student.getStudent(tempInt) != null) {
                                    System.out.println("enter the new student major :");
                                    tempString = amoozeshEditFunctionScanner.next();
                                    Objects.requireNonNull(Student.getStudent(tempInt)).setMajor(tempString);
                                }
                                break;
                            case 5:
                                System.out.println("enter the student ID");
                                int tempStudentID = 0;
                                try {
                                    tempStudentID = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Student.getStudent(tempStudentID) != null) {
                                    System.out.println("enter the new student faculty ID:");
                                    int newFacultyID = 0;
                                    try {
                                        newFacultyID = amoozeshEditFunctionScanner.nextInt();
                                    }
                                    catch (Exception e)
                                    {
                                        amoozeshEditFunctionScanner.next();
                                        System.out.println("invalid input type !");
                                        return;
                                    }
                                    if (Faculty.getFaculty(newFacultyID) != null) {
                                        (Objects.requireNonNull(Student.getStudent(tempStudentID))).setFaculty(Faculty.getFaculty(newFacultyID));
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("enter the student ID");
                                try {
                                    tempStudentID = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Student.getStudent(tempStudentID) != null) {
                                    System.out.println("enter the new student year of entry :");
                                    try {
                                        tempInt = amoozeshEditFunctionScanner.nextInt();
                                    }
                                    catch (Exception e)
                                    {
                                        amoozeshEditFunctionScanner.next();
                                        System.out.println("invalid input type !");
                                        return;
                                    }
                                    Objects.requireNonNull(Student.getStudent(tempStudentID)).setYearOfEntry(tempInt);
                                }
                                break;
                            case 7:
                                System.out.println("enter the student ID");
                                try {
                                    tempStudentID = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Student.getStudent(tempStudentID) != null) {
                                    System.out.println("enter the new student gpa , gpa should be between 0.0 to 20.0 :");
                                    double tempDouble;
                                    while (true) {
                                        try {
                                            tempDouble = amoozeshEditFunctionScanner.nextDouble();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshEditFunctionScanner.next();
                                            System.out.println("invalid input type !");
                                            return;
                                        }
                                        if (tempDouble >= 0.0 && tempDouble <= 20.0) {
                                            break;
                                        } else {
                                            System.out.println("invalid input , gpa should be between 0.0 to 20.0 , try again :");
                                        }
                                    }
                                    Objects.requireNonNull(Student.getStudent(tempStudentID)).setGPA(tempDouble);
                                }
                                break;
                            case 8:
                                System.out.println("enter the student ID :");
                                try {
                                    tempStudentID = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Student.getStudent(tempStudentID) != null) {
                                    System.out.println("what do you want to do?");
                                    System.out.println("1-add course \n2-remove course \n3-set course score");
                                    int choice = 0;
                                    try {
                                        choice = amoozeshEditFunctionScanner.nextInt();
                                    }
                                    catch (Exception e)
                                    {
                                        amoozeshEditFunctionScanner.next();
                                        System.out.println("invalid input type !");
                                        return;
                                    }
                                    while (true) {
                                        switch (choice)
                                        {
                                            case 1:
                                                System.out.println("enter the course semesters ID :");
                                                int tempSemesterID = 0;
                                                try {
                                                    tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                                                }
                                                catch (Exception e)
                                                {
                                                    amoozeshEditFunctionScanner.next();
                                                    System.out.println("invalid input type !");
                                                    return;
                                                }
                                                System.out.println("enter the course ID :");
                                                int tempCourseID;
                                                try {
                                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                                }
                                                catch (Exception e)
                                                {
                                                    amoozeshEditFunctionScanner.next();
                                                    System.out.println("invalid input type !");
                                                    return;
                                                }
                                                if (Course.getCourse(tempSemesterID, tempCourseID) != null) {
                                                    Objects.requireNonNull(Student.getStudent(tempStudentID)).addCourse(Course.getCourse(tempSemesterID, tempCourseID));
                                                }
                                                break;
                                            case 2:
                                                System.out.println("enter the course semester ID :");
                                                try {
                                                    tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                                                }
                                                catch (Exception e)
                                                {
                                                    amoozeshEditFunctionScanner.next();
                                                    System.out.println("invalid input type !");
                                                    return;
                                                }
                                                System.out.println("enter the course ID :");
                                                try {
                                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                                }
                                                catch (Exception e)
                                                {
                                                    amoozeshEditFunctionScanner.next();
                                                    System.out.println("invalid input type !");
                                                    return;
                                                }
                                                if (Course.getCourse(tempSemesterID, tempCourseID) != null) {
                                                    Objects.requireNonNull(Student.getStudent(tempStudentID)).removeCourse(Course.getCourse(tempSemesterID, tempCourseID));
                                                }
                                                break;
                                            case 3:
                                                System.out.println("enter the course semester ID :");
                                                try {
                                                    tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                                                }
                                                catch (Exception e)
                                                {
                                                    amoozeshEditFunctionScanner.next();
                                                    System.out.println("invalid input type !");
                                                    return;
                                                }
                                                System.out.println("enter the course ID :");
                                                try {
                                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                                }
                                                catch (Exception e)
                                                {
                                                    amoozeshEditFunctionScanner.next();
                                                    System.out.println("invalid input type !");
                                                    return;
                                                }
                                                double tempScore;
                                                if (Objects.requireNonNull(Student.getStudent(tempStudentID)).getStudentCourse(tempSemesterID, tempCourseID) != null) {
                                                    System.out.println("enter the course score , score should be between 0.0 and 20.0 :");
                                                    while (true) {
                                                        try {
                                                            tempScore = amoozeshEditFunctionScanner.nextDouble();
                                                        }
                                                        catch (Exception e)
                                                        {
                                                            amoozeshEditFunctionScanner.next();
                                                            System.out.println("invalid input type !");
                                                            return;
                                                        }
                                                        if (tempScore >= 0.0 && tempScore <= 20.0) {
                                                            break;
                                                        } else {
                                                            System.out.println("invalid score , enter a score between 0.0 and 20.0 :");
                                                        }
                                                    }
                                                    for (Course crs : Objects.requireNonNull(Student.getStudent(tempStudentID)).getCourses()) {
                                                        if (Course.isEqual(crs, Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)))) {
                                                            crs.setScore(tempScore);
                                                        }
                                                    }

                                                }
                                            break;
                                            default:
                                                System.out.println("invalid input try again :");
                                            break;
                                        }
                                        break;
                                    }
                                }
                                break;
                            case 9:
                                System.out.println("enter the student ID");
                                try {
                                    tempStudentID = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Student.getStudent(tempStudentID) != null) {
                                    System.out.println("enter the new student password :");
                                    tempString = amoozeshEditFunctionScanner.next();
                                    Objects.requireNonNull(Student.getStudent(tempStudentID)).setPassword(tempString);
                                }
                                break;
                            default:
                                System.out.println("invalid input !");
                                break;
                        }
                        break;
                    }
                    break;
                case 5: // editing semester
                    System.out.println("what do you want to edit ?");
                    System.out.println("1-semester name \n2-semester ID \n3-semester courses");
                    try {
                        tempInt = amoozeshEditFunctionScanner.nextInt();
                    }
                    catch (Exception e)
                    {
                        amoozeshEditFunctionScanner.next();
                        System.out.println("invalid input type !");
                        return;
                    }
                    switch (tempInt) {
                        case 1:
                            System.out.println("enter the semester ID");
                            int tempSemesterID;
                            try {
                                tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                            }
                            catch (Exception e)
                            {
                                amoozeshEditFunctionScanner.next();
                                System.out.println("invalid input type !");
                                return;
                            }
                            if (Semester.getSemester(tempSemesterID) != null) {
                                System.out.println("enter the new semester name :");
                                tempString = amoozeshEditFunctionScanner.next();
                                Objects.requireNonNull(Semester.getSemester(tempSemesterID)).setName(tempString);
                            }
                            break;
                        case 2:
                            System.out.println("enter the old semester ID");
                            try {
                                tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                            }
                            catch (Exception e)
                            {
                                amoozeshEditFunctionScanner.next();
                                System.out.println("invalid input type !");
                                return;
                            }
                            if (Semester.getSemester(tempSemesterID) != null) {
                                System.out.println("enter the new semester ID :");
                                while (true) {
                                    try {
                                        tempInt = amoozeshEditFunctionScanner.nextInt();
                                    }
                                    catch (Exception e)
                                    {
                                        amoozeshEditFunctionScanner.next();
                                        System.out.println("invalid input type !");
                                        return;
                                    }
                                    if (Amoozesh.semesters.contains(Semester.getSemester(tempInt))) {
                                        System.out.println("a semester with this ID already exists!");
                                        System.out.println("try another ID:");
                                    } else {
                                        break;
                                    }
                                }
                                Objects.requireNonNull(Semester.getSemester(tempSemesterID)).setSemesterID(tempInt);
                                System.out.println("semester ID successfully changed!");
                            }
                            break;
                        case 3:
                            System.out.println("enter the semester ID");
                            try {
                                tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                            }
                            catch (Exception e)
                            {
                                amoozeshEditFunctionScanner.next();
                                System.out.println("invalid input type !");
                                return;
                            }
                            if (Semester.getSemester(tempSemesterID) != null) {
                                System.out.println("what do you want to edit ?");
                                System.out.println("1-course name \n2-course professor name \n3-course faculty \n4-course ID \n5-units");
                                int choice;
                                try {
                                    choice = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                switch (choice) {
                                    case 1:
                                        System.out.println("enter the course ID");
                                        int tempCourseID;
                                        try {
                                            tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshEditFunctionScanner.next();
                                            System.out.println("invalid input type !");
                                            return;
                                        }
                                        if (Course.getCourse(tempSemesterID, tempCourseID) != null) {
                                            System.out.println("enter the new course name :");
                                            tempString = amoozeshEditFunctionScanner.next();
                                            Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setName(tempString);
                                        }
                                        break;
                                    case 2:
                                        System.out.println("enter the course ID");
                                        try {
                                            tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshEditFunctionScanner.next();
                                            System.out.println("invalid input type !");
                                            return;
                                        }
                                        if (Course.getCourse(tempSemesterID, tempCourseID) != null) {
                                            System.out.println("enter the new course professor name :");
                                            tempString = amoozeshEditFunctionScanner.next();
                                            Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setProfessorName(tempString);
                                        }
                                        break;
                                    case 3:
                                        System.out.println("enter the course ID :");
                                        try {
                                            tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshEditFunctionScanner.next();
                                            System.out.println("invalid input type !");
                                            return;
                                        }
                                        if (Course.getCourse(tempSemesterID, tempCourseID) != null) {
                                            System.out.println("enter the new course faculty ID :");
                                            try {
                                                tempInt = amoozeshEditFunctionScanner.nextInt();
                                            }
                                            catch (Exception e)
                                            {
                                                amoozeshEditFunctionScanner.next();
                                                System.out.println("invalid input type !");
                                                return;
                                            }
                                            Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setFaculty(Faculty.getFaculty(tempInt));
                                        }
                                        break;
                                    case 4:
                                        System.out.println("enter the old course ID :");
                                        try {
                                            tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshEditFunctionScanner.next();
                                            System.out.println("invalid input type !");
                                            return;
                                        }
                                        if (Course.getCourse(tempSemesterID, tempCourseID) != null) {
                                            System.out.println("enter the new course ID :");
                                            while (true) {
                                                try {
                                                    tempInt = amoozeshEditFunctionScanner.nextInt();
                                                }
                                                catch (Exception e)
                                                {
                                                    amoozeshEditFunctionScanner.next();
                                                    System.out.println("invalid input type !");
                                                    return;
                                                }
                                                if (Objects.requireNonNull(Semester.getSemester(tempSemesterID)).getCourses().contains(Course.getCourse(tempSemesterID, tempInt))) {
                                                    System.out.println("a course with this ID already exists in this semester!");
                                                    System.out.println("try another ID:");
                                                } else {
                                                    break;
                                                }
                                            }
                                            Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setCourseID(tempInt);
                                        }
                                        break;
                                    case 5:
                                        System.out.println("enter the course ID :");
                                        try {
                                            tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                        }
                                        catch (Exception e)
                                        {
                                            amoozeshEditFunctionScanner.next();
                                            System.out.println("invalid input type !");
                                            return;
                                        }
                                        if (Course.getCourse(tempSemesterID, tempCourseID) != null) {
                                            System.out.println("enter the new course units :");
                                           try {
                                               tempInt = amoozeshEditFunctionScanner.nextInt();
                                           }
                                           catch (Exception e)
                                           {
                                               amoozeshEditFunctionScanner.next();
                                               System.out.println("invalid input type !");
                                               return;
                                           }
                                            Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).setUnits(tempInt);
                                        }
                                        break;
                                    default:
                                        System.out.println("invalid input !");
                                        return;
                                }
                            }
                        break;
                        default:
                            System.out.println("invalid input !");
                            return;

                    }
                    break;
                case 6: // editing the professor
                    System.out.println("what do you want to edit ? ");
                    System.out.println("1-professor name \n2-professor last name \n3-professor faculty \n4-professor group");
                    System.out.println("5-remove professor courses \n6-professor password");
                    int choice;
                    try {
                        choice = amoozeshEditFunctionScanner.nextInt();
                    }
                    catch (Exception e)
                    {
                        amoozeshEditFunctionScanner.next();
                        System.out.println("invalid input type !");
                        return;
                    }
                    switch (choice) {
                        case 1:
                            System.out.println("enter professors old first name : ");
                            String tempFirstName = amoozeshEditFunctionScanner.next();
                            System.out.println("enter professors last name :  ");
                            String tempLastName = amoozeshEditFunctionScanner.next();
                            if (Professor.getProfessor(tempFirstName, tempLastName) != null) {
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
                            if (Professor.getProfessor(tempFirstName, tempLastName) != null) {
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
                            if (Professor.getProfessor(tempFirstName, tempLastName) != null) {
                                System.out.println("enter the new faculty ID :");
                                int tempFacultyID;
                                try {
                                    tempFacultyID = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).setFaculty(Faculty.getFaculty(tempFacultyID));
                            }
                            break;
                        case 4:
                            System.out.println("enter professors first name : ");
                            tempFirstName = amoozeshEditFunctionScanner.next();
                            System.out.println("enter professors last name :  ");
                            tempLastName = amoozeshEditFunctionScanner.next();
                            if (Professor.getProfessor(tempFirstName, tempLastName) != null) {
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
                            if (Professor.getProfessor(tempFirstName, tempLastName) != null) {
                                System.out.println("enter the course semesters ID :");
                                int tempSemesterID;
                                try {
                                    tempSemesterID = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                System.out.println("enter the course ID :");
                                int tempCourseID;
                                try {
                                    tempCourseID = amoozeshEditFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    amoozeshEditFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                Amoozesh.getAmoozesh().removeCourseFromSemesterAndProfessor(tempSemesterID, Course.getCourse(tempSemesterID, tempCourseID), tempFirstName, tempLastName);
                                System.out.println("the current professor courses are : ");
                                Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).printCourses(Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)));
                            }
                            break;
                        case 6:
                            System.out.println("enter professors first name : ");
                            tempFirstName = amoozeshEditFunctionScanner.next();
                            System.out.println("enter professors last name :  ");
                            tempLastName = amoozeshEditFunctionScanner.next();
                            if (Professor.getProfessor(tempFirstName, tempLastName) != null) {
                                System.out.println("enter the new password :");
                                tempString = amoozeshEditFunctionScanner.next();
                                Objects.requireNonNull(Professor.getProfessor(tempFirstName, tempLastName)).setPassword(tempString);
                            }
                            break;
                        default:
                            System.out.println("invalid input !");
                            return;
                    }
                break;
                default:
                    System.out.println("invalid input try again :");
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
            boolean goBackToProfessorLoginFunction = false;
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
                        System.out.println("enter the name of a course to see all of the students in that course or enter \"quit\" to go back to main menu or enter \"edit\" to edit your info :");
                        String tempCourseName = professorLoginFunctionScanner.next();
                        if (tempCourseName.equals("quit"))
                        {
                            return;
                        }
                        if (tempCourseName.equals("edit"))
                        {
                            professorEditFunction(tempFirstName,tempLastName);
                            System.out.println("done !");
                            System.out.println("enter 1 to stay in your account , enter any thing else to go back to main menu : ");
                            String choice = professorLoginFunctionScanner.next();
                            if (!choice.equals("1"))
                            {
                                return;
                            }
                            else
                            {
                                continue;
                            }
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
                            try {
                                tempStudentID = professorLoginFunctionScanner.nextInt();
                            }
                            catch (Exception e)
                            {
                                professorLoginFunctionScanner.next();
                                System.out.println("invalid input type !");
                                return;
                            }
                            if (tempArrayOfStudentID.contains(tempStudentID))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("this ID doesnt exist in this list ! , try again :");
                            }
                        }
                        System.out.println("enter a score between 0.0 and 20.0 :");
                        double tempScore;
                        while (true)
                        {
                            try {
                                tempScore = professorLoginFunctionScanner.nextDouble();
                            }
                            catch (Exception e)
                            {
                                professorLoginFunctionScanner.next();
                                System.out.println("invalid input type !");
                                return;
                            }
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
                        System.out.println("enter 1 to stay in your account , enter any other thing to go back to main menu :");
                        String  choice = professorLoginFunctionScanner.next();
                        if (!choice.equals("1"))
                        {
                            return;
                        }
                    }
                }
            }
            System.out.println("no such professor has been registered or wrong password !");
            System.out.println("going back to main menu...");
            return;
        }
    }

    public static void professorEditFunction(String oldFirstName , String oldLastName)
    {
        Scanner professorEditFunctionScanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("what do you want to edit ?");
            System.out.println("1-name \n2-last name \n3-password \n4-group \n5-faculty");
            String choice = professorEditFunctionScanner.next();
            switch (choice)
            {
                case "1":
                    System.out.println("enter the new name :");
                    String tempNewFirstName = professorEditFunctionScanner.next();
                    Objects.requireNonNull(Professor.getProfessor(oldFirstName, oldLastName)).setName(tempNewFirstName);
                return;
                case "2":
                    System.out.println("enter the new last name :");
                    String tempNewLastName = professorEditFunctionScanner.next();
                    Objects.requireNonNull(Professor.getProfessor(oldFirstName, oldLastName)).setLastName(tempNewLastName);
                return;
                case "3":
                    System.out.println("enter the new password :");
                    String tempNewPassword = professorEditFunctionScanner.next();
                    Objects.requireNonNull(Professor.getProfessor(oldFirstName, oldLastName)).setPassword(tempNewPassword);
                return;
                case "4":
                    System.out.println("enter the new group name :");
                    String tempNewGroup = professorEditFunctionScanner.next();
                    Objects.requireNonNull(Professor.getProfessor(oldFirstName, oldLastName)).setGroup(tempNewGroup);
                return;
                case "5":
                    System.out.println("enter the new faculty ID : ");
                    int tempNewFacultyID = professorEditFunctionScanner.nextInt();
                    if (Amoozesh.faculties.contains(Faculty.getFaculty(tempNewFacultyID)))
                    {
                        Objects.requireNonNull(Professor.getProfessor(oldFirstName, oldLastName)).setFaculty(Faculty.getFaculty(tempNewFacultyID));
                    }
                    else
                    {
                        System.out.println("no such faculty exists !");
                    }
                return;
                default:
                    System.out.println("invalid input , try again : ");
                break;
            }
        }
    }

    public static void studentLoginFunction()
    {
        Scanner studentLoginFunctionScanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("enter your student ID :");
            int studentID;
            try {
                studentID = studentLoginFunctionScanner.nextInt();
            }
            catch (Exception e)
            {
                studentLoginFunctionScanner.next();
                System.out.println("invalid input type !");
                return;
            }
            if (Student.getStudent(studentID) == null)
            {
                System.out.println("no such student exists !");
                System.out.println("enter 1 to try again or enter anything else to go back to main menu :");
                String temp = studentLoginFunctionScanner.next();
                if (!temp.equals("1"))
                {
                    return;
                }
                else
                {
                    continue;
                }
            }
            while (true)
            {
                System.out.println("enter your password :");
                String password = studentLoginFunctionScanner.next();
                if (!Objects.requireNonNull(Student.getStudent(studentID)).getPassword().equals(password))
                {
                    System.out.println("wrong password !");
                    System.out.println("enter 1 to try again or enter anything else to go back to main menu :");
                    String temp = studentLoginFunctionScanner.next();
                    if (!temp.equals("1"))
                    {
                        return;
                    }
                    else
                    {
                        continue;
                    }
                }
                System.out.println("login successful !");
                while (true)
                {
                    System.out.println("what do you want to do ?");
                    System.out.println("1-schedule \n2-scores \n3-register \n4-edit \n5-go back to main menu");
                    String choice = studentLoginFunctionScanner.next();
                    switch (choice)
                    {
                        case "1":
                            Objects.requireNonNull(Student.getStudent(studentID)).printCoursesOfStudent(studentID);
                        break;
                        case "2":
                            Objects.requireNonNull(Student.getStudent(studentID)).printScoresOfStudent(studentID);
                        break;
                        case "3":
                            if (Amoozesh.isAmoozeshMade &&!Amoozesh.semesters.isEmpty())
                            {
                                studentRegisterFunction(studentID);
                            }
                            else
                            {
                                System.out.println("no semester has been made yet !");
                            }
                        break;
                        case "4":
                            studentEditFunction(studentID);
                        break;
                        case "5":
                        return;
                        default:
                            System.out.println("invalid input , try again :");
                        break;
                    }
                }
            }
        }


    }

    public static void studentRegisterFunction(int studentID)
    {
        Scanner studentRegisterFunctionScanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("enter the semesterID for which you are trying to register :");
            int tempSemesterID;
            try {
                tempSemesterID = studentRegisterFunctionScanner.nextInt();
            }
            catch (Exception e)
            {
                studentRegisterFunctionScanner.next();
                System.out.println("invalid input type !");
                return;
            }
            if (!Amoozesh.semesters.contains(Semester.getSemester(tempSemesterID)))
            {
                System.out.println("there is no semester with this ID !");
                System.out.println("enter 1 to try again , enter any thing else to go back to your account :");
                String tempString = studentRegisterFunctionScanner.next();
                if (!tempString.equals("1"))
                {
                    return;
                }
                else
                {
                    continue;
                }
            }
            else
            {
                while (true)
                {
                    System.out.println("these are the courses that your faculty is presenting in this semester :");
                    Objects.requireNonNull(Semester.getSemester(tempSemesterID)).printCoursesInSemesterForASpecificFaculty(tempSemesterID, Objects.requireNonNull(Student.getStudent(studentID)).getFaculty().getFacultyID());
                    System.out.println("enter the courseID of the course that you would like to register for this semester , you can select at least 12 and at most 20 credit units.");
                    while (true)
                    {
                        int tempCourseID;
                        try {
                            tempCourseID = studentRegisterFunctionScanner.nextInt();
                        }
                        catch (Exception e)
                        {
                            studentRegisterFunctionScanner.next();
                            System.out.println("invalid input type !");
                            return;
                        }
                        if (Objects.requireNonNull(Semester.getSemester(tempSemesterID)).getCourses().contains(Course.getCourse(tempSemesterID, tempCourseID))) // if such course exists in that semester...
                        {
                            if (Objects.requireNonNull(Student.getStudent(studentID)).getUnitsInCurrentSemester() + Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).getUnits() <= 20) // if adding that course won't increase credit count beyond 20...
                            {
                                if (!Objects.requireNonNull(Student.getStudent(studentID)).getCourses().contains(Course.getCourse(tempSemesterID,tempCourseID))) // if the course is not already registered...
                                {
                                    Objects.requireNonNull(Student.getStudent(studentID)).addCourse(Course.getCourse(tempSemesterID, tempCourseID));
                                    Objects.requireNonNull(Student.getStudent(studentID)).addUnitsInCurrentSemester(Objects.requireNonNull(Course.getCourse(tempSemesterID, tempCourseID)).getUnits());
                                    System.out.println("done ! here are the courses that you have registered so far : ");
                                    Objects.requireNonNull(Student.getStudent(studentID)).printCoursesOfStudent(studentID);
                                    System.out.println("you currently have : " + Objects.requireNonNull(Student.getStudent(studentID)).getUnitsInCurrentSemester() + " credit units" );
                                    System.out.println("enter 1 to continue your registration , enter any other thing to end your registration :");
                                    String choice = studentRegisterFunctionScanner.next();
                                    if (!choice.equals("1") && Objects.requireNonNull(Student.getStudent(studentID)).getUnitsInCurrentSemester() >= 12 )
                                    {
                                        return;
                                    }
                                    else
                                    {
                                        System.out.println("you should at least choose 12 credit units !");
                                        System.out.println("enter the courseID of the course that you would like to register for this semester:");
                                    }
                                }
                                else
                                {
                                    System.out.println("you have already registered this course ! try again :");
                                    break;
                                }
                            }
                            else
                            {
                                System.out.println("adding this course will increase your credit count above 20 !");
                                System.out.println("enter 1 to select another course or enter any other thing to end your registration :");
                                String choice = studentRegisterFunctionScanner.next();
                                if (!choice.equals("1"))
                                {
                                    return;
                                }
                                else
                                {
                                    break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("no such course in this semester ! try again :");
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void studentEditFunction(int studentID)
    {
        Scanner studentEditFunctionScanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("what do you want to edit ?");
            System.out.println("1-name \n2-last name \n3-password \n4-return to account");
            String choice = studentEditFunctionScanner.next();
            String temp;
            switch (choice)
            {
                case "1":
                    System.out.println("enter your new name :");
                    temp = studentEditFunctionScanner.next();
                    Objects.requireNonNull(Student.getStudent(studentID)).setName(temp);
                    System.out.println("done !");
                break;
                case "2":
                    System.out.println("enter your new last name :");
                    temp = studentEditFunctionScanner.next();
                    Objects.requireNonNull(Student.getStudent(studentID)).setLastName(temp);
                    System.out.println("done !");
                break;
                case "3":
                    System.out.println("enter your new password :");
                    temp = studentEditFunctionScanner.next();
                    Objects.requireNonNull(Student.getStudent(studentID)).setPassword(temp);
                break;
                case "4":
                return;
                default:
                    System.out.println("invalid input enter 1 to stay in edit , enter any other thing to return to your account :");
                    temp = studentEditFunctionScanner.next();
                    if (!temp.equals("1"))
                    {
                        return;
                    }
                break;
            }
        }
    }

    public static void signupFunction()
    {
        Scanner signupFunctionScanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("who do you want to signup ? \n1-amoozesh \n2-professor \n3-student \n4-return to main menu");
            String choice = signupFunctionScanner.next();
            switch (choice)
            {
                case "1":
                    if (!Amoozesh.isAmoozeshMade)
                    {
                        System.out.println("enter your name :");
                        String tempName = signupFunctionScanner.next();
                        System.out.println("enter your password :");
                        String tempPassword = signupFunctionScanner.next();
                        Amoozesh.makeAmoozesh(tempName,tempPassword);
                        System.out.println("done !");
                        System.out.println("enter 1 to stay in signup , enter any other thing to return to main menu :");
                        choice = signupFunctionScanner.next();
                        if (!choice.equals("1"))
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("amoozesh account already exists !");
                    }
                break;
                case "2":
                    if (Amoozesh.isAmoozeshMade)
                    {
                        System.out.println("enter the professors name :");
                        String tempName = signupFunctionScanner.next();
                        System.out.println("enter the professors last name :");
                        String tempLastName = signupFunctionScanner.next();
                        int tempFacultyID;
                        while (true)
                        {
                            System.out.println("enter the professors faculty ID :");
                            try {
                                tempFacultyID = signupFunctionScanner.nextInt();
                            }
                            catch (Exception e)
                            {
                                signupFunctionScanner.next();
                                System.out.println("invalid input type !");
                                return;
                            }
                            if (!Amoozesh.faculties.contains(Faculty.getFaculty(tempFacultyID)))
                            {
                                System.out.println("no such faculty exists !");
                                System.out.println("enter 1 to try again , enter any other thing to return to main menu :");
                                String temp = signupFunctionScanner.next();
                                if (!temp.equals("1"))
                                {
                                    return;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        System.out.println("enter the professors group :");
                        String tempGroup = signupFunctionScanner.next();
                        System.out.println("enter the professors password :");
                        String tempPassword = signupFunctionScanner.next();
                        if (Amoozesh.professors.contains(Professor.getProfessor(tempName,tempLastName)) && Objects.requireNonNull(Professor.getProfessor(tempName, tempLastName)).getFaculty().getFacultyID() == tempFacultyID && Objects.requireNonNull(Professor.getProfessor(tempName, tempLastName)).getGroup().equals(tempGroup))
                        {
                            System.out.println("this professor already exist! , you cant create duplicate professors!");
                            System.out.println("returning to main menu...");
                            return;
                        }
                        Amoozesh.getAmoozesh().makeProfessor(tempName,tempLastName,Faculty.getFaculty(tempFacultyID),tempGroup,tempPassword);
                        System.out.println("done !");
                        System.out.println("enter 1 to stay in signup , enter any other thing to return to main menu :");
                        choice = signupFunctionScanner.next();
                        if (!choice.equals("1"))
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("no amoozesh account exists ! , to signup a professor you need to make an amoozesh account and make a faculty first !");
                        return;
                    }
                break;
                case "3":
                    if (Amoozesh.isAmoozeshMade)
                    {
                        if (!Amoozesh.faculties.isEmpty())
                        {
                            System.out.println("enter the students name :");
                            String tempName = signupFunctionScanner.next();
                            System.out.println("enter the students last name :");
                            String tempLastName = signupFunctionScanner.next();
                            int tempID;
                            while (true)
                            {
                                System.out.println("enter the students ID :");
                                try {
                                    tempID = signupFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    signupFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (Amoozesh.students.contains(Student.getStudent(tempID)))
                                {
                                    System.out.println("an student with this ID already exists! you cant create duplicate students");
                                    System.out.println("if you want to try assigning another ID enter 1 , enter anything else to return to main menu : ");
                                    String decision = signupFunctionScanner.next();
                                    if (!decision.equals("1"))
                                    {
                                        return;
                                    }
                                }
                                else
                                {
                                    break;
                                }
                            }
                            System.out.println("enter the students major :");
                            String tempMajor = signupFunctionScanner.next();
                            int tempFacultyID;
                            while (true)
                            {
                                System.out.println("enter the students faculty ID :");
                                try {
                                    tempFacultyID = signupFunctionScanner.nextInt();
                                }
                                catch (Exception e)
                                {
                                    signupFunctionScanner.next();
                                    System.out.println("invalid input type !");
                                    return;
                                }
                                if (!Amoozesh.faculties.contains(Faculty.getFaculty(tempFacultyID)))
                                {
                                    System.out.println("no such faculty exists! enter 1 to try again or enter any other thing to return to main menu :");
                                    String choice_2 = signupFunctionScanner.next();
                                    if (!choice_2.equals("1"))
                                    {
                                        return;
                                    }
                                }
                                else
                                {
                                    break;
                                }
                            }
                            System.out.println("enter the students year of entry :");
                            int tempYear;
                            try {
                                tempYear = signupFunctionScanner.nextInt();
                            }
                            catch (Exception e)
                            {
                                signupFunctionScanner.next();
                                System.out.println("invalid input type !");
                                return;
                            }
                            System.out.println("enter the students password :");
                            String tempPassword = signupFunctionScanner.next();
                            Amoozesh.getAmoozesh().makeStudent(tempName,tempLastName,tempID,tempMajor,Faculty.getFaculty(tempFacultyID),tempYear,0,tempPassword);
                            System.out.println("done !");
                            System.out.println("enter 1 to stay in signup , enter any other thing to return to main menu :");
                            choice = signupFunctionScanner.next();
                            if (!choice.equals("1"))
                            {
                                return;
                            }
                        }
                        else
                        {
                            System.out.println("no faculties exist! , to signup a student , at least one faculty must be made ! ");
                        }
                    }
                    else
                    {
                        System.out.println("no amoozesh account exists! , to signup a student you need to make an amoozesh account first!");
                    }
                break;
                case "4":
                return;
                default:
                    System.out.println("invalid input , try again :");
                break;
            }
        }

    }




}





