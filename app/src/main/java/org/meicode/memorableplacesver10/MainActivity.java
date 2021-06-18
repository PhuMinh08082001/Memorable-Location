package org.meicode.memorableplacesver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> places;       //array get places you marked
    static  ArrayList<LatLng> address;     //array get coordinate you marked
    static ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        places = new ArrayList<String>();
        address = new ArrayList<LatLng>();
        places.add("Add new places ... ");

        arrayAdapter  = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , places);
        ListView listView = (ListView) findViewById(R.id.lv_listview);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this , MapsActivity.class);
                intent.putExtra("numberplace" , position);
                startActivity(intent);
            }
        });

    }
}