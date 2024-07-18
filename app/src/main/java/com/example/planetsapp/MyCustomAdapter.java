/*
 =============================== File Documentation: ===============================
    > Using custom layouts --> MyCustomAdapter.java
    > Using custom objects --> extends ArrayAdopter <Planets>

    > View Holder Class:
      A 'View Holder Class' is used to cache references to the views
      within an item layout, so that  the user do not need to be
      repeatedly looked up during scrolling of the application.

    > getView() method/function:
      The above method is use to create and return a view for a
      specific item in the list.
*/

package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter <Planet>
{
    private ArrayList<Planet> PlanetsArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetsArrayList, Context context)
    {
        super(context, R.layout.item_list_layout, planetsArrayList);
        this.PlanetsArrayList = planetsArrayList;
        this.context = context;
    }

    private static class MyViewHolder
    {
        TextView PlanetName_TextView;
        TextView PlanetNumberOfMoons_TextView;
        ImageView PlanetImage_ImageView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // 1 - Get the planet object frm the current position:
        Planet PlanetsObject = getItem(position);

        // 2 - Inflate layout:
        MyViewHolder My_Viewholder;
        final View result;

        if (convertView == null)
        {
            My_Viewholder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            // 3 - Finding views:
            My_Viewholder.PlanetName_TextView = (TextView) convertView.findViewById(R.id.PlanetName_TextView);
            My_Viewholder.PlanetNumberOfMoons_TextView = (TextView) convertView.findViewById(R.id.PlanetNumberOfMoons_TextView);
            My_Viewholder.PlanetImage_ImageView = (ImageView) convertView.findViewById(R.id.PlanetImage_ImageView);

            result = convertView;

            convertView.setTag(My_Viewholder);
        }

        else
        {
            // The view is recycled:
            My_Viewholder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        // Getting the data from model class. (Planet)
        My_Viewholder.PlanetName_TextView.setText(PlanetsObject.getPlanetName());
        My_Viewholder.PlanetNumberOfMoons_TextView.setText(PlanetsObject.getMoonCount());
        My_Viewholder.PlanetImage_ImageView.setImageResource(PlanetsObject.getPlanetImage());

        return result;
    }
}
