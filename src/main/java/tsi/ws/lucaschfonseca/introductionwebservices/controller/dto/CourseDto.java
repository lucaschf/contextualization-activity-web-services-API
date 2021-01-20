package tsi.ws.lucaschfonseca.introductionwebservices.controller.dto;

import tsi.ws.lucaschfonseca.introductionwebservices.model.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDto {
    private final Long id;
    private final int year;
    private final String name;
    private final List<StudentDto> students;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.year = course.getYear();
        this.name = course.getName();
        this.students = StudentDto.map(course.getStudents());
    }

    @SuppressWarnings("unused")
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public List<StudentDto> getStudents() {
        return students;
    }

    public static List<CourseDto> map(List<Course> courses) {
        return courses.stream().map(CourseDto::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
