package queue;

import models.Student;

public class StudentQueueTest {

    public static void main(String[] args) {

        System.out.println("===== QUEUE TEST =====");

        StudentQueue queue = new StudentQueue(5);

        Student student1 =
                new Student(3001, "Ravi",
                        "Computer Science", 72.0);

        Student student2 =
                new Student(3002, "Kumar",
                        "Information Technology", 81.0);

        Student student3 =
                new Student(3003, "Arun",
                        "Software Engineering", 69.0);

        // Enqueue
        System.out.println("\n--- ENQUEUE ---");

        queue.enqueue(student1);
        queue.enqueue(student2);
        queue.enqueue(student3);

        System.out.println("Three students added to queue.");

        // Display
        System.out.println("\n--- DISPLAY ---");
        queue.display();

        // Peek
        System.out.println("\n--- PEEK / FRONT ---");

        Student frontStudent = queue.peek();

        if (frontStudent != null) {
            System.out.println("Front student:");
            System.out.println(frontStudent);
        }

        // Dequeue
        System.out.println("\n--- DEQUEUE ---");

        Student removed = queue.dequeue();

        if (removed != null) {
            System.out.println("Dequeued student:");
            System.out.println(removed);
        }

        // Display after dequeue
        System.out.println("\n--- AFTER DEQUEUE ---");
        queue.display();

        // Empty queue test
        System.out.println("\n--- EMPTY QUEUE TEST ---");

        StudentQueue emptyQueue = new StudentQueue(3);

        emptyQueue.peek();
        emptyQueue.dequeue();

        System.out.println("Empty queue test completed.");
    }
}