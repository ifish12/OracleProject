package com.jac.cs.myapplication.async;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import com.jac.cs.myapplication.Assignment;
import com.jac.cs.myapplication.Course;
import com.jac.cs.myapplication.R;
import com.jac.cs.myapplication.StudentAssignment;
import com.jac.cs.myapplication.async.AsyncResponse;
import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.List;

public class GetAllStudentAssignments extends AsyncTask<String, Void, StudentAssignment> {

    private Activity activity;



    private AsyncResponse<StudentAssignment> delegate;

    public GetAllStudentAssignments(AsyncResponse<StudentAssignment> delegate, Activity a) {
        activity = a;
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(StudentAssignment courses) {
        delegate.onAsyncPostExecute(courses);
    }

    @Override
    protected StudentAssignment doInBackground(String... params) {

        //String studentId = params[0];

        StudentAssignment studentAssignment = new StudentAssignment();
        try {
            HttpResponse response = HttpJsonRequest.make("http://159.203.29.133:9998/studentassignments/" + "1", "GET");
            JSONObject root = new JSONObject(new JSONTokener(response.getBody()));

            String assignmentId = root.getString("assignmentid");
            String timeSpent = root.getString("timespent");
            String goal = root.getString("goal");

            response = HttpJsonRequest.make("http://159.203.29.133:9998/assignments/" + assignmentId, "GET");
            root = new JSONObject(new JSONTokener(response.getBody()));
            String assignmentName = root.getString("name");
            String worth = root.getString("worth");

            studentAssignment.setAssignmentName(assignmentName);
            studentAssignment.setWorth(worth);
            studentAssignment.setGoal(goal);
            studentAssignment.setTimeSpent(timeSpent);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return studentAssignment;
    }

}
