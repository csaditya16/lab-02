package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    // Create button/input variables
    EditText cityInput;
    Button deleteButton;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();

        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);


        // Add to the city variables
        cityInput = findViewById(R.id.input_city);
        deleteButton = findViewById(R.id.delete_button);
        addButton = findViewById(R.id.add_button);

        // Listen for the Add city button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = cityInput.getText().toString();
                if (!city.isEmpty()){   // Only if there is something in the text field
                    dataList.add(city);
                    cityInput.setText("");
                    cityAdapter.notifyDataSetChanged();
                }
            }
        });

        // Listen for the Delete city button
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = cityInput.getText().toString();
                if (!city.isEmpty()){   // Only if there is something in the text field
                    dataList.remove(city);
                    cityInput.setText("");
                    cityAdapter.notifyDataSetChanged();
                }
            }
        });
    }



}

