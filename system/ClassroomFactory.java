//Creational Pattern
package com.virtualclassroom.system;

public class ClassroomFactory {
    public static Classroom createClassroom(String name) {
        return new Classroom(name);
    }
}
