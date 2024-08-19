package services;
import exceptions.StudentNotFoundException;
import models.Student;
import customcollections.CustomList;

import java.util.List;
import java.util.Optional;

public class StudentManagerImpl implements StudentManager {
    private CustomList<Student> students;

    public StudentManagerImpl() {
        this.students = new CustomList<>();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(int id) {
        students.getAll().removeIf(student -> student.getId() == id);
    }

    @Override
    public Student findStudent(int id) throws StudentNotFoundException {
        Optional<Student> student = students.getAll().stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new StudentNotFoundException("Estudiante con ID " + id + " no encontrado.");
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return students.getAll();
    }
}

