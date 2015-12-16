package com.jac.cs.myapplication;

/**
 * Created by mahhcks on 2015-12-16.
 */
public class StudentAssignment {
    private String assignmentName;
    private String dueDate;
    private String timeSpent;
    private String worth;
    private String goal;

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getWorth() {
        if (worth == null) {
            return "TBD";
        } else {
            return worth;
        }
    }

    public void setWorth(String worth) {
        this.worth = worth;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
