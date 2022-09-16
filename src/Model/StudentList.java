package Model;
import Model.Functions.Input;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.*;
public class StudentList {
    private static final List<Student> students = new ArrayList<>();
    public static void addStudent(Departments department){
        Student student = new Student();
        while (true) {
            String id = Input.inputString("Enter student's ID: ");
            if (searchStudentById(id) >= 0) {
                System.out.println("ID existed, try again!");
            } else {
                student.setId(id);
                break;
            }
        }
        student.setFullName(Input.inputString("Enter student's full name: "));
        student.setAddress(Input.inputString("Enter student's address: "));
        switch (department){
            case IT -> addItStudent(student);
            case BIZ -> addBizStudent(student);
        }
    }
    private static void addItStudent(Student student){
        IT itStudent = new IT();
        itStudent.setJavaScore(Input.inputScore("Enter Java score: "));
        itStudent.setCssScore(Input.inputScore("Enter CSS score: "));
        students.add(new IT(student.getId(), student.getFullName(), student.getAddress(), itStudent.getJavaScore()
                ,itStudent.getCssScore()));
    }
    private static void addBizStudent(Student student){
        Biz bizStudent = new Biz();
        bizStudent.setAccScore(Input.inputScore("Enter accounting score: "));
        bizStudent.setMarketingScore(Input.inputScore("Enter marketing score: "));
        students.add(new Biz(student.getId(), student.getFullName(), student.getAddress(), bizStudent.getAccScore()
                , bizStudent.getMarketingScore()));
    }
    public static void removeStudent(){
        String removeId = Input.inputString("Enter student's ID you want to remove: ");
        int i = searchStudentById(removeId);
        if (i < 0) {
            System.out.println("ID not found");
        } else {
            students.remove(students.get(i));
            System.out.println("Remove" + removeId + "successfully!");
        }
    }
    public static void updateStudent(){
        while (true){
            String updateId = Input.inputString("Enter student's ID you want to update: ");
            int n = searchStudentById(updateId);
            if (n < 0){
                System.out.println("ID not found!");
            } else {
                students.get(n).setFullName(Input.inputString("Enter update full name: "));
                students.get(n).setAddress(Input.inputString("Enter update address: "));
                if (students.get(n) instanceof IT){
                    ((IT) students.get(n)).setJavaScore(Input.inputScore("Enter update Java score: "));
                    ((IT) students.get(n)).setCssScore(Input.inputScore("Enter update CSS score: "));
                } else if (students.get(n) instanceof Biz) {
                    ((Biz) students.get(n)).setAccScore(Input.inputScore("Enter update accounting score: "));
                    ((Biz) students.get(n)).setMarketingScore(Input.inputScore("Enter update marketing score: "));
                }
                System.out.println("Updated ID: " + updateId + " successfully!");
                break;
            }
        }
    }
    public static void countSameCity(){
        Map<String, List<Student>> sameCity = students
                .stream()
                .collect(Collectors.groupingBy(Student::getAddress));
        sameCity.forEach((city, students1) -> {
            System.out.print(city.toUpperCase());
            System.out.println(" has " + students1.size() + " student(s)");
            System.out.println();
        } );
    }
    public static void printStudents(){
        Collections.sort(students);
        students.forEach(System.out::println);
        System.out.println();
    }
    private static int searchStudentById(String id){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId().equalsIgnoreCase(id)) return i;
        } return -1;
    }
    public static void exportToFile(String filePath) throws IOException {
        FileWriter myWriter = new FileWriter(filePath);
        for (Student student : students) {
            myWriter.write("Full name: " + student.getFullName());
            if (student instanceof IT) {
                myWriter.write(" |GPA: " + ((IT) student).getTbScore() + "\n");
            }
            if (student instanceof Biz) {
                myWriter.write(" |GPA: " + ((Biz)student).getAvgScore() + "\n");
            }
        }
        myWriter.close();
        System.out.println("Save to file successfully!");
    }
}