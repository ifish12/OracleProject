package com.jac.cs.myapplication.async;

import android.os.AsyncTask;
import android.util.Log;

import com.jac.cs.myapplication.Assignment;
import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GetStudentAssignment extends AsyncTask<String, Void, List<Assignment>> {

    private AsyncResponse<List<Assignment>> delegate;

    public GetStudentAssignment(AsyncResponse<List<Assignment>> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(List<Assignment> courses) {
        delegate.onAsyncPostExecute(courses);
    }

    @Override
    protected List<Assignment> doInBackground(String... params) {

        List<Assignment> studentClasses = new ArrayList<>();
        try {
            String courseName = params[0];

            HttpResponse response = HttpJsonRequest.make("http://159.203.29.133:9998/courses/search/findBycoursename?name=" + "Introduction%20to%20Things", "GET");

            JSONObject root = new JSONObject(new JSONTokener(response.getBody()));

            String courseidurl = root.getJSONObject("_embedded").getJSONArray("courses").getJSONObject(0).getJSONObject("_links").getJSONObject("assignments").getString("href");

            response = HttpJsonRequest.make(courseidurl, "GET");

            root = new JSONObject(new JSONTokener((response.getBody())));

            JSONArray assignments = root.getJSONObject("_embedded").getJSONArray("assignments");

            Log.d("Assignments", assignments.toString());

            for(int i = 0; i < assignments.length(); i++){
                Assignment assignment = new Assignment();
                String assignmentName = assignments.getJSONObject(i).getString("name");
                assignment.setTitle(assignmentName);

                String assignmentId = assignments.getJSONObject(i).getJSONObject("_links").getJSONObject("self").getString("href");
                assignment.setId(assignmentId);

                //Log.d("FOO", assignmentId);
                //char finalAssignmentId = assignmentId.charAt(assignmentId.length() - 1);
                //Log.d("JSON Data:", String.valueOf(finalAssignmentId));

                studentClasses.add(assignment);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return studentClasses;
    }
}
