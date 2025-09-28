//creational pattern
package com.virtualclassroom.system;

public class StudentFactory {
    public static Student createStudent(String id) {
        return new Student(id);
    }
}
