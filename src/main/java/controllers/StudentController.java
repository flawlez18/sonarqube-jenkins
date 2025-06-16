package src.controllers;

import src.dao.StudentDao;
import src.models.Student;
import src.utils.InputValidator;

import java.util.Scanner;

public class StudentController {
    private final StudentDao studentDao = new StudentDao();

    public void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email format!");
            return;
        }

        Student student = new Student(id, name, age, email);
        studentDao.saveStudent(student);
        System.out.println("Student added successfully!");
    }

    public void viewAllStudents() {
        studentDao.getAllStudents().forEach(System.out::println);
    }
}