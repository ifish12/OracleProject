package com.jac.cs.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ian.clement on 2015-09-21.
 */
public class CoursesArrayAdapter extends ArrayAdapter<Course> {



    public CoursesArrayAdapter(Context context, List<Course> objects) {
        super(context, -1, objects);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

//    public String getCatetory(int position) {
//
//
//        final List<Course> myList=new ArrayList<Course>();
//        //Course entry1=new Course();
//        // Course entry2=new Course();
//
//        //myList.add(entry1);
//        //myList.add(entry2);
//
//
//        Course course1 = new Course();
//        course1.setCatID(1);
//        course1.setTitle("English");
//        course1.setId(1);
//
//        Course course2 = new Course();
//        course2.setCatID(2);
//        course2.setTitle("Math");
//        course2.setId(2);
//
//        Course course3 = new Course();
//        course3.setCatID(3);
//        course3.setTitle("Programming");
//        course3.setId(3);
//
//
//        myList.add(course1);
//        myList.add(course2);
//        myList.add(course3);
//
//        //DatabaseHandler dbh = new DatabaseHandler(getContext());
//       // List<Course> cat = categories;
//        return myList.get(position-1).toString(); // Return specific category we want via the ID
//    }

    int randomGenerator(String seed) {

        Random generator = new Random(Integer.valueOf(seed)); // Using CatID as the seed, so it's unique per category, but not "random"
        return generator.nextInt() * (2);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View newRow;

        if(convertView == null) {
            // inflate the new row from the XML layout
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            newRow = inflater.inflate(R.layout.list_row_course, parent, false);
        }
        else
            newRow = convertView;

        // set the name and phone number
        TextView titleTextView = (TextView) newRow.findViewById(R.id.title_textView);
        TextView descriptionTextView = (TextView) newRow.findViewById(R.id.description_textView);
        LabeledCircleView circleView = (LabeledCircleView) newRow.findViewById(R.id.circle_view);


        Course note = getItem(position);
        titleTextView.setText(note.getCourseTitle());
        if(note.getCourseTitle().length() <= 20)
            descriptionTextView.setText(note.getCourseTitle()); // Comment has less than 20 characters and we should display entire thing
        else
            descriptionTextView.setText(note.getCourseTitle().substring(0, 20)); // Just get first 20 characters of comment to display

        circleView.setColor(randomGenerator(note.getCourseRoom())*50, randomGenerator(note.getCourseRoom())*75, randomGenerator(note.getCourseRoom())*200); // Assigning the RBG colour from the generator
        circleView.setLabel(note.getCourseTitle().charAt(0));
        return newRow;
   }
}



























