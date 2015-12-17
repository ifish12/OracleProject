package com.jac.cs.myapplication.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.jac.cs.myapplication.ModifyAssignment;
import com.jac.cs.myapplication.StudentAssignment;
import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

public class UpdateStudentAssignment extends AsyncTask<String, Void, StudentAssignment> {

    private Activity activity;

    private AsyncResponse<StudentAssignment> delegate;
    private StudentAssignment targetToUpdate = new StudentAssignment();

    public UpdateStudentAssignment(AsyncResponse<StudentAssignment> delegate, StudentAssignment a) {
        this.delegate = delegate;
        this.targetToUpdate = a;
    }

    @Override
    protected void onPostExecute(StudentAssignment courses) {
        delegate.onAsyncPostExecute(courses);


    }

    @Override
    protected StudentAssignment doInBackground(String... params) {


        StudentAssignment studentAssignment = new StudentAssignment();
        try {
            String json = targetToUpdate.toJson(targetToUpdate);
            Log.d("UPDATE JSON", json);
            HttpResponse response = HttpJsonRequest.make("http://159.203.29.133:9998/studentassignments/","PUT", json);
        } catch (Exception e) {

        }

        return studentAssignment;
    }

}
