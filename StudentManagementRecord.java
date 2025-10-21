
import java.util.*;

public class StudentManagementRecord {
    static class Student {
        private int id;
        private String name;
        private double marks;

        public Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getMarks() {
            return marks;
        }

        public void setMarks(double marks) {
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
        }
    }

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("✅ Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("\n--- Student List ---");
            students.forEach(System.out::println);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new marks: ");
                double newMarks = sc.nextDouble();

                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}