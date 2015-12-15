package com.jac.cs.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.jac.cs.myapplication.async.AsyncResponse;
import com.jac.cs.myapplication.async.GetAllCourses;
import com.jac.cs.myapplication.async.GetStudentAssignment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddAssignmentActivity extends Activity {

    private ArrayAdapter<Course> mAdapter;
    private List<String> assignmentNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        GetStudentAssignment task = new GetStudentAssignment(new AsyncResponse<List<String>>() {
            @Override
            public void onAsyncPostExecute(List<String> result) {

                assignmentNames = result;
                Spinner lv = (Spinner) findViewById(R.id.assignmentListView);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddAssignmentActivity.this, android.R.layout.simple_list_item_1, assignmentNames);
                lv.setAdapter(arrayAdapter);

            }
        });
        task.execute("Programming");




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_assignment, menu);
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

    public void cancel(View view) {

        Context context = getApplicationContext();
        CharSequence text = "Go to the previous page";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        finish();
    }

    public void save(View view) {
        //Todo
        Context context = getApplicationContext();
        CharSequence text = "The assignment has been saved successfully!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        finish();

    }


    public static class TimePickerFragment extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {
        private EditText timeEdit;
        public TimePickerFragment() {
        }

        public EditText getTimeEdit() {

            return timeEdit;
        }

        public void setTimeEdit(EditText timeEdit) {
            this.timeEdit = timeEdit;
        }
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,  true); //DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            timeEdit.setText(hourOfDay + "h" + minute + "m");
        }
    }


    public void showTimePickerDialog(View v) {
        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.setTimeEdit((EditText) v);
        newFragment.show(getFragmentManager(), "timePicker");
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        private EditText dateEdit;

        public DatePickerFragment() {
        }

        public EditText getDateEdit() {
            return dateEdit;
        }

        public void setDateEdit(EditText dateEdit) {
            this.dateEdit = dateEdit;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            dateEdit.setText(day + "/" + (month + 1) + "/" + year);
        }
    }
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setDateEdit((EditText) v);
        newFragment.show(getFragmentManager(), "datePicker");
    }

}
