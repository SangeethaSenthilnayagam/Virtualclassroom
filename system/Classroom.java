package com.virtualclassroom.system;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private final String name;
    private final List<Student> students;
    private final List<Assignment> assignments;
    private final List<Observer> observers;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
        notifyObservers("Student " + student.getId() + " enrolled in " + name);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
        notifyObservers("Assignment scheduled for " + name + ": " + assignment.getTitle());
    }

    public List<Student> getStudents() { return students; }
    public List<Assignment> getAssignments() { return assignments; }

    public void registerObserver(Observer observer) { observers.add(observer); }
    public void notifyObservers(String message) {
        for (Observer o : observers) o.update(message);
    }
}
