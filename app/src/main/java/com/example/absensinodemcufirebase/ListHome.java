package com.example.absensinodemcufirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ListHome extends AppCompatActivity implements View.OnClickListener{
    private Button user_list, absen_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_home);

        user_list = findViewById(R.id.user_list);
        absen_list = findViewById(R.id.absen_list);

        user_list.setOnClickListener(this);
        absen_list.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_list:
                Intent intent=new Intent(ListHome.this,UserList.class);
                startActivity(intent);
                break;
            case R.id.absen_list:
                Intent intent2=new Intent(ListHome.this,AbsenList.class);
                startActivity(intent2);
                break;
        }
    }
}