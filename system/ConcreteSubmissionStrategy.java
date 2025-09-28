package com.virtualclassroom.system;

public class ConcreteSubmissionStrategy implements AssignmentSubmissionStrategy {
    @Override
    public void submit(Assignment assignment, String studentId) {
        AssignmentProxy proxy = new AssignmentProxy(assignment);
        proxy.submit(studentId);
    }
}
