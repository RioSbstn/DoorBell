package com.example.absensinodemcufirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class taptap extends AppCompatActivity  {
    TextView textView;
    private Button save1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taptap);

        textView = findViewById(R.id.buidcode);

        //database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("test").child("gaskeun");

        //write data firebase
        //myRef.setValue("BUID");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s = (String) dataSnapshot.getValue();
                textView.setText(""+s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(taptap.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        save1 = findViewById(R.id.save);
        save1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(taptap.this,done.class);
                startActivity(intent);
            }
        });
    }


}