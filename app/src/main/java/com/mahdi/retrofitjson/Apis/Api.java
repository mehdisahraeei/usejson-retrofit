package com.mahdi.retrofitjson.Apis;

import com.mahdi.retrofitjson.model.Model;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("mahdisahrai/RetrofitJson/master/file.json")
    Call<ArrayList<Model>> getModel();

}
