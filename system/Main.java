package com.virtualclassroom.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassroomManager classroomManager = new ClassroomManager();
        StudentManager studentManager = new StudentManager();
        AssignmentManager assignmentManager = new AssignmentManager();

        Scanner sc = new Scanner(System.in);

        LoggerUtil.log("Virtual Classroom Manager Started...");

        boolean running = true;
        while(running) {
            
            System.out.println("1. add_classroom <ClassName>");
            System.out.println("2. add_student <StudentID> <ClassName>");
            System.out.println("3. schedule_assignment <ClassName> <Assignment>");
            System.out.println("4. submit_assignment <StudentID> <ClassName> <Assignment>");
            System.out.println("5. exit");
            System.out.println("=============================================");
           
            System.out.print("\nEnter command: ");
            String input = sc.nextLine().trim();

            try {
                if(input.startsWith("add_classroom")) {
                    String[] parts = input.split(" ",2);
                    classroomManager.addClassroom(parts[1]);
                } else if(input.startsWith("add_student")) {
                    String[] parts = input.split(" ",3);
                    Classroom c = classroomManager.getClassroom(parts[2]);
                    studentManager.enrollStudent(c, parts[1]);
                } else if(input.startsWith("schedule_assignment")) {
                    String[] parts = input.split(" ",3);
                    Classroom c = classroomManager.getClassroom(parts[1]);
                    assignmentManager.scheduleAssignment(c, parts[2]);
                } else if(input.startsWith("submit_assignment")) {
                    String[] parts = input.split(" ",4);
                    Classroom c = classroomManager.getClassroom(parts[2]);
                    assignmentManager.submitAssignment(c, parts[1], parts[3]);
                } else if(input.equals("exit")) {
                    running = false;
                    LoggerUtil.log("Exiting Virtual Classroom Manager...");
                } else {
                    LoggerUtil.log("Invalid command.");
                }
            } catch(Exception e) {
                LoggerUtil.log("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
