package MongoExample.MongoDB.Service;

import MongoExample.MongoDB.Domain.Student;
import MongoExample.MongoDB.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student){

        return studentRepository.save(student);

    }

    public Student getStudentById(String id){

        return studentRepository.findById(id).get();

    }

    public List<Student> getAllStudents(){


        return studentRepository.findAll();


    }

    // main difference between createStudent and updateStudent is, if we use id as an identifier it will find particular document and update
    // instead of creating new one.
    public Student updateStudent(Student student){

        return studentRepository.save(student);

    }

    public String deleteStudent(String id){

       studentRepository.deleteById(id);

       return "Student has been deleted!";

    }

    // returning list because students can have same names
    public List<Student> getStudentByName(String name){

        return studentRepository.getStudentsByName(name);

    }

    public List<Student> getStudentByNameAndEmail(String name, String email){

        return studentRepository.findByNameAndEmail(name,email);

    }

    public List<Student> getStudentByNameOrEmail(String name, String email){

        return studentRepository.findByNameOrEmail(name,email);

    }

    public List<Student> getAllWithPagination(int pageNum, int pageSize){

        Pageable pageable = PageRequest.of(pageNum,pageSize);

        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> allWithSorting(){

        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        return studentRepository.findAll(sort);

    }

    public List<Student> byDepartmentName(String departmentName){

        return studentRepository.findByDepartmentDepartmentName(departmentName);

    }

    public List<Student> bySubjectName(String subjectName){

        return studentRepository.findBySubjectsSubjectName(subjectName);

    }

    public List<Student> emailLike(String email){

        return studentRepository.findByEmailIsLike(email);

    }

    public List<Student> startsWith(String name){

        return studentRepository.findByNameStartsWith(name);

    }


}
