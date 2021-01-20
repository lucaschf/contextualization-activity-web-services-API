package tsi.ws.lucaschfonseca.introductionwebservices.controller.dto;

import tsi.ws.lucaschfonseca.introductionwebservices.model.Student;

@SuppressWarnings("unused")
public class StudentDetailedDto {

    private final Long id;
    private final String name;
    private final boolean enrolled;
    private final String courseName;

    public StudentDetailedDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.enrolled = student.isEnrolled();
        this.courseName = student.getCourse().getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    @Override
    public String toString() {
        return "StudentDetailedDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrolled=" + enrolled +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
