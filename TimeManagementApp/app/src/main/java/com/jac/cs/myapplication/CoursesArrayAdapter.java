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



























