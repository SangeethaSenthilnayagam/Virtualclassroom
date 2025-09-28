//structural pattern
package com.virtualclassroom.system;

public class AssignmentDecorator extends Assignment {
    private final Assignment baseAssignment;

    public AssignmentDecorator(Assignment assignment) {
        super(assignment.getTitle());
        this.baseAssignment = assignment;
    }

    @Override
    public void submit() {
        LoggerUtil.log("Decorator: Submitting assignment " + baseAssignment.getTitle());
        baseAssignment.submit();
    }
}
