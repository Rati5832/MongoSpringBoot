package MongoExample.MongoDB.Controller;


import MongoExample.MongoDB.Domain.Student;
import MongoExample.MongoDB.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){

        return studentService.createStudent(student);


    }

    @GetMapping("/getById/{id}")
    public Student getStudent(@PathVariable String id){

        return studentService.getStudentById(id);


    }

    @GetMapping("/all")
    public List<Student> allStudents(){

        return studentService.getAllStudents();

    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){

        return studentService.updateStudent(student);

    }

    @DeleteMapping("/delete")
    public String deleteStudentById(@PathVariable String id){

        return studentService.deleteStudent(id);

    }

    @GetMapping("/{name}")
    public List<Student> getStudentByName(@PathVariable String name){

        return studentService.getStudentByName(name);

    }

    @GetMapping("/ByNameAndEmail")
    public List<Student> getStudentByNameAndEmail(@RequestParam String name, @RequestParam String email){

        return studentService.getStudentByNameAndEmail(name,email);

    }

    @GetMapping("/ByNameOrEmail")
    public List<Student> getStudentByNameOrEmail(@RequestParam String name, @RequestParam String email){

        return studentService.getStudentByNameOrEmail(name,email);

    }

    @GetMapping("/allWithPagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNum, @RequestParam int pageSize){

        return studentService.getAllWithPagination(pageNum,pageSize);

    }

    @GetMapping("/allWithSorting")
    public List<Student> allWithSorting(){

        return studentService.allWithSorting();

    }

    @GetMapping("/byDepartmentName")
    public List<Student> byDepartmentName(@RequestParam String departmentName){

        return studentService.byDepartmentName(departmentName);

    }

    @GetMapping("/bySubjectName")
    public List<Student> bySubjectName(@RequestParam String subjectName){

        return studentService.bySubjectName(subjectName);

    }

    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String email){

        return studentService.emailLike(email);

    }

    @GetMapping("/startsWith")
    public List<Student> startsWith(@RequestParam String name){

        return studentService.startsWith(name);

    }


}
