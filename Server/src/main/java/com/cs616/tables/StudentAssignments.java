package com.cs616.tables;



import javax.persistence.*;

@Entity
@Table(name = "studentassignments")
public class StudentAssignments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentassignmentid")
    private long id;

    @Column(name = "studentid")
    private String studentid;

    @Column(name = "assignmentid")
    private String assignmentid;

    @Column(name = "timespent")
    private String timespent;

    @Column(name = "goal")
    private String goal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getAssignmentid() {
        return assignmentid;
    }

    public void setAssignmentid(String assignmentid) {
        this.assignmentid = assignmentid;
    }

    public String getTimespent() {
        return timespent;
    }

    public void setTimespent(String timespent) {
        this.timespent = timespent;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
