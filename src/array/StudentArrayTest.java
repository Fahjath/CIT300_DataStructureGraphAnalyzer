package array;

import models.Student;
import searching.Searching;

public class StudentArrayTest {

    public static void main(String[] args) {

        StudentArray studentArray = new StudentArray(10);

        System.out.println("===== ARRAY TEST =====");

        // Insert students
        studentArray.insert(
                new Student(1001, "Kamal", "Computer Science", 78.5));

        studentArray.insert(
                new Student(1002, "Nimal", "Information Technology", 85.0));

        studentArray.insert(
                new Student(1003, "Saman", "Software Engineering", 67.5));

        // Display
        System.out.println("\n===== DISPLAY STUDENTS =====");
        studentArray.display();

        // Array Search
        System.out.println("\n===== ARRAY SEARCH =====");

        Student found = studentArray.search(1002);

        if (found != null) {
            System.out.println("Student found:");
            System.out.println(found);
        } else {
            System.out.println("Student not found.");
        }

        // Linear Search
        System.out.println("\n===== LINEAR SEARCH =====");

        Student linearResult =
                Searching.linearSearch(
                        studentArray.getStudents(),
                        studentArray.getSize(),
                        1003);

        if (linearResult != null) {
            System.out.println("Linear Search found:");
            System.out.println(linearResult);
        } else {
            System.out.println("Student not found.");
        }

        // Binary Search
        System.out.println("\n===== BINARY SEARCH =====");

        Student binaryResult =
                Searching.binarySearch(
                        studentArray.getStudents(),
                        studentArray.getSize(),
                        1002);

        if (binaryResult != null) {
            System.out.println("Binary Search found:");
            System.out.println(binaryResult);
        } else {
            System.out.println("Student not found.");
        }

        // Delete
        System.out.println("\n===== DELETE STUDENT =====");

        boolean deleted = studentArray.delete(1002);

        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }

        // Display after deletion
        System.out.println("\n===== AFTER DELETE =====");
        studentArray.display();

        // Duplicate test
        System.out.println("\n===== DUPLICATE ID TEST =====");

        boolean duplicateAdded =
                studentArray.insert(
                        new Student(1001, "Another Student",
                                "Information Technology", 90.0));

        if (!duplicateAdded) {
            System.out.println("Duplicate Student ID test passed.");
        }
    }
}