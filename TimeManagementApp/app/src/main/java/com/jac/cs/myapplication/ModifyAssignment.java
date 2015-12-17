package com.jac.cs.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jac.cs.myapplication.async.AsyncResponse;
import com.jac.cs.myapplication.async.GetStudentAssignment;
import com.jac.cs.myapplication.async.UpdateStudentAssignment;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class ModifyAssignment extends Activity {


    private StudentAssignment assignment = new StudentAssignment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Assignment");
        setContentView(R.layout.activity_modify_assignment);

        GetStudentAssignment task = new GetStudentAssignment(new AsyncResponse<StudentAssignment>() {
            @Override
            public void onAsyncPostExecute(StudentAssignment result) {
                assignment = result;
            }
        }, ModifyAssignment.this);

        task.execute();


        EditText editAssignmentGoal = (EditText) findViewById(R.id.editGoal);

        final TextView txtAssignmentHours = (TextView) findViewById(R.id.txtAssignmentHours);


        Button btnSaveAssignment = (Button) findViewById(R.id.btnSave);
        Button btnDiscardAssignment = (Button) findViewById(R.id.btnDiscard);

        Button btnAddHour = (Button) findViewById(R.id.btnAddAssignmentHours);


        btnAddHour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String currentAsString = txtAssignmentHours.getText().toString();
                int current = Integer.valueOf(currentAsString);
                current = current + 1;
                String newValue = String.valueOf(current);
                txtAssignmentHours.setText(newValue);

            }
        });

        btnSaveAssignment.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                TextView txtAssignmentHours = (TextView) findViewById(R.id.txtAssignmentHours);
                EditText txtAssignmentGoal = (EditText) findViewById(R.id.editGoal);

                String newAssignmentHours = txtAssignmentHours.getText().toString();
                String newAssignmentGoal = txtAssignmentGoal.getText().toString();
//                String studentId = assignment.getStudentId();
//                String assignmentId = assignment.getAssignmentId();
                assignment.setGoal(newAssignmentGoal);
                assignment.setTimeSpent(newAssignmentHours);


                UpdateStudentAssignment task = new UpdateStudentAssignment(new AsyncResponse<StudentAssignment>() {
                    @Override
                    public void onAsyncPostExecute(StudentAssignment result) {

                    }
                }, assignment);

                task.execute();

                finish();

            }



        });

        btnDiscardAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // close the intent
                // discard the data (essentially do ... nothing)
                finish();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modify_assignment, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
