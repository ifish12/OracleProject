package com.jac.cs.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AssignmentListActivity extends Activity {

    private ListView assList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_list);

        assList = (ListView) findViewById(R.id.listView_assignments);

        final List<Assignment> assignmentList = new ArrayList<>();
        assignmentList.add(new Assignment("Assignment 1", "This is the first assignment"));
        assignmentList.add(new Assignment("Assignment 2", "This is the second assignment"));
        assignmentList.add(new Assignment("Assignment 3", "This is the third assignment"));
        assignmentList.add(new Assignment("Assignment 4", "This is the fourth assignment"));

        AssignmentArrayAdapter adapter = new AssignmentArrayAdapter(this, assignmentList);
        assList.setAdapter(adapter);

        assList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //myItemClick(contacts.get(position).toString());
                //Toast.makeText(CourseListActivity.this, myList.get(position).toString(), Toast.LENGTH_LONG).show();
                Intent temp = new Intent(view.getContext(), ModifyAssignment.class);
                startActivity(temp);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_assignment_list, menu);
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
            Intent temp = new Intent(this, AddAssignmentActivity.class);
            startActivity(temp);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
