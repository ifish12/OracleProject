package com.jac.cs.myapplication;

/**
 * Created by serena on 15-11-22.
 */
public class Course {


    private long     id;


    private String   classTitle;
    private long     classCatID;

    public Course() {

    }

    public Course(String classTitle, long classCatID) {
        this.classTitle = classTitle;
        this.classCatID = classCatID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return classTitle;
    }

    public void setTitle(String title) {
        this.classTitle = title;
    }



    public long getCatID() {
        return classCatID;
    }

    public void setCatID(long catID) {
        this.classCatID = catID;
    }

//    public String toString() {
//        return noteTitle;
//    }

    @Override
    public String toString() {
        return classTitle;
    }

}
