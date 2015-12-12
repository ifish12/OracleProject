package com.jac.cs.myapplication.async;

import android.os.AsyncTask;
import android.util.Log;

import com.jac.cs.myapplication.Course;
import com.jac.cs.myapplication.async.AsyncResponse;
import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.List;

public class GetStudentCourses extends AsyncTask<String, Void, List<Course>> {

    private AsyncResponse<List<Course>> delegate;

    public GetStudentCourses(AsyncResponse<List<Course>> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(List<Course> courses) {


        //Log.d("JSON Data:", courses.toString());
        delegate.onAsyncPostExecute(courses);
    }

    @Override
    protected List<Course> doInBackground(String... params) {

        List<Course> studentClasses = null;
        try {
            String studentId = params[0];

            HttpResponse response = HttpJsonRequest.make("http://159.203.29.133:9998/student/" + studentId+ "/courses", "GET");
           // HttpResponse response = HttpJsonRequest.make("http://159.203.29.133:9998/courses", "GET");

            JSONObject root = new JSONObject(new JSONTokener(response.getBody()));

            studentClasses = Course.fromJson(root.getJSONObject("_embedded").getJSONArray("courses"));

            String json = root.toString();

           Log.d("JSON Data:", json);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return studentClasses;
    }
}
