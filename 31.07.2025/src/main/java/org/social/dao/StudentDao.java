package org.social.dao;

import org.social.model.Student;

public class StudentDao {
    private static final int SIZE = 100;
    private final Student[] students = new Student[SIZE];
    private int index = 0;

    public boolean save(Student student) {
        if (index >= SIZE) return false;
        student.setId(index + 1);
        students[index++] = student;
        return true;
    }

    public Student[] findAll() {
        return students;
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student != null && student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
