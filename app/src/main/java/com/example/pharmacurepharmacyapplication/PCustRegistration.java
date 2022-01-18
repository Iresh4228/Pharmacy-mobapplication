package com.example.pharmacurepharmacyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import at.favre.lib.crypto.bcrypt.BCrypt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PCustRegistration extends AppCompatActivity {

    private EditText custname;
    private EditText custnic;
    private EditText custemail;
    private EditText custaddress;
    private EditText custpassword;
    private Button custreg;
    private final String TAG = "PCustRegistration";
    private final String BASE_URL = "http://20.7.3.48:8080";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_cust_registration);

        custname = findViewById(R.id.custname);
        custnic = findViewById(R.id.custnic);
        custemail = findViewById(R.id.custemail);
        custaddress = findViewById(R.id.custaddress);
        custpassword = findViewById(R.id.custpassword);
        custreg = findViewById(R.id.CustomerRegister);



        custreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cusName, custloginemail, cusPassword,cusAddress, custNic;
                cusName = custname.getText().toString();
                custloginemail = custemail.getText().toString();
                cusPassword = custpassword.getText().toString();
                cusAddress = custaddress.getText().toString();
                custNic = custnic.getText().toString();

                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
                JSONPlaceHolder jsonPlaceHolder = retrofit.create(JSONPlaceHolder.class);

                if (cusName.equals("") || custloginemail.equals("") || cusPassword.equals("") || cusAddress.equals("") || custNic.equals("")){
                    Toast.makeText(PCustRegistration.this, "Fill All Required Fields", Toast.LENGTH_LONG).show();
                    return;
                }

                String bCryptPassword = BCrypt.withDefaults().hashToString(12,cusPassword.toCharArray());
                PCustomerLogin pcustomerlogin = new PCustomerLogin(custloginemail, bCryptPassword);
                PCustomer pCustomer = new PCustomer(cusName,cusAddress, custNic, custloginemail, pcustomerlogin);

                Call<ResponseBody> call = jsonPlaceHolder.addUser(pCustomer);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(PCustRegistration.this, "Registration Failure!!!" + response.code(), Toast.LENGTH_LONG).show();
                            Log.e(TAG,"Response Error :" + response.code());
                            return;
                        }
                        Toast.makeText(PCustRegistration.this, "Successfully Registered!!!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(PCustRegistration.this, "Registration Failed!!! :" +t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG,t.getMessage());
                    }
                });


            }

        });
    }
}