package com.example.memorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> memorablePlaces =  new ArrayList<String>();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.placesList);
        memorablePlaces.add("Add a new place");
        memorablePlaces.add("Add a new place");
        ArrayAdapter<String> memorablePlacesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, memorablePlaces);
        listView.setAdapter(memorablePlacesAdapter);
    }
}
