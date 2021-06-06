package sample;

public class Student {
    private String id_student;
    private String name_student;
    private String name_specialty;

    public Student(String id_student, String name_student, String name_specialty) {
        this.id_student = id_student;
        this.name_student = name_student;
        this.name_specialty = name_specialty;
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public String getName_specialty() {
        return name_specialty;
    }

    public void setName_specialty(String name_specialty) {
        this.name_specialty = name_specialty;
    }
}
