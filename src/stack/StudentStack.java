package stack;

import models.Student;

public class StudentStack {

    private Student[] stack;
    private int top;

    public StudentStack(int capacity) {
        stack = new Student[capacity];
        top = -1;
    }

    // Push a student onto the stack
    public boolean push(Student student) {

        if (top == stack.length - 1) {
            System.out.println("Stack is full.");
            return false;
        }

        stack[++top] = student;
        return true;
    }

    // Pop the top student
    public Student pop() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }

        Student student = stack[top];
        stack[top] = null;
        top--;

        return student;
    }

    // View the top student
    public Student peek() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }

        return stack[top];
    }

    // Display all students
    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack contents:");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check whether stack is full
    public boolean isFull() {
        return top == stack.length - 1;
    }

    // Return stack size
    public int size() {
        return top + 1;
    }
}