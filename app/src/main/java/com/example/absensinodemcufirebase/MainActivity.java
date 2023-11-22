package com.example.absensinodemcufirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_register, button_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_register = findViewById(R.id.register_button);
        button_list = findViewById(R.id.list_button);

        button_register.setOnClickListener(this);
        button_list.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_button:
                Intent intent=new Intent(MainActivity.this,RegisterPage.class);
                startActivity(intent);
                break;
            case R.id.list_button:
                Intent intent2=new Intent(MainActivity.this,ListHome.class);
                startActivity(intent2);
                break;
        }
    }
}