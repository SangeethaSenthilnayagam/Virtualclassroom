//Structural pattern

package com.virtualclassroom.system;

public class AssignmentProxy {
    private final Assignment assignment;

    public AssignmentProxy(Assignment assignment) {
        this.assignment = assignment;
    }

    public void submit(String studentId) {
        // Proxy could check authorization, etc.
        assignment.submit();
        LoggerUtil.log("Assignment '" + assignment.getTitle() + "' submitted by Student " + studentId);
    }

    public Assignment getAssignment() { return assignment; }
}
