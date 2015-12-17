package com.jac.cs.myapplication.async;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.jac.cs.myapplication.Assignment;
import com.jac.cs.myapplication.Course;
import com.jac.cs.myapplication.ModifyAssignment;
import com.jac.cs.myapplication.R;
import com.jac.cs.myapplication.StudentAssignment;
import com.jac.cs.myapplication.async.AsyncResponse;
import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.List;

public class GetStudentAssignment extends AsyncTask<String, Void, StudentAssignment> {

    private Activity activity;
    StudentAssignment studentAssignment = new StudentAssignment();
    private AsyncResponse<StudentAssignment> delegate;

    public GetStudentAssignment(AsyncResponse<StudentAssignment> delegate, Activity a) {
        activity = a;
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(StudentAssignment studentAssignment) {


        EditText editAssignmentGoal = (EditText) activity.findViewById(R.id.editGoal);

        TextView textAssignmentWorth = (TextView) activity.findViewById(R.id.txtAssignmentWorth);
        TextView textHoursSpent = (TextView) activity.findViewById(R.id.txtAssignmentHours);
        TextView textAssignmentName = (TextView) activity.findViewById(R.id.txtAssignmentName);
        TextView textDueDate = (TextView) activity.findViewById(R.id.txtDueDate);

        textAssignmentName.setText(studentAssignment.getAssignmentName());
        textDueDate.setText(studentAssignment.getDueDate());
        textAssignmentWorth.setText(studentAssignment.getWorth()); //(studentAssignment.getWorth());
        textHoursSpent.setText(studentAssignment.getTimeSpent());
        editAssignmentGoal.setText(studentAssignment.getGoal());

        delegate.onAsyncPostExecute(studentAssignment);
    }

    @Override
    protected StudentAssignment doInBackground(String... params) {

        //String studentId = params[0];


        try {
            HttpResponse response = HttpJsonRequest.make("http://159.203.29.133:9998/studentassignments/" + "1", "GET");
            JSONObject root = new JSONObject(new JSONTokener(response.getBody()));

            String assignmentId = root.getString("assignmentid");
            String timeSpent = root.getString("timespent");
            String goal = root.getString("goal");
            String studentId = root.getString("studentid");

            response = HttpJsonRequest.make("http://159.203.29.133:9998/assignments/" + assignmentId, "GET");
            root = new JSONObject(new JSONTokener(response.getBody()));

            String assignmentName = root.getString("name");
            String worth = root.getString("worth");
            String dueDate = root.getString("dueDate");

            studentAssignment.setAssignmentName(assignmentName);
            studentAssignment.setAssignmentId(assignmentId);
            studentAssignment.setStudentId(studentId);
            studentAssignment.setWorth(worth);
            studentAssignment.setGoal(goal);
            studentAssignment.setTimeSpent(timeSpent);
            studentAssignment.setDueDate(dueDate);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return studentAssignment;
    }

}
