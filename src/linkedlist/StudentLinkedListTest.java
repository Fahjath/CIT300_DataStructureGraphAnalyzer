package linkedlist;

import models.Student;

public class StudentLinkedListTest {

    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        Student student1 =
                new Student(1001, "Ahmed", "Computer Science", 78.5);

        Student student2 =
                new Student(1002, "Aisha", "Information Technology", 85.0);

        Student student3 =
                new Student(1003, "Kamal", "Software Engineering", 69.5);

        // INSERT
        System.out.println("=== INSERT STUDENTS ===");

        System.out.println("Student 1 added: "
                + list.addStudent(student1));

        System.out.println("Student 2 added: "
                + list.addStudent(student2));

        System.out.println("Student 3 added: "
                + list.addStudent(student3));

        // DISPLAY
        System.out.println("\n=== DISPLAY STUDENTS ===");
        list.displayStudents();

        // SEARCH
        System.out.println("\n=== SEARCH STUDENT ===");

        Student found = list.findStudent(1002);

        if (found != null) {
            System.out.println("Student found:");
            System.out.println(found);
        } else {
            System.out.println("Student not found.");
        }

        // SEARCH NON-EXISTING STUDENT
        System.out.println("\n=== SEARCH NON-EXISTING STUDENT ===");

        Student notFound = list.findStudent(9999);

        if (notFound != null) {
            System.out.println(notFound);
        } else {
            System.out.println("Student 9999 not found.");
        }

        // DELETE
        System.out.println("\n=== DELETE STUDENT ===");

        boolean deleted = list.deleteStudent(1002);

        System.out.println("Student 1002 deleted: " + deleted);

        // DISPLAY AFTER DELETE
        System.out.println("\n=== DISPLAY AFTER DELETE ===");
        list.displayStudents();

        // EMPTY CHECK
        System.out.println("\n=== EMPTY CHECK ===");
        System.out.println("Is list empty? " + list.isEmpty());
    }
}