package com.jac.cs.myapplication;

import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 1327527 on 2015-12-15.
 */
public class Asgdetail {
    private static SimpleDateFormat serverFormat = new SimpleDateFormat("hh:mm:ss.SSSZ");
    private static SimpleDateFormat uiFormat = new SimpleDateFormat("hh:mm");

    private String url;
    private String studentid;
    private String assignmentid;
    private Date timeGoal;

    public Asgdetail() {
    }

    public String getAssignmentid() {
        return assignmentid;
    }

    public void setAssignmentid(String assignmentid) {
        this.assignmentid = assignmentid;
    }

    public Date getTimeGoal() {
        return timeGoal;
    }

    public void setTimeGoal(String timeGoal) {
        try {
            this.timeGoal = uiFormat.parse(timeGoal);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String toJson() {

        //HttpResponse response = HttpJsonRequest.make(PREFIX + "/post", "POST", post.toJson());
         /*ex:

        {
          "name": "TestAsg",
          "dueDate": "2015-12-24T12:00:00.000+0500",
           "worth":100,
           "courseid":1
        }*/



        return serverFormat.format(timeGoal);
    }

}
