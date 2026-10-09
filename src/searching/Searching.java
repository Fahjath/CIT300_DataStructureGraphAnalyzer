package searching;

import models.Student;

public class Searching {

    // Linear Search
    public static Student linearSearch(Student[] students, int size, int studentId) {

        for (int i = 0; i < size; i++) {

            if (students[i].getStudentId() == studentId) {
                return students[i];
            }
        }

        return null;
    }

    // Binary Search
    // The array must be sorted by Student ID
    public static Student binarySearch(Student[] students, int size, int studentId) {

        int left = 0;
        int right = size - 1;

        while (left <= right) {

            int middle = (left + right) / 2;

            int middleId = students[middle].getStudentId();

            if (middleId == studentId) {
                return students[middle];
            }

            if (studentId < middleId) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return null;
    }
}