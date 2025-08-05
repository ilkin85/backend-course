package org.social;

import org.social.controller.StudentController;


public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        controller.run();
    }
}