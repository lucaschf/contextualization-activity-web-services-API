package tsi.ws.lucaschfonseca.introductionwebservices.controller.form;

import org.hibernate.validator.constraints.Length;
import tsi.ws.lucaschfonseca.introductionwebservices.model.Course;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@SuppressWarnings("unused")
public class CourseForm {
    @Min(2000)
    int year;

    @NotNull @NotEmpty @Length(min = 3)
    String name;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course map() {
        return new Course(name, year);
    }
}
