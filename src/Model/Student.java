package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student implements Comparable<Student>{
    private String id, fullName, address;
    public Student() {}
    public Student(String id, String fullName, String address) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
    }
    public float getAvgScore(){return 0;}
    @Override
    public String toString() {
        return "ID: " + getId() + " - FullName: " + getFullName() + " - Address: " + getAddress() + " - ";
    }
    @Override
    public int compareTo(Student o) {
        return this.getFullName().compareTo(o.getFullName());
    }
}
