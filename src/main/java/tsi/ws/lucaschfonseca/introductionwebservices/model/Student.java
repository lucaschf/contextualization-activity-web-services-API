package tsi.ws.lucaschfonseca.introductionwebservices.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean enrolled;

    @ManyToOne
    private Course course;

    public Student() {
    }

    public Student(String name, boolean enrolled, Course course) {
        this.name = name;
        this.enrolled = enrolled;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Student student = (Student) o;
        return enrolled == student.enrolled &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, enrolled, course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrolled=" + enrolled +
                ", course=" + course +
                '}';
    }
}
