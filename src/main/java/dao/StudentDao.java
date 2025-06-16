package src.dao;

import src.config.DatabaseConfig;
import src.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public void saveStudent(Student student) {
        String query = "INSERT INTO students (id, name, age, email) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = DatabaseConfig.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }

        return students;
    }
}