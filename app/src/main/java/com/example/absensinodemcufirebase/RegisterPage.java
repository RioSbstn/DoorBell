package com.example.absensinodemcufirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RegisterPage extends AppCompatActivity {

    private Button next1, done1;
    DatabaseReference databaseReference;
    private EditText name1, nim1, code1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        name1 = findViewById(R.id.name);
        nim1 = findViewById(R.id.nim);
        code1 = findViewById(R.id.code);
        next1 = findViewById(R.id.submit);
        done1 = findViewById(R.id.done);
        textView = findViewById(R.id.rfidcode);


        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("test").child("gaskeun");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s = (String) dataSnapshot.getValue();
                textView.setText("" + s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RegisterPage.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        //button buat next nih
        done1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(RegisterPage.this,done.class);
                startActivity(intent);
            }
        });
    }
        //ini buat send data dari User terus bikin data baru di firebase
        public void sendData(View view) {
            writeNewUser();
        }

        public void writeNewUser() {
            User user = new User(code1.getText().toString(), name1.getText().toString(), nim1.getText().toString());

            databaseReference.child("").child(user.getIdcard()).setValue(user);

        }

}