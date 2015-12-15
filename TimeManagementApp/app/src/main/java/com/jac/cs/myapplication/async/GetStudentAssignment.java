package com.jac.cs.myapplication.async;

import android.os.AsyncTask;
import android.util.Log;

import com.jac.cs.myapplication.Assignment;
import com.jac.cs.myapplication.Course;
import com.jac.cs.myapplication.async.AsyncResponse;
import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

//To fix
public class GetStudentAssignment extends AsyncTask<String, Void, List<String>> {

    private AsyncResponse<List<String>> delegate;

    public GetStudentAssignment(AsyncResponse<List<String>> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(List<String> courses) {
        delegate.onAsyncPostExecute(courses);
    }

    @Override
    protected List<String> doInBackground(String... params) {

        List<String> studentClasses = new ArrayList<String>();
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
                String assignmentName = assignments.getJSONObject(i).getString("name");
                studentClasses.add(assignmentName);
                //String assignmentId = assignments.getJSONObject(i).getJSONObject("_links").getJSONObject("self").getJSONObject("href").toString();
                //char finalAssignmentId = assignmentId.charAt(assignmentId.length() - 1);
                //Log.d("JSON Data:", String.valueOf(finalAssignmentId));

            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return studentClasses;
    }
}
