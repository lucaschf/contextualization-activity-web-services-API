package tsi.ws.lucaschfonseca.introductionwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsi.ws.lucaschfonseca.introductionwebservices.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
}
