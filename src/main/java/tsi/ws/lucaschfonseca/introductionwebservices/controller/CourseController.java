package tsi.ws.lucaschfonseca.introductionwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tsi.ws.lucaschfonseca.introductionwebservices.controller.dto.CourseDto;
import tsi.ws.lucaschfonseca.introductionwebservices.controller.form.CourseForm;
import tsi.ws.lucaschfonseca.introductionwebservices.repository.CourseRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<CourseDto> insert(@Valid @RequestBody CourseForm form, UriComponentsBuilder uriComponentsBuilder) {
        var course = form.map();
        courseRepository.save(course);

        URI uri = uriComponentsBuilder.path("/course/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(new CourseDto(course));
    }

    @GetMapping
    public List<CourseDto> fetch(String name) {
        if (name == null || name.trim().isEmpty())
            return CourseDto.map(courseRepository.findAll());

        return CourseDto.map(courseRepository.findAllByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> fetchById(@PathVariable Long id) {
        var opt = courseRepository.findById(id);

        return opt.map(course -> ResponseEntity.ok(new CourseDto(course)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
