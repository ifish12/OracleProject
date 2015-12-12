package com.cs616.tables;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assignments")
public class Assignments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assignmentid")
    private long id;

    @Column(name = "assignmentname")
    private String name;

    @Column(name = "duedate")
    private Date dueDate;

    @Column(name = "assignmentworth")
    private Integer worth;

    @Column(name = "courseid")
    private int courseid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getWorth() {
        return worth;
    }

    public void setWorth(Integer worth) {
        this.worth = worth;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }
}
