package com.example.pharmacurepharmacyapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetAllDrugsActivity extends AppCompatActivity {

    private static final String TAG = "GetAllDrugsActivity";
    private final String BASE_URL = "http://20.7.3.48:8080";
    private DrugsAdapter drugsAdapter;
    private ArrayList<Drugs> drugsArrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_drugs);
        recyclerView = findViewById(R.id.recycle_drugs);
        recyclerView.setLayoutManager(new LinearLayoutManager(GetAllDrugsActivity.this));

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        JSONPlaceHolder jsonPlaceHolder = retrofit.create(JSONPlaceHolder.class);

        Call<List<Drugs>> listCall = jsonPlaceHolder.getAllDrugs();
        listCall.enqueue(new Callback<List<Drugs>>() {
            @Override
            public void onResponse(Call<List<Drugs>> call, Response<List<Drugs>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(GetAllDrugsActivity.this, "Error!!!"+response.code(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"Response error!!! :"+ response.code());
                    return;
                }

                //method eke return krna drugs tika list ekktaargana adapter ekta set krnewa
                else {
                    List<Drugs> drugdetList = response.body();
                    drugsAdapter = new DrugsAdapter(drugdetList,GetAllDrugsActivity.this);
                    recyclerView.setAdapter(drugsAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Drugs>> call, Throwable t) {
                Toast.makeText(GetAllDrugsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}