import java.sql.*;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Connection con = DBConnector.getconnection();
        System.out.println("Connection Successful");

        StudentDAO dao = new StudentDAO();

        try (Scanner sc = new Scanner(System.in)) {

            while (true) {

                System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Update Student CGPA");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter your choice (1-6): ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Student ID: ");
                        int addId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Branch: ");
                        String branch = sc.nextLine();

                        System.out.print("Enter Year: ");
                        int year = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter CGPA: ");
                        float cgpa = sc.nextFloat();
                        sc.nextLine();

                        Student newStudent =
                                new Student(addId, name, branch, year, email, cgpa);

                        dao.addStudent(newStudent);
                        break;

                    case 2:
                        System.out.println("\nAll Student Records");
                        dao.viewStudent();
                        break;

                    case 3:
                        System.out.print("Enter Student ID and Name to search: ");
                        int searchId = sc.nextInt();
                        String searchName=sc.next();
                        sc.nextLine();

                        Student searchStudent =
                                new Student(searchId, searchName, null, 0, null, 0.0f);

                        dao.searchStudent(searchStudent);
                        break;

                    case 4:
                        System.out.print("Enter Student ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New CGPA: ");
                        float newCgpa = sc.nextFloat();
                        sc.nextLine();

                        Student updateStudent =
                                new Student(updateId, null, null, 0, null, newCgpa);

                        dao.updateStudent(updateStudent);
                        break;

                    case 5:
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();

                        Student deleteStudent =
                                new Student(deleteId, null, null, 0, null, 0.0f);

                        dao.deleteStudent(deleteStudent);
                        break;

                    case 6:
                        System.out.println("Exiting the application. Goodbye!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println(
                                "Invalid choice! Please select an option between 1 and 6.");
                }
            }

        } catch (Exception e) {
            System.out.println(
                    "An unexpected error occurred in the management application.");
            e.printStackTrace();
        }
    }
}