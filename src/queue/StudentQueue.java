package queue;

import models.Student;

public class StudentQueue {

    private Student[] queue;
    private int front;
    private int rear;
    private int size;

    public StudentQueue(int capacity) {
        queue = new Student[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add student to the queue
    public boolean enqueue(Student student) {

        if (isFull()) {
            System.out.println("Queue is full.");
            return false;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = student;
        size++;

        return true;
    }

    // Remove student from the front
    public Student dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        Student student = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        return student;
    }

    // View the front student
    public Student peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        return queue[front];
    }

    // Display all students
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue contents:");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.println(queue[index]);
        }
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check whether queue is full
    public boolean isFull() {
        return size == queue.length;
    }

    // Return queue size
    public int size() {
        return size;
    }
}