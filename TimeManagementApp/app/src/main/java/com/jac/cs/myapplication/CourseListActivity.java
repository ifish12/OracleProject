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

public class CourseListActivity extends Activity {

    private List<Course> mClases;


    private ListView mNotesListView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);


        final List<Course> myList = new ArrayList<Course>();


        Course course1 = new Course();
        course1.setCatID(1);
        course1.setTitle("English");
        course1.setId(1);

        Course course2 = new Course();
        course2.setCatID(2);
        course2.setTitle("Math");
        course2.setId(2);

        Course course3 = new Course();
        course3.setCatID(3);
        course3.setTitle("Programming");
        course3.setId(3);


        myList.add(course1);
        myList.add(course2);
        myList.add(course3);

        CoursesArrayAdapter adapter = new CoursesArrayAdapter(this, myList);
        mNotesListView = (ListView) this.findViewById(R.id.notes_listView);
        mNotesListView.setAdapter(adapter);

        mNotesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //myItemClick(contacts.get(position).toString());
                //Toast.makeText(CourseListActivity.this, myList.get(position).toString(), Toast.LENGTH_LONG).show();
                Intent temp = new Intent(view.getContext(), AssignmentListActivity.class);
                startActivity(temp);
            }
        });

//        mNotesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(NoteListActivity.this);
//                dialogBuilder.setTitle("Delete Note?");
//
//                View dialog_layout = getLayoutInflater().inflate(R.layout.alert_dialog_view, null);
//
//                dialog_layout.setBackgroundColor(Color.TRANSPARENT); // Make our custom view match the background of the AlertDialog
//
//                // Create the text field in the alert dialog...
//                TextView title = (TextView) dialog_layout.findViewById(R.id.title_text_alert);
//                TextView description = (TextView) dialog_layout.findViewById(R.id.description_text_alert);
//
//                title.setText(mNotes.get(position).getTitle());
//                description.setText(mNotes.get(position).getComment());
//
//                dialogBuilder.setView(dialog_layout); // Assigning our custom view to the dialog
//
//                dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogIn®terface dialog, int which) {
//                        Log.d("Delete Placeholder", mNotes.get(position).toString());
//                        dbh.getNotesTable().deleteNote(mNotes.get(position));
//                        mNotes = dbh.getNotesTable().getAllNotes();
//
//
//                        NotesArrayAdapter adapter = new NotesArrayAdapter(NoteListActivity.this, mNotes);
//                        mNotesListView = (ListView)NoteListActivity.this.findViewById(R.id.notes_listView);
//                        mNotesListView.setAdapter(adapter);
//                    }
//                });
//
//                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//
//                dialogBuilder.show();
//                return true;
//            }
//        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
