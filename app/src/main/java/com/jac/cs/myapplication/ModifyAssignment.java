package com.jac.cs.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyAssignment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Assignment");
        setContentView(R.layout.activity_modify_assignment);

        //getextras

        EditText editAssignmentName = (EditText) findViewById(R.id.editAssignment);
        EditText editAssignmentWorth = (EditText) findViewById(R.id.editWorth);
        EditText editAssignmentDueDate = (EditText) findViewById(R.id.editDueDate);
        EditText editAssignmentGoal = (EditText) findViewById(R.id.editGoal);

        editAssignmentName.setText("Prototype");
        editAssignmentDueDate.setText("10/10/20");
        editAssignmentWorth.setText("20");
        editAssignmentGoal.setText("22");

        final TextView txtAssignmentHours = (TextView) findViewById(R.id.txtAssignmentHours);
        final TextView txtAssignmentMinutes = (TextView) findViewById(R.id.txtAssignmentMinutes);

        Double totalTimeSpent = Double.valueOf(txtAssignmentHours.getText().toString()) +
                                Double.valueOf(txtAssignmentMinutes.getText().toString()) / 60;


        Button btnSaveAssignment = (Button) findViewById(R.id.btnSave);
        Button btnDiscardAssignment = (Button) findViewById(R.id.btnDiscard);

        Button btnAddHour = (Button) findViewById(R.id.btnAddAssignmentHours);
        Button btnAddMinute = (Button) findViewById(R.id.btnAddAssignmentMinutes);

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

        btnAddMinute.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String currentAsString = txtAssignmentMinutes.getText().toString();
                int current = Integer.valueOf(currentAsString);
                current = current + 1;

                String newValue = String.valueOf(current);
                txtAssignmentMinutes.setText(newValue);

                if(txtAssignmentMinutes.getText().equals("60")) {
                    txtAssignmentMinutes.setText("0");
                    int newHours = Integer.valueOf(txtAssignmentHours.getText().toString());
                    newHours += 1;
                    txtAssignmentHours.setText(String.valueOf(newHours));
                }

            }
        });

        btnSaveAssignment.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                // close the intent
                // save the data
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
