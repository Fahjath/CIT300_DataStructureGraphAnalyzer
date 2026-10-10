package app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import models.Student;
import array.StudentArray;
import stack.StudentStack;
import queue.StudentQueue;
import linkedlist.StudentLinkedList;
import searching.Searching;
import graph.CampusGraph;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    // Main data structures
    private static final StudentArray studentArray =
            new StudentArray(100);

    private static final StudentLinkedList linkedList =
            new StudentLinkedList();

    private static final StudentStack stack =
            new StudentStack(100);

    private static final StudentQueue queue =
            new StudentQueue(100);

    private static final CampusGraph graph =
            new CampusGraph();

    public static void main(String[] args) {

        // Add some default graph data for demonstration
        addSampleGraph();

        boolean running = true;

        System.out.println("=============================================");
        System.out.println("       DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");

        while (running) {

            showMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    arrayMenu();
                    break;

                case 2:
                    stackMenu();
                    break;

                case 3:
                    queueMenu();
                    break;

                case 4:
                    linkedListMenu();
                    break;

                case 5:
                    searchingMenu();
                    break;

                case 6:
                    graphMenu();
                    break;

                case 7:
                    performanceMenu();
                    break;

                case 8:
                    displayAllResults();
                    break;

                case 9:
                    running = false;
                    System.out.println("\nProgram ended successfully.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please enter 1-9."
                    );
            }
        }

        scanner.close();
    }

    // =========================================================
    // MAIN MENU
    // =========================================================

    private static void showMainMenu() {

        System.out.println("\n=============================================");
        System.out.println("                 MAIN MENU");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance / Complexity");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
        System.out.println("=============================================");
    }

    // =========================================================
    // ARRAY OPERATIONS
    // =========================================================

    private static void arrayMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display Students");
            System.out.println("5. Return to Main Menu");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    deleteStudent();
                    break;

                case 3:
                    searchStudentInArray();
                    break;

                case 4:
                    studentArray.display();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =========================================================
    // ADD STUDENT
    // =========================================================

    private static void addStudent() {

        System.out.println("\n--------------- ADD STUDENT ---------------");

        int id = readPositiveInt("Enter Student ID: ");

        // Check duplicate
        if (studentArray.search(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        String name = readText("Enter Name: ");

        String programme =
                readText("Enter Programme: ");

        double marks =
                readMarks("Enter Marks (0-100): ");

        Student student =
                new Student(id, name, programme, marks);

        // Add to array
        boolean arrayAdded =
                studentArray.insert(student);

        // Add to linked list
        boolean listAdded = false;

        if (arrayAdded) {
            listAdded =
                    linkedList.addStudent(student);
        }

        if (arrayAdded && listAdded) {

            // Keep the student as a recent action
            stack.push(student);

            System.out.println(
                    "Student added successfully."
            );

        } else {

            // Roll back if something failed
            if (arrayAdded) {
                studentArray.delete(id);
            }

            System.out.println(
                    "Student could not be added."
            );
        }
    }

    // =========================================================
    // DELETE STUDENT
    // =========================================================

    private static void deleteStudent() {

        System.out.println("\n--------------- DELETE STUDENT ---------------");

        int id =
                readPositiveInt(
                        "Enter Student ID to delete: "
                );

        Student student =
                studentArray.search(id);

        if (student == null) {

            System.out.println(
                    "Student not found."
            );

            return;
        }

        boolean arrayDeleted =
                studentArray.delete(id);

        boolean listDeleted =
                linkedList.deleteStudent(id);

        if (arrayDeleted && listDeleted) {

            // Store deleted student in stack
            stack.push(student);

            System.out.println(
                    "Student deleted successfully."
            );

            System.out.println(
                    "Deleted student was added to the action stack."
            );

        } else {

            System.out.println(
                    "Student could not be deleted completely."
            );
        }
    }

    // =========================================================
    // ARRAY SEARCH
    // =========================================================

    private static void searchStudentInArray() {

        int id =
                readPositiveInt(
                        "Enter Student ID to search: "
                );

        Student student =
                studentArray.search(id);

        if (student != null) {

            System.out.println(
                    "Student found:"
            );

            System.out.println(student);

        } else {

            System.out.println(
                    "Student not found."
            );
        }
    }

    // =========================================================
    // STACK OPERATIONS
    // =========================================================

    private static void stackMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push Student");
            System.out.println("2. Pop Student");
            System.out.println("3. Peek Student");
            System.out.println("4. Display Stack");
            System.out.println("5. Return to Main Menu");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    int pushId =
                            readPositiveInt(
                                    "Enter existing Student ID: "
                            );

                    Student pushStudent =
                            studentArray.search(pushId);

                    if (pushStudent == null) {

                        System.out.println(
                                "Student not found in the system."
                        );

                    } else {

                        if (stack.push(pushStudent)) {

                            System.out.println(
                                    "Student pushed onto the stack."
                            );
                        }
                    }

                    break;

                case 2:

                    Student popped =
                            stack.pop();

                    if (popped != null) {

                        System.out.println(
                                "Popped student:"
                        );

                        System.out.println(popped);
                    }

                    break;

                case 3:

                    Student top =
                            stack.peek();

                    if (top != null) {

                        System.out.println(
                                "Top student:"
                        );

                        System.out.println(top);
                    }

                    break;

                case 4:

                    stack.display();

                    break;

                case 5:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =========================================================
    // QUEUE OPERATIONS
    // =========================================================

    private static void queueMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue Student Service Request");
            System.out.println("2. Dequeue Next Request");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display Queue");
            System.out.println("5. Return to Main Menu");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    int queueId =
                            readPositiveInt(
                                    "Enter existing Student ID: "
                            );

                    Student queueStudent =
                            studentArray.search(queueId);

                    if (queueStudent == null) {

                        System.out.println(
                                "Student not found in the system."
                        );

                    } else {

                        if (queue.enqueue(queueStudent)) {

                            System.out.println(
                                    "Student service request "
                                    + "added to queue."
                            );
                        }
                    }

                    break;

                case 2:

                    Student served =
                            queue.dequeue();

                    if (served != null) {

                        System.out.println(
                                "Processed service request:"
                        );

                        System.out.println(served);
                    }

                    break;

                case 3:

                    Student front =
                            queue.peek();

                    if (front != null) {

                        System.out.println(
                                "Front request:"
                        );

                        System.out.println(front);
                    }

                    break;

                case 4:

                    queue.display();

                    break;

                case 5:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =========================================================
    // LINKED LIST OPERATIONS
    // =========================================================

    private static void linkedListMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n------------ LINKED LIST OPERATIONS ------------");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display Students");
            System.out.println("5. Return to Main Menu");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    addStudent();

                    break;

                case 2:

                    deleteStudent();

                    break;

                case 3:

                    int id =
                            readPositiveInt(
                                    "Enter Student ID to search: "
                            );

                    Student found =
                            linkedList.findStudent(id);

                    if (found != null) {

                        System.out.println(
                                "Student found:"
                        );

                        System.out.println(found);

                    } else {

                        System.out.println(
                                "Student not found."
                        );
                    }

                    break;

                case 4:

                    linkedList.displayStudents();

                    break;

                case 5:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =========================================================
    // SEARCHING MENU
    // =========================================================

    private static void searchingMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n------------- SEARCHING OPERATIONS -------------");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear and Binary Search");
            System.out.println("4. Return to Main Menu");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    linearSearch();

                    break;

                case 2:

                    binarySearch();

                    break;

                case 3:

                    compareSearches();

                    break;

                case 4:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =========================================================
    // LINEAR SEARCH
    // =========================================================

    private static void linearSearch() {

        if (studentArray.getSize() == 0) {

            System.out.println(
                    "No students available."
            );

            return;
        }

        int id =
                readPositiveInt(
                        "Enter Student ID: "
                );

        long start =
                System.nanoTime();

        Student result =
                Searching.linearSearch(
                        studentArray.getStudents(),
                        studentArray.getSize(),
                        id
                );

        long end =
                System.nanoTime();

        if (result != null) {

            System.out.println(
                    "\nLinear Search Result:"
            );

            System.out.println(result);

        } else {

            System.out.println(
                    "Student not found."
            );
        }

        System.out.println(
                "Execution time: "
                        + (end - start)
                        + " ns"
        );

        System.out.println(
                "Time Complexity: O(n)"
        );
    }

    // =========================================================
    // BINARY SEARCH
    // =========================================================

    private static void binarySearch() {

        if (studentArray.getSize() == 0) {

            System.out.println(
                    "No students available."
            );

            return;
        }

        int id =
                readPositiveInt(
                        "Enter Student ID: "
                );

        // Binary search requires sorted data
        Student[] sortedStudents =
                getSortedStudents();

        long start =
                System.nanoTime();

        Student result =
                Searching.binarySearch(
                        sortedStudents,
                        sortedStudents.length,
                        id
                );

        long end =
                System.nanoTime();

        if (result != null) {

            System.out.println(
                    "\nBinary Search Result:"
            );

            System.out.println(result);

        } else {

            System.out.println(
                    "Student not found."
            );
        }

        System.out.println(
                "Execution time: "
                        + (end - start)
                        + " ns"
        );

        System.out.println(
                "Time Complexity: O(log n)"
        );

        System.out.println(
                "Binary Search uses student IDs "
                        + "in sorted order."
        );
    }

    // =========================================================
    // COMPARE SEARCHES
    // =========================================================

    private static void compareSearches() {

        if (studentArray.getSize() == 0) {

            System.out.println(
                    "No students available."
            );

            return;
        }

        int id =
                readPositiveInt(
                        "Enter Student ID to compare: "
                );

        Student[] sortedStudents =
                getSortedStudents();

        // Linear Search
        long linearStart =
                System.nanoTime();

        Student linearResult =
                Searching.linearSearch(
                        studentArray.getStudents(),
                        studentArray.getSize(),
                        id
                );

        long linearEnd =
                System.nanoTime();

        // Binary Search
        long binaryStart =
                System.nanoTime();

        Student binaryResult =
                Searching.binarySearch(
                        sortedStudents,
                        sortedStudents.length,
                        id
                );

        long binaryEnd =
                System.nanoTime();

        System.out.println("\n=============================================");
        System.out.println("        SEARCH PERFORMANCE COMPARISON");
        System.out.println("=============================================");

        System.out.println(
                "Student ID: " + id
        );

        System.out.println("\nLinear Search:");

        System.out.println(
                "Result: "
                        + (linearResult != null
                        ? "Found"
                        : "Not Found")
        );

        System.out.println(
                "Execution time: "
                        + (linearEnd - linearStart)
                        + " ns"
        );

        System.out.println(
                "Complexity: O(n)"
        );

        System.out.println("\nBinary Search:");

        System.out.println(
                "Result: "
                        + (binaryResult != null
                        ? "Found"
                        : "Not Found")
        );

        System.out.println(
                "Execution time: "
                        + (binaryEnd - binaryStart)
                        + " ns"
        );

        System.out.println(
                "Complexity: O(log n)"
        );

        System.out.println("\nExplanation:");

        System.out.println(
                "Linear Search checks records one by one."
        );

        System.out.println(
                "Binary Search repeatedly divides "
                        + "the sorted data into halves."
        );
    }

    // =========================================================
    // SORT STUDENTS FOR BINARY SEARCH
    // =========================================================

    private static Student[] getSortedStudents() {

        Student[] sorted =
                Arrays.copyOf(
                        studentArray.getStudents(),
                        studentArray.getSize()
                );

        Arrays.sort(
                sorted,
                Comparator.comparingInt(
                        Student::getStudentId
                )
        );

        return sorted;
    }

    // =========================================================
    // GRAPH MENU
    // =========================================================

    private static void graphMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. Search Vertex");
            System.out.println("5. BFS Traversal");
            System.out.println("6. DFS Traversal");
            System.out.println("7. Return to Main Menu");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    String vertex =
                            readText(
                                    "Enter campus location: "
                            );

                    if (graph.addVertex(vertex)) {

                        System.out.println(
                                "Vertex added successfully."
                        );

                    } else {

                        System.out.println(
                                "Vertex could not be added."
                                        + " It may already exist "
                                        + "or be invalid."
                        );
                    }

                    break;

                case 2:

                    String location1 =
                            readText(
                                    "Enter first location: "
                            );

                    String location2 =
                            readText(
                                    "Enter second location: "
                            );

                    if (graph.addEdge(
                            location1,
                            location2)) {

                        System.out.println(
                                "Edge added successfully."
                        );

                    } else {

                        System.out.println(
                                "Edge could not be added."
                                        + " Check that both vertices "
                                        + "exist and are different."
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                            "\nCampus Graph:"
                    );

                    graph.displayGraph();

                    break;

                case 4:

                    String searchVertex =
                            readText(
                                    "Enter location to search: "
                            );

                    if (graph.searchVertex(
                            searchVertex)) {

                        System.out.println(
                                "Vertex found."
                        );

                    } else {

                        System.out.println(
                                "Vertex not found."
                        );
                    }

                    break;

                case 5:

                    String bfsStart =
                            readText(
                                    "Enter BFS starting location: "
                            );

                    graph.bfs(bfsStart);

                    break;

                case 6:

                    String dfsStart =
                            readText(
                                    "Enter DFS starting location: "
                            );

                    graph.dfs(dfsStart);

                    break;

                case 7:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =========================================================
    // SAMPLE GRAPH
    // =========================================================

    private static void addSampleGraph() {

        graph.addVertex("Library");

        graph.addVertex("Cafeteria");

        graph.addVertex("Lecture Hall");

        graph.addVertex("Laboratory");

        graph.addVertex("Main Gate");

        graph.addEdge(
                "Library",
                "Cafeteria"
        );

        graph.addEdge(
                "Library",
                "Lecture Hall"
        );

        graph.addEdge(
                "Cafeteria",
                "Laboratory"
        );

        graph.addEdge(
                "Lecture Hall",
                "Main Gate"
        );
    }

    // =========================================================
    // PERFORMANCE / COMPLEXITY
    // =========================================================

    private static void performanceMenu() {

        System.out.println("\n=============================================");
        System.out.println("        PERFORMANCE / COMPLEXITY");
        System.out.println("=============================================");

        System.out.println(
                "Array Search:             O(n)"
        );

        System.out.println(
                "Array Delete:             O(n)"
        );

        System.out.println(
                "Stack Push:               O(1)"
        );

        System.out.println(
                "Stack Pop:                O(1)"
        );

        System.out.println(
                "Stack Peek:               O(1)"
        );

        System.out.println(
                "Queue Enqueue:            O(1)"
        );

        System.out.println(
                "Queue Dequeue:            O(1)"
        );

        System.out.println(
                "Queue Peek:               O(1)"
        );

        System.out.println(
                "Linked List Search:       O(n)"
        );

        System.out.println(
                "Linked List Delete:       O(n)"
        );

        System.out.println(
                "Linked List Insert End:   O(n)"
        );

        System.out.println(
                "Linear Search:            O(n)"
        );

        System.out.println(
                "Binary Search:            O(log n)"
        );

        System.out.println(
                "Graph BFS:                O(V + E)"
        );

        System.out.println(
                "Graph DFS:                O(V + E)"
        );

        System.out.println(
                "\nTheoretical complexity comparison:"
        );

        System.out.println(
                "Linear Search  -> O(n)"
        );

        System.out.println(
                "Binary Search  -> O(log n)"
        );

        System.out.println(
                "BFS             -> O(V + E)"
        );

        System.out.println(
                "DFS             -> O(V + E)"
        );

        System.out.println(
                "\nFor actual search timing:"
        );

        System.out.println(
                "Main Menu -> Searching -> "
                        + "Compare Linear and Binary Search"
        );
    }

    // =========================================================
    // DISPLAY ALL RESULTS
    // =========================================================

    private static void displayAllResults() {

        System.out.println("\n=============================================");
        System.out.println("             ALL CURRENT RESULTS");
        System.out.println("=============================================");

        System.out.println("\n--- ARRAY ---");

        studentArray.display();

        System.out.println("\n--- LINKED LIST ---");

        linkedList.displayStudents();

        System.out.println("\n--- STACK ---");

        stack.display();

        System.out.println("\n--- QUEUE ---");

        queue.display();

        System.out.println("\n--- GRAPH ---");

        graph.displayGraph();

        System.out.println("\n--- COMPLEXITY ---");

        System.out.println(
                "Array Search: O(n)"
        );

        System.out.println(
                "Stack Push/Pop/Peek: O(1)"
        );

        System.out.println(
                "Queue Enqueue/Dequeue/Peek: O(1)"
        );

        System.out.println(
                "Linked List Search/Delete: O(n)"
        );

        System.out.println(
                "Linear Search: O(n)"
        );

        System.out.println(
                "Binary Search: O(log n)"
        );

        System.out.println(
                "BFS: O(V + E)"
        );

        System.out.println(
                "DFS: O(V + E)"
        );
    }

    // =========================================================
    // INPUT VALIDATION - INTEGER
    // =========================================================

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. "
                                + "Please enter a whole number."
                );
            }
        }
    }

    // =========================================================
    // INPUT VALIDATION - POSITIVE INTEGER
    // =========================================================

    private static int readPositiveInt(
            String message) {

        while (true) {

            int value =
                    readInt(message);

            if (value > 0) {

                return value;
            }

            System.out.println(
                    "Value must be greater than 0."
            );
        }
    }

    // =========================================================
    // INPUT VALIDATION - MARKS
    // =========================================================

    private static double readMarks(
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            try {

                double marks =
                        Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) {

                    return marks;
                }

                System.out.println(
                        "Marks must be between 0 and 100."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid marks. "
                                + "Please enter a number."
                );
            }
        }
    }

    // =========================================================
    // INPUT VALIDATION - TEXT
    // =========================================================

    private static String readText(
            String message) {

        while (true) {

            System.out.print(message);

            String value =
                    scanner.nextLine().trim();

            if (!value.isEmpty()) {

                return value;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }
}