import exceptions.StudentNotFoundException;
import models.Student;
import services.StudentManager;
import services.StudentManagerImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de StudentManager
        StudentManager studentManager = (StudentManager) new StudentManagerImpl();

        // Agregar estudiantes
        studentManager.addStudent(new Student(1, "Michael López", 20));
        studentManager.addStudent(new Student(2, "Alberto García", 22));
        studentManager.addStudent(new Student(3, "Antonio Paz", 19));

        // Mostrar todos los estudiantes
        System.out.println("Lista completa de estudiantes:");
        List<Student> allStudents = studentManager.getAllStudents();
        allStudents.forEach(System.out::println);

        // Buscar estudiante por ID
        try {
            Student student = studentManager.findStudent(2);
            System.out.println("\nEstudiante encontrado: " + student);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }

        // Filtrar estudiantes mayores de 21 años
        System.out.println("\nEstudiantes mayores de 21 años:");
        allStudents.stream()
                .filter(s -> s.getAge() > 21)
                .forEach(System.out::println);

        // Ordenar estudiantes por nombre y mostrar la lista ordenada
        System.out.println("\nEstudiantes ordenados por nombre:");
        allStudents.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);

        // Eliminar estudiante por ID
        studentManager.removeStudent(1);
        System.out.println("\nLista de estudiantes después de eliminar al estudiante con ID 1:");
        studentManager.getAllStudents().forEach(System.out::println);
    }
}

