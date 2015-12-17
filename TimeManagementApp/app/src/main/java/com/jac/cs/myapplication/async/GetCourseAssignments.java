package com.jac.cs.myapplication.async;

import android.os.AsyncTask;
import android.util.Log;

import com.jac.cs.myapplication.Assignment;
import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KevinVe on 12/16/2015.
 */
public class GetCourseAssignments extends AsyncTask<String, Void, List<Assignment>> {
    private AsyncResponse<List<Assignment>> delegate;

    public GetCourseAssignments(AsyncResponse<List<Assignment>> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(List<Assignment> assignment) {
//        for (final Assignment temp : assignment) {
//            Log.d("JSON Data:", temp.toString());
//        }
        delegate.onAsyncPostExecute(assignment);
    }

    @Override
    protected List<Assignment> doInBackground(String... params) {
        List<Assignment> courseAssignments = new ArrayList<Assignment>();
        try {
            String courseId = params[0];
            HttpResponse response = HttpJsonRequest.make("http://159.203.29.133:9998/assignments/search/findByCourseid?courseid=" + courseId, "GET");
            JSONObject root = new JSONObject(new JSONTokener(response.getBody()));
            Log.d("poop:", root.toString());
            if (! root.toString().equals("{}")) {
                courseAssignments = Assignment.fromJson(root.getJSONObject("_embedded").getJSONArray("assignments"));
                String json = root.toString();
                Log.d("JSON Data:", json);
            } else {
                Assignment temp = new Assignment();
                temp.setName("No Assignments");
                courseAssignments.add((temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return courseAssignments;
    }
}
