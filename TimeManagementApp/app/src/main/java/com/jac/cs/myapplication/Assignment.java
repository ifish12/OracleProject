package com.jac.cs.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Assignment {

    public static List<Assignment> fromJson(JSONArray root) throws JSONException {
        List<Assignment> result = new ArrayList<>();
        for(int i = 0; i < root.length(); i++)
            result.add(fromJson(root.getJSONObject(i), i));
        return result;
    }

    public static Assignment fromJson(JSONObject root, int count) throws JSONException {
        Assignment temp = new Assignment();
        temp.setId(count);
        temp.setCourseId(root.getString("courseid"));
        temp.setName(root.getString("name"));
        temp.setDueDate(root.getString("dueDate"));
        temp.setWorth(root.getString("worth"));
        temp.setAssignmentURL(root.getJSONObject("_links").getJSONObject("self").getString("href"));
        return temp;
    }

    private long id;
    private String courseId;
    private String name;
    private String dueDate;
    private String worth;
    private String assignmentURL;

    public String getAssignmentURL() {
        return assignmentURL;
    }

    public void setAssignmentURL(String assignmentURL) {
        this.assignmentURL = assignmentURL;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorth() {
        return worth;
    }

    public void setWorth(String worth) {
        this.worth = worth;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String duedate) {
        this.dueDate = duedate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
