package com.cs616.tables;

import javax.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enrollmentid")
    String enrollmentid;

    @Column(name = "studentid")
    String studentid;

    @Column(name = "courseid")
    String courseid;

    public String getEnrollmentid() { return enrollmentid; }

    public void setEnrollmentid(String enrollmentid) {
        this.enrollmentid = enrollmentid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }
}
