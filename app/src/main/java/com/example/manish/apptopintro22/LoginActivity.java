package com.example.manish.apptopintro22;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView tvLogin,tvsignup;
    EditText etmail,etpassword;
    Button btnlogin;

    Typeface tf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvLogin= (TextView) findViewById(R.id.tvLogin);
        tvsignup= (TextView) findViewById(R.id.tvsignup);
        etmail= (EditText) findViewById(R.id.etmail);
        etpassword= (EditText) findViewById(R.id.etpassword);
        btnlogin= (Button) findViewById(R.id.btnlogin);

        tf= Typeface.createFromAsset(getAssets(),"GrandHotel-Regular.otf");

        tvLogin.setTypeface(tf);
        tvsignup.setTypeface(tf);
        btnlogin.setTypeface(tf);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LoginActivity.this,Navigation_Main.class);
                startActivity(intent);


            }
        });

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt=new Intent(LoginActivity.this,Signup.class);
                startActivity(intentt);

            }
        });

    }


}
