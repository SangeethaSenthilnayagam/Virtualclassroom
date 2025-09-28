package com.virtualclassroom.system;

public class AssignmentManager {
    private AssignmentSubmissionStrategy strategy = new ConcreteSubmissionStrategy();

    public void scheduleAssignment(Classroom classroom, String title) {
        Assignment assignment = new Assignment(title);
        classroom.addAssignment(assignment);
    }

    public void submitAssignment(Classroom classroom, String studentId, String title) throws AppException {
        Assignment assignment = classroom.getAssignments().stream()
                .filter(a -> a.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new AppException("Assignment not found."));
        strategy.submit(assignment, studentId);
    }
}
