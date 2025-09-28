package com.virtualclassroom.system;

public class Assignment {
    private final String title;
    private boolean submitted;

    public Assignment(String title) {
        this.title = title;
        this.submitted = false;
    }

    public String getTitle() { return title; }
    public boolean isSubmitted() { return submitted; }
    public void submit() { submitted = true; }
}
