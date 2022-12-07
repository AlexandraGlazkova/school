package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    //1. В каталоге **service** cоздать два класса сервисов для моделей: StudentService и FacultyService.
    //2. В каждом из них завести HashMap, в котором следует хранить модели. Например Map<Long, Student>.
    //3. Также создать счетчик идентификатора, который будет инкрементироваться при каждом добавлении нового объекта модели в HashMap.
    //4. В каждом сервисе реализовать CRUD-методы для создания, чтения, изменения и удаления сущностей.
    private final Map<Long, Student> students = new HashMap<>();
    private long lastId;

    public Student createStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public Collection<Student> getStudentsByAge(int age) {
        return students.entrySet().stream()
                .filter(e -> e.getValue().getAge() == age)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())).values();
    }
}

