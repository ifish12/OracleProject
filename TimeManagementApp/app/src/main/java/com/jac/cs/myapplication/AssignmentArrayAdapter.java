package com.jac.cs.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by KevinVe on 9/29/2015.
 */
public class AssignmentArrayAdapter extends ArrayAdapter<Assignment>{

    public AssignmentArrayAdapter(Context context, List<Assignment> objects) {
        super(context, -1, objects);
    }

    @Override
    public boolean hasStableIds() {
        return true;
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

        Assignment assignment = getItem(position);
        titleTextView.setText(assignment.getTitle());
        descriptionTextView.setText(assignment.getDescription());
        circleView.setLabel(assignment.getTitle().charAt(0));

        Random r = new Random();
        circleView.setColor(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        return newRow;
    }
}
