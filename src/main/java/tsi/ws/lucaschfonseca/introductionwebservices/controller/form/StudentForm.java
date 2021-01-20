package tsi.ws.lucaschfonseca.introductionwebservices.controller.form;

import org.hibernate.validator.constraints.Length;
import tsi.ws.lucaschfonseca.introductionwebservices.model.Course;
import tsi.ws.lucaschfonseca.introductionwebservices.model.Student;
import tsi.ws.lucaschfonseca.introductionwebservices.repository.CourseRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@SuppressWarnings("unused")
public class StudentForm {
    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String name;

    @NotEmpty
    @Length(min = 3)
    private String courseName;

    private boolean enrolled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public Student map(CourseRepository repository) {
        Course course = repository.findByName(courseName);

        return new Student(name, enrolled, course);
    }
}
