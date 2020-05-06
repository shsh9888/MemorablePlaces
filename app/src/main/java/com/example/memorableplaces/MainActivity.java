package com.example.memorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> memorablePlaces;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.placesList);

        //check if came from an intent
        Intent fromIntent = getIntent();
        System.out.println(fromIntent.toString());
        if (!isTaskRoot()) {
            memorablePlaces = fromIntent.getStringArrayListExtra("myList");
        } else {
            memorablePlaces = new ArrayList<String>();
            memorablePlaces.add("Add a new place");
            memorablePlaces.add("Add a new place");
        }

        ArrayAdapter<String> memorablePlacesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, memorablePlaces);
        listView.setAdapter(memorablePlacesAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putStringArrayListExtra("myList", memorablePlaces);
                startActivity(intent);
            }
        });


    }
}
