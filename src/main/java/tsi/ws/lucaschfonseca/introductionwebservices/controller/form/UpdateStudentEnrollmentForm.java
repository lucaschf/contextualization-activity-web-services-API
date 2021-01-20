package tsi.ws.lucaschfonseca.introductionwebservices.controller.form;

import tsi.ws.lucaschfonseca.introductionwebservices.model.Student;
import tsi.ws.lucaschfonseca.introductionwebservices.repository.StudentRepository;

@SuppressWarnings("unused")
public class UpdateStudentEnrollmentForm {
    private boolean enrolled;

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public Student update(Long id, StudentRepository studentRepository) {
        var student = studentRepository.getOne(id);

        student.setEnrolled(enrolled);
        return student;
    }
}