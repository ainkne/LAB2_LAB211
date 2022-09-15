package StudentManagement;

import Model.Departments;
import Model.Functions.Input;
import Model.StudentList;
import java.io.IOException;
public class Menu {
    public static void displayMenu() throws IOException {
        System.out.println("====  STUDENT MANAGEMENT  ====");
        System.out.println();
        while (true){
            System.out.println("""
                    1. Add new student
                    2. Print all students
                    3. Print number of students in the same city
                    4. Update Student or Remove Student
                    5. Export to file
                    6. Quit""");
            int choice = Input.getUserChoice("Enter your choice: ", 5);
            switch (choice){
                case 1 -> selectStudentType();
                case 2 -> StudentList.printStudents();
                case 3 -> StudentList.countSameCity();
                case 4 -> selectedDelOrUpDate();
                case 5 -> StudentList.exportToFile("src/Model/students.txt");
                case 6 -> System.exit(0);
            }
        }
    }
    private static void selectStudentType(){
        System.out.println("---- Select Student's Major ----");
        System.out.println();
        System.out.println("" +
                "1. Information Technology" +
                "\n2. Economics");
        int choice = Input.getUserChoice("Enter your choice: ", 2);
        switch (choice){
            case 1 -> StudentList.addStudent(Departments.IT);
            case 2 -> StudentList.addStudent(Departments.BIZ);
        }
    }
    private static void selectedDelOrUpDate(){
        System.out.println("---- Update or Remove student ----");
        System.out.println();
        String choice = Input.getUpOrRemove("Enter (U) for Update or (R) for Remove: ");
        switch (choice){
            case "U", "u" -> StudentList.updateStudent();
            case "R", "r" -> StudentList.removeStudent();
        }
    }
}
