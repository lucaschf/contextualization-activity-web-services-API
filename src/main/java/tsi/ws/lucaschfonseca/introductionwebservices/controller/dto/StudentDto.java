package tsi.ws.lucaschfonseca.introductionwebservices.controller.dto;

import tsi.ws.lucaschfonseca.introductionwebservices.model.Student;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class StudentDto {
    private final Long id;
    private final String name;
    private final boolean enrolled;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.enrolled = student.isEnrolled();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public static List<StudentDto> map(List<Student> students) {
        return students.stream().map(StudentDto::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrolled=" + enrolled +
                '}';
    }
}
