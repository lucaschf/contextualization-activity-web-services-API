package tsi.ws.lucaschfonseca.introductionwebservices.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private String name;

    @OneToMany(mappedBy = "course")
    private final List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public void setName(String course) {
        this.name = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Course course = (Course) o;
        return year == course.year &&
                Objects.equals(id, course.id) &&
                Objects.equals(name, course.name) &&
                Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, name, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
