package array;

import models.Student;

public class StudentArray {

    private Student[] students;
    private int size;

    public StudentArray(int capacity) {
        students = new Student[capacity];
        size = 0;
    }

    // Insert a student
    public boolean insert(Student student) {

        if (size >= students.length) {
            System.out.println("Array is full. Student cannot be added.");
            return false;
        }

        // Check duplicate Student ID
        if (search(student.getStudentId()) != null) {
            System.out.println("Duplicate Student ID. Student was not added.");
            return false;
        }

        students[size] = student;
        size++;

        return true;
    }

    // Search a student by Student ID
    public Student search(int studentId) {

        for (int i = 0; i < size; i++) {

            if (students[i].getStudentId() == studentId) {
                return students[i];
            }
        }

        return null;
    }

    // Delete a student by Student ID
    public boolean delete(int studentId) {

        for (int i = 0; i < size; i++) {

            if (students[i].getStudentId() == studentId) {

                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[size - 1] = null;
                size--;

                return true;
            }
        }

        return false;
    }

    // Display all students
    public void display() {

        if (size == 0) {
            System.out.println("No students in the array.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    // Return the internal array for searching
    public Student[] getStudents() {
        return students;
    }

    // Return current number of students
    public int getSize() {
        return size;
    }
}