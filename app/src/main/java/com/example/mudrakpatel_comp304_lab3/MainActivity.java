package com.example.mudrakpatel_comp304_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare the required view components
    String[] exerciseItemsArray;
    ListView listViewMainActivity;
    ArrayAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize the ListView and the ArrayList
        listViewMainActivity = (ListView) findViewById(R.id.listViewMainActivity);
        exerciseItemsArray = getResources().getStringArray(R.array.excerciseItemsArray);
        //Add items to ListView
        listViewAdapter = new ArrayAdapter(getApplicationContext(),
                                android.R.layout.simple_list_item_1, exerciseItemsArray);
        //Set the Adapter for the ListView
        listViewMainActivity.setAdapter(listViewAdapter);
        //Loop through each item and
        //attach a click/tap event listener
        listViewMainActivity.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long longArgument){
                Toast.makeText(getApplicationContext(),
                        "EX " + (listViewMainActivity.getItemIdAtPosition(position)+1) +
                                " LAUNCHING...", Toast.LENGTH_SHORT).show();
                switch(position){
                    case 0:
                        startActivity(new Intent(getApplicationContext(), Exercise1Activity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Exercise2Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Exercise3Activity.class));
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "UNABLE TO OPEN THE SCREEN!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
