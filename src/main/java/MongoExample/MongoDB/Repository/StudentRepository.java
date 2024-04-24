package MongoExample.MongoDB.Repository;

import MongoExample.MongoDB.Domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> getStudentsByName(String name);
    List<Student> findByNameAndEmail(String name, String email);
    List<Student> findByNameOrEmail(String name, String email);

    List<Student> findByDepartmentDepartmentName(String departmentName);

    List<Student> findBySubjectsSubjectName(String subjectName);

    List<Student> findByEmailIsLike(String email);

    List<Student> findByNameStartsWith(String name);

}
