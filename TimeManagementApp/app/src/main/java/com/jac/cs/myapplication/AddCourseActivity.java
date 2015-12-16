package com.jac.cs.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jac.cs.myapplication.async.AsyncResponse;
import com.jac.cs.myapplication.async.GetAllCourses;
import com.jac.cs.myapplication.async.GetStudentCourses;

import java.util.ArrayList;
import java.util.List;

public class AddCourseActivity extends Activity {
    private Spinner                mCategorySpinner;
    private ArrayAdapter<Course> mAdapter;

    private List<Course>           mCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        GetAllCourses task = new GetAllCourses(new AsyncResponse<List<Course>>() {
            @Override
            public void onAsyncPostExecute(List<Course> result) {
                mCourses = result;
                mAdapter = new ArrayAdapter<Course>(AddCourseActivity.this,
                        R.layout.spinner_row_main,
                        mCourses);
                mCategorySpinner = (Spinner)findViewById(R.id.notes_spinner);
                mCategorySpinner.setAdapter(mAdapter);


            }
        });
        task.execute();

    }

//
    private void saveNote() {
//        //TODO:
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_save) {
            //saveNote();
            finish();
            //return true;
        }
        else if (id == R.id.action_debug) {
//            Log.d("SQLITE", "=== Start of CategoryTable ===");
//            for(Category c : dbh.getCategoryTable().getAllCategories())
//                Log.d("SQLITE", " " + c.toString());
//            Log.d("SQLITE", "=== End of CategoryTable ===");
//
//            Log.d("SQLITE", "=== Start of NotesTable ===");
//            for(Note n : dbh.getNotesTable().getAllNotes())
//                Log.d("SQLITE", " " + n.toString());
//            Log.d("SQLITE", "=== End of NotesTable ===");
        }

        return super.onOptionsItemSelected(item);
    }
}
