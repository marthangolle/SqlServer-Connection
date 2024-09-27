package com.example.sqlverbindung;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlverbindung.model.Container;
import com.example.sqlverbindung.retrofit.ContainerApi;
import com.example.sqlverbindung.retrofit.RetrofitService;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText editText, editText1, editText2;
    TextView textView;
    Button btnSave;
    Button btnDelete;
    Connection connection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // Initialize UI elements
        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);
        btnSave = findViewById(R.id.btnSave);

        RetrofitService retrofitService = new RetrofitService();
        ContainerApi containerApi = retrofitService.getRetrofit().create(ContainerApi.class);
        // Set click listener for the Save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Execute AsyncTask to insert data into the database
                int BID = Integer.parseInt(editText.getText().toString());
                int RFID = Integer.parseInt(editText1.getText().toString());
                String HID = editText2.getText().toString();

                Container container = new Container();
                container.setBID(BID);
                container.setRFID(RFID);
                container.setHID(HID);

                containerApi.save(container)
                        .enqueue(new Callback<Container>() {

                            @Override
                            public void onResponse(Call<Container> call, Response<Container> response) {
                                Toast.makeText(MainActivity.this, "Save Successful!", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onFailure(Call<Container> call, Throwable throwable) {
                                Toast.makeText(MainActivity.this, "Save Failed!!!", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "ERROR OCCURRED", throwable); // incase an error occures.

                            }
                        });

            }
        });


    }
}