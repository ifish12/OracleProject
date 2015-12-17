package com.jac.cs.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.jac.cs.myapplication.async.AsyncResponse;
import com.jac.cs.myapplication.async.GetStudentCourses;

import java.util.ArrayList;
import java.util.List;

public class CourseListActivity extends Activity {

    private List<Course> mCourses;

    private ListView mNotesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        mNotesListView = (ListView)findViewById(R.id.notes_listView);

        GetStudentCourses task = new GetStudentCourses(new AsyncResponse<List<Course>>() {
            @Override
            public void onAsyncPostExecute(List<Course> result) {

                mCourses = result;

                Log.d("JSON Data:", mCourses.toString());
                CoursesArrayAdapter adapter = new CoursesArrayAdapter(CourseListActivity.this, mCourses);

                mNotesListView.setAdapter(adapter);


            }
        });
        task.execute("1500001");


        mNotesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent temp = new Intent(view.getContext(), AssignmentListActivity.class);
                temp.putExtra("courseId", String.valueOf(position+1));
                startActivity(temp);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_list, menu);
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
        } else if (id == R.id.action_add) {
            //saveNote();
            Intent temp = new Intent(this, AddCourseActivity.class);
            startActivity(temp);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
