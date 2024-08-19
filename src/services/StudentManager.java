package services;

import exceptions.StudentNotFoundException;
import models.Student;

import java.util.List;

public interface StudentManager {
    void addStudent(Student student);
    void removeStudent(int id);
    Student findStudent(int id) throws StudentNotFoundException;
    List<Student> getAllStudents();
}

