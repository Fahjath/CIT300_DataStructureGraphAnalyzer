package stack;

import models.Student;

public class StudentStackTest {

    public static void main(String[] args) {

        System.out.println("===== STACK TEST =====");

        StudentStack stack = new StudentStack(5);

        Student student1 =
                new Student(2001, "Kamal",
                        "Computer Science", 75.0);

        Student student2 =
                new Student(2002, "Nimal",
                        "Information Technology", 82.0);

        Student student3 =
                new Student(2003, "Saman",
                        "Software Engineering", 68.0);

        // Push
        System.out.println("\n--- PUSH ---");

        stack.push(student1);
        stack.push(student2);
        stack.push(student3);

        System.out.println("Three students pushed successfully.");

        // Display
        System.out.println("\n--- DISPLAY ---");
        stack.display();

        // Peek
        System.out.println("\n--- PEEK ---");

        Student topStudent = stack.peek();

        if (topStudent != null) {
            System.out.println("Top student:");
            System.out.println(topStudent);
        }

        // Pop
        System.out.println("\n--- POP ---");

        Student removed = stack.pop();

        if (removed != null) {
            System.out.println("Popped student:");
            System.out.println(removed);
        }

        // Display after pop
        System.out.println("\n--- AFTER POP ---");
        stack.display();

        // Empty stack test
        System.out.println("\n--- EMPTY STACK TEST ---");

        StudentStack emptyStack = new StudentStack(3);

        emptyStack.peek();
        emptyStack.pop();

        System.out.println("Empty stack test completed.");
    }
}