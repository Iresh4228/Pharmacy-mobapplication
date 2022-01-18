package com.example.pharmacurepharmacyapplication;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JSONPlaceHolder {

    @GET("/getAllDrugsByNames")
    Call<List<Drugs>> getAllDrugs();

    @POST("/addCustomer")
    Call<ResponseBody> addUser(@Body PCustomer pCustomer);

    @GET("/getCustomerById/{id}")
    Call<PCustomer> getCustomerByID(@Path("id") Integer id);


    @GET("/validateCustomerLogin/{email}")
    Call<PCustomerLogin> checkCustomerLoginInfo(@Path("email") String custemail);
}
