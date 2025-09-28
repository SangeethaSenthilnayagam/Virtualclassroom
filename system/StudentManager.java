package com.virtualclassroom.system;

public class StudentManager {
    public void enrollStudent(Classroom classroom, String studentId) {
        Student student = StudentFactory.createStudent(studentId);
        classroom.addStudent(student);
        LoggerUtil.log("Student " + studentId + " enrolled in " + classroom.getName());
    }
}
