package com.mahdi.retrofitjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.mahdi.retrofitjson.Apis.Api;
import com.mahdi.retrofitjson.adapter.CustomAdapter;
import com.mahdi.retrofitjson.model.Model;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private static final String tag = "MainActivity";


    private Api api;
    private Retrofit retrofit;
    private Call<ArrayList<Model>> call;
    private ArrayList<Model> list;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rec1);



        retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        call = api.getModel();




        call.enqueue(new Callback<ArrayList<Model>>() {
            @Override
            public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {

                list = new ArrayList<>(response.body());

                if (response.isSuccessful() && response.body() != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(new CustomAdapter(MainActivity.this, list));
                }

            }



            @Override
            public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "there are some wrong...", Toast.LENGTH_SHORT).show();
            }
        });



    }
}