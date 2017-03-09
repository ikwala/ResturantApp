package com.ikwala.resturantapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signin2Activity extends AppCompatActivity
{
    private EditText etEmail, etpassword;
    private Button btnSingin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etpassword = (EditText) findViewById(R.id.etpassword);

        btnSingin = (Button) findViewById(R.id.btnSignin);
        btnSingin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                attemptLogin();
            }
        });

    }

    private void attemptLogin()
    {
    }

    private boolean isEmailValid(String email)
    {
        return false;
    }

    private boolean isPasswordValid(String password)
    {
        return false;
    }
}
