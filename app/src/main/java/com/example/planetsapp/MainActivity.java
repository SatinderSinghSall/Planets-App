package com.example.planetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    ArrayList<Planet> PlanetArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1 - AdopterView: a ListView:
        listView = findViewById(R.id.PlanetApp_ListView);

        // 2 - Data Source: ArrayList<Planet>
        PlanetArrayList = new ArrayList<>();

        Planet Planet_1 = new Planet("Mercury", "0 Moon", R.drawable.mercury);
        Planet Planet_2 = new Planet("Venus", "0 Moon", R.drawable.venus);
        Planet Planet_3 = new Planet("Earth", "1 Moons", R.drawable.earth);
        Planet Planet_4 = new Planet("Mars", "2 Moons", R.drawable.mars);
        Planet Planet_5 = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        Planet Planet_6 = new Planet("Saturn", "83 Moons", R.drawable.saturn);
        Planet Planet_7 = new Planet("Uranus", "27 Moons", R.drawable.uranus);
        Planet Planet_8 = new Planet("Neptune", "14 Moons", R.drawable.neptune);
//        Planet Planet_9 = new Planet("Earth", "1", R.drawable.earth);

        PlanetArrayList.add(Planet_1);
        PlanetArrayList.add(Planet_2);
        PlanetArrayList.add(Planet_3);
        PlanetArrayList.add(Planet_4);
        PlanetArrayList.add(Planet_5);
        PlanetArrayList.add(Planet_6);
        PlanetArrayList.add(Planet_7);
        PlanetArrayList.add(Planet_8);
//        PlanetArrayList.add(Planet_9);

        // 3 - Adapter:
        adapter = new MyCustomAdapter(PlanetArrayList, getApplicationContext());

        listView.setAdapter(adapter);

        // 4 - Handling Click Events:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(
                        MainActivity.this,
                        "Planet Name: " + adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
