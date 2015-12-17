package com.jac.cs.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class StudentAssignment {
    private String assignmentName;
    private String dueDate;
    private String timeSpent;
    private String worth;
    private String goal;
    private String studentId;
    private String assignmentId;

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public static String toJson(StudentAssignment a) {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"studentid\":" + "\"" + a.getStudentId() + "\",");
        sb.append("\"assignmentid\":" + "\"" + a.getAssignmentId() + "\",");
        sb.append("\"timespent\":" + "\"" + a.getTimeSpent() + "\",");
        sb.append("\"goal\":" + "\"" + a.getGoal() + "\"");
        sb.append("}");

        return sb.toString();
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getDueDate() {
        if (dueDate.equals("null")) {
            return "TBA";
        } else {
            return dueDate;
        }
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

        if(worth.equals("null")) {
            return "TBA";
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
