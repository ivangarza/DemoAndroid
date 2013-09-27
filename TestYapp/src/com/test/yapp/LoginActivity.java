package com.test.yapp;

import com.test.testyapp.MainActivity;
import com.test.testyapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends Activity{
	
	ImageView fbLogin, twitLogin;
	TextView  noRegistrado;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        
        Intent i = new Intent(LoginActivity.this,SplashActivity.class);
    	startActivity(i);
        
        noRegistrado = (TextView)findViewById(R.id.textNoReg);
        
        noRegistrado.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent i = new Intent(LoginActivity.this,MainActivity.class);
				startActivity(i);
				
			}
        	
        	
        });
        
        
	}

}
