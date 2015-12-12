package com.jac.cs.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddCourseActivity extends Activity {
    private Button                 mNewCategory;
    private Spinner                mCategorySpinner;
   // private DatabaseHandler        dbh;
    private ArrayAdapter<Course> mAdapter;
    private List<Course>         categories;

    private TextView               mTitle;
    private TextView               mNoteText;
   // private Category               mCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        //final DatabaseHandler dbh = new DatabaseHandler(this);

//        dbh = new DatabaseHandler(this);
       // categories = dbh.getCategoryTable().getAllCategories();
        final List<Course> myList=new ArrayList<Course>();

//        Course course1 = new Course();
//        course1.setCatID(1);
//        course1.setTitle("French");
//        course1.setId(1);
//
//        Course course2 = new Course();
//        course2.setCatID(2);
//        course2.setTitle("Sexual Health");
//        course2.setId(2);
//
//        Course course3 = new Course();
//        course3.setCatID(3);
//        course3.setTitle("Human Relations");
//        course3.setId(3);
//
//
//        myList.add(course1);
//        myList.add(course2);
//        myList.add(course3);


       // mTitle      = (TextView)findViewById(R.id.main_editTitle);
       // mNoteText   = (TextView)findViewById(R.id.main_editText);


        mAdapter = new ArrayAdapter<Course>(this,
                R.layout.spinner_row_main,
                myList);

        mCategorySpinner = (Spinner)findViewById(R.id.notes_spinner);
       // mNewCategory = (Button)findViewById(R.id.main_new_CatButton);

        mCategorySpinner.setAdapter(mAdapter);

//        mNewCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(AddCourseActivity.this);
//                dialogBuilder.setTitle("Add new Category");
//
//                final EditText input = new EditText(AddCourseActivity.this);
//                dialogBuilder.setView(input);
//
//                dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        addCategory(input.getText().toString());
//
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
//            }
//        });


    }
//    private void addCategory(String name){
//        // I know this is a dirty hack and I hate using it. I know there is a better way
//        // I know notifyDatasetChanged() is a function is the adapter class, but it
//        // wasn't working, so I opted for this (awful) way of doing it
//        Category temp = new Category();
//        temp.setCategoryName(name);
//        dbh.getCategoryTable().createCategory(temp);
//        Log.d("Serena Input Test", "Success!");
//        categories = dbh.getCategoryTable().getAllCategories();
//        mAdapter = new ArrayAdapter<>(this, R.layout.spinner_row_main, categories);
//        mCategorySpinner.setAdapter(mAdapter);
//
//    }
    private void saveNote() {
//        Category   cat     = (Category)mCategorySpinner.getSelectedItem();
//        long       catID   = cat.getId();
//
//        Note temp          = new Note();
//        temp.setTitle(mTitle.getText().toString());
//        temp.setComment(mNoteText.getText().toString());
//        temp.setCatID(catID);

       // dbh.getNotesTable().createNote(temp);
        //Log.d("Serena Input Notes Test", "Success!");



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
