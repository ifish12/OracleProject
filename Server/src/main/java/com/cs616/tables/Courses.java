package com.cs616.tables;

import com.cs616.tables.Assignments;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseid")
    private long id;

    @Column(name = "coursecode")
    private String coursecode;

    @Column(name = "coursename")
    private String name;

    @Column(name = "teachername")
    private String teacher;

    @Column(name = "room")
    private String room;


    @OneToMany(mappedBy = "courseid", targetEntity = Assignments.class)
    private List<Assignments> assignments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public List<Assignments> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignments> assignments) {
        this.assignments = assignments;
    }
}
