package com.jac.cs.myapplication.async;

import android.os.AsyncTask;
import android.util.Log;

import com.jac.cs.myapplication.Asgdetail;
import com.jac.cs.myapplication.utility.HttpJsonRequest;
import com.jac.cs.myapplication.utility.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SaveAssignmentTask extends AsyncTask<Asgdetail, Void, Boolean> {

    private AsyncResponse<Boolean> delegate;

    public SaveAssignmentTask(AsyncResponse<Boolean> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        delegate.onAsyncPostExecute(success);
    }

    @Override
    protected Boolean doInBackground(Asgdetail... params) {
        Asgdetail asgdetail = params[0];

        HttpResponse response = null;
        try {
            response = HttpJsonRequest.make("http://159.203.29.133:9998/studentassignments", "POST", asgdetail.toJson());
            return response.getStatus() == 201;  //success status
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
