package com.jac.cs.myapplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 1327527 on 2015-12-15.
 */
public class asgdetail {
    private static SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
    private static SimpleDateFormat uiFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");

    private String url;
    private String name;
    private Date dueDate;
    private int worth;
    private long courseid;

    public asgdetail() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void setDueDate(String dueDateStr) {
        try {
            this.dueDate = uiFormat.parse(dueDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public long getCourseid() {
        return courseid;
    }

    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }

    public String toJson() {
        /* ex:

        {
          "name": "TestAsg",
          "dueDate": "2015-12-24T12:00:00.000+0500",
           "worth":100,
           "courseid":1
        }

        */
        return serverFormat.format(dueDate);
    }

}
