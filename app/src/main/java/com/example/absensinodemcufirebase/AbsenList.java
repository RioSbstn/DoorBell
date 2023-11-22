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

public class AbsenList extends AppCompatActivity  {
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    private Button home1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen_list);

        textView1 = findViewById(R.id.absenname1);
        textView2 = findViewById(R.id.absenname2);
        textView3 = findViewById(R.id.absenname3);
        textView4 = findViewById(R.id.absenname4);

        textView5 = findViewById(R.id.absennim1);
        textView6 = findViewById(R.id.absennim2);
        textView7 = findViewById(R.id.absennim3);
        textView8 = findViewById(R.id.absennim4);

        //database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Kehadiran");

        //write data firebase
        //myRef.setValue("BUID");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s = (String) dataSnapshot.getValue();
                textView1.setText(""+s);
                textView2.setText(""+s);
                textView3.setText(""+s);
                textView4.setText(""+s);
                textView5.setText(""+s);
                textView6.setText(""+s);
                textView7.setText(""+s);
                textView8.setText(""+s);
                //documentSnapshot.getString("nama")
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(AbsenList.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        home1 = findViewById(R.id.absenhome);
        home1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(AbsenList.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}


