package com.example.manish.apptopintro22;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    TextView tvsignup,tvtologin;
    EditText etname,etaddress,etemailsignup,password,reenterpassword;
    Button btnsignup;

    Typeface tf;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        tvsignup= (TextView) findViewById(R.id.tvsignup);

        etname= (EditText) findViewById(R.id.etname);
        etaddress= (EditText) findViewById(R.id.etaddress);
        etemailsignup= (EditText) findViewById(R.id.etemailsignup);
        password= (EditText) findViewById(R.id.password);
        reenterpassword= (EditText) findViewById(R.id.reenterpassword);

        tvtologin= (TextView) findViewById(R.id.tvtologin);
        btnsignup= (Button) findViewById(R.id.btnsignup);

        tf= Typeface.createFromAsset(getAssets(),"GrandHotel-Regular.otf");

        tvsignup.setTypeface(tf);
        tvtologin.setTypeface(tf);
        btnsignup.setTypeface(tf);







//Method1-failed to move both listeners
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,Navigation_Main.class);
                startActivity(intent);

            }
        });

        tvtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt=new Intent(Signup.this,MainActivity.class);
                startActivity(intentt);
            }
        });


//Method2-failed to move both listeners


/*        final Intent intent=new Intent();
        intent.setClass(Signup.this,Navigation_Main.class);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


        final Intent intentt=new Intent();
        intentt.setClass(Signup.this,MainActivity.class);
        tvtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentt);
            }
        });   */

    }


    //Method3-Totally not working
/*    public void onClick(View v){

        if (v.getId()==R.id.btnsignup){


            Intent intent=new Intent(context,Navigation_Main.class);
            startActivity(intent);

        }

        else if (v.getId()==R.id.tvtologin){

            Intent intentt=new Intent(context,MainActivity.class);
            startActivity(intentt);

        }

    }  */


//Method4-totally not works
/*    public void onClick(View v){

        switch (v.getId()) {

            case R.id.btnsignup:
                Intent intent = new Intent(context, Navigation_Main.class);
                startActivity(intent);
                break;

            case R.id.tvLogin:
                intent = new Intent(context, MainActivity.class);
            startActivity(intent);

        }

    }  */

}
