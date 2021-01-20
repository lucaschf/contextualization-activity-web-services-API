package tsi.ws.lucaschfonseca.introductionwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tsi.ws.lucaschfonseca.introductionwebservices.controller.dto.StudentDetailedDto;
import tsi.ws.lucaschfonseca.introductionwebservices.controller.dto.StudentDto;
import tsi.ws.lucaschfonseca.introductionwebservices.controller.form.StudentForm;
import tsi.ws.lucaschfonseca.introductionwebservices.controller.form.UpdateStudentEnrollmentForm;
import tsi.ws.lucaschfonseca.introductionwebservices.model.Student;
import tsi.ws.lucaschfonseca.introductionwebservices.repository.CourseRepository;
import tsi.ws.lucaschfonseca.introductionwebservices.repository.StudentRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private StudentRepository studentRepository;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<StudentDto> fetch(String name) {
        if (name == null)
            return StudentDto.map(studentRepository.findAll());

        return StudentDto.map(studentRepository.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDetailedDto> details(@PathVariable Long id) {
        var opt = studentRepository.findById(id);

        return opt.map(student -> ResponseEntity.ok(new StudentDetailedDto(student)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StudentDto> insert(@RequestBody @Valid StudentForm form, UriComponentsBuilder uriBuilder) {
        Student student = form.map(courseRepository);
        studentRepository.save(student);

        URI uri = uriBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(new StudentDto(student));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<StudentDto> updateEnrollment(@PathVariable Long id, @RequestBody @Valid UpdateStudentEnrollmentForm form){
        var opt = studentRepository.findById(id);

        if (opt.isPresent()) {
            var student = form.update(id, studentRepository);
            return ResponseEntity.ok(new StudentDto(student));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        var opt = studentRepository.findById(id);

        if (opt.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
