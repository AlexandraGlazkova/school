package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
@RestController
@RequestMapping("student")
public class StudentController {
    //1. В каталоге **controller** cоздать два класса контроллеров для сервисов: StudentController и FacultyController.
    //2. В них добавить RequestMapping (“student” для StudentController и “faculty” для FacultyController).
    //3. В каждом контроллере реализовать эндпоинты для создания, получения, изменения и удаления сущностей,
    // используя все правила формирования REST-запросов: GET-методы для получения данных, POST — для создания…
    //  Добавить фильтрацию студентов по возрасту.
    // Для этого в StudentController добавить эндпоинт, который принимает число (возраст — поле age)
    // и возвращает список студентов, у которых совпал возраст с переданным числом.

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}") // GET http://localhost:8080/student/5
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/age/{age}") // GET http://localhost:8080/student/age/25
    public ResponseEntity<Collection<Student>> getStudentsByAge(@PathVariable Integer age) {
        return ResponseEntity.ok(studentService.getStudentsByAge(age));
    }

    @PostMapping // POST http://localhost:8080/student
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping // PUT http://localhost:8080/student
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}") // DELETE http://localhost:8080/student/5
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}

