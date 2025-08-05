package org.social.service;

import org.social.model.Student;
import org.social.dao.StudentDao;

public class StudentService {
    private final StudentDao studentDao = new StudentDao();

    public void addStudent(String name, int age) {
        if (age <= 0) {
            System.out.println("Age must be greater than 0.");
            return;
        }
        Student student = new Student(name, age);
        boolean added = studentDao.save(student);
        if (added) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Cannot add student. Storage full.");
        }
    }

    public void printAllStudents() {
        Student[] students = studentDao.findAll();
        boolean found = false;
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) System.out.println("No students found.");
    }

    public void findStudentById(int id) {
        Student student = studentDao.findById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
}
