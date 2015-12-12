package com.jac.cs.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serena on 15-11-22.
 */
public class Course {



    public static List<Course> fromJson(JSONArray root) throws JSONException {
        List<Course> users = new ArrayList<>();
        for(int i = 0; i < root.length(); i++)
            users.add(fromJson(root.getJSONObject(i), i));
        return users;
    }

    /**
     * Create a User object from a JSONObject
     * @param root
     * @return
     */
    public static Course fromJson(JSONObject root, int count) throws JSONException {
        Course temp = new Course();

        temp.setCourseCode(root.getString("coursecode"));
        temp.setCourseTitle(root.getString("name"));
        temp.setCourseTeacher(root.getString("teacher"));
        temp.setCourseRoom(root.getString("room"));
        temp.setCourseURL(root.getJSONObject("_links").getJSONObject("self").getString("href"));
        temp.setId(count);

        return temp;

    }



    private long     id;
    private String   courseCode;
    private String   courseTeacher;
    private String   courseRoom;
    private String   courseURL;
    private String   courseTitle;

    public void setId(int i) {
        this.id = (long)i;
    }

    public long getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;

    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }


    public String getCourseURL() {
        return courseURL;
    }

    public void setCourseURL(String courseURL) {
        this.courseURL = courseURL;
    }



    //private long     classCatID;

    public Course() {

    }

//    public Course(String classTitle, long classCatID) {
//        this.classTitle = classTitle;
//        this.classCatID = classCatID;
//    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return classTitle;
//    }
//
//    public void setTitle(String title) {
//        this.classTitle = title;
//    }
//
//
//
//    public long getCatID() {
//        return classCatID;
//    }
//
//    public void setCatID(long catID) {
//        this.classCatID = catID;
//    }

//    public String toString() {
//        return noteTitle;
//    }

    @Override
    public String toString() {
        return courseTitle;
    }

}
