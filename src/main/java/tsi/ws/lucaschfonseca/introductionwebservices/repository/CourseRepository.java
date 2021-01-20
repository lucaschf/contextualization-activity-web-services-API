package tsi.ws.lucaschfonseca.introductionwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsi.ws.lucaschfonseca.introductionwebservices.model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);

    List<Course> findAllByName(String name);
}
