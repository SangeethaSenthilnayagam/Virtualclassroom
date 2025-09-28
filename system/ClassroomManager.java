package com.virtualclassroom.system;

import java.util.HashMap;
import java.util.Map;

public class ClassroomManager {
    private final Map<String, Classroom> classrooms = new HashMap<>();

    public void addClassroom(String name) throws AppException {
        if(classrooms.containsKey(name)) throw new AppException("Classroom already exists.");
        Classroom classroom = ClassroomFactory.createClassroom(name);
        classroom.registerObserver(LoggerUtil::log);
        classrooms.put(name, classroom);
        LoggerUtil.log("Classroom " + name + " has been created.");
    }

    public Classroom getClassroom(String name) throws AppException {
        Classroom c = classrooms.get(name);
        if(c == null) throw new AppException("Classroom does not exist.");
        return c;
    }

    public void listClassrooms() {
        if(classrooms.isEmpty()) {
            LoggerUtil.log("No classrooms available.");
            return;
        }
        classrooms.keySet().forEach(name -> LoggerUtil.log("Classroom: " + name));
    }
}
