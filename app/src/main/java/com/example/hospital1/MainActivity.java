package com.example.hospital1;

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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText Email;
    EditText Password;
    Button login;
    TextView Sign;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        Email= (EditText)findViewById(R.id.editText);
        Password= (EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button);
        Sign=(TextView)findViewById(R.id.textView3);
        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,signup.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email=Email.getText().toString().trim();
                String user_password=Password.getText().toString().trim();
                if(user_email.length()==0)
                {Email.setError("Please Enter Some Text");}
                else if (user_password.length()==0)
                {
                    Password.setError("Please enter correct Password");
                }
                mAuth.signInWithEmailAndPassword(user_email, user_password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent= new Intent(MainActivity.this,drawer.class);
                                    Toast.makeText(MainActivity.this,"Logged in",Toast.LENGTH_SHORT).show();
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(MainActivity.this,"Logged In Failed",Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });







            }
        });
    }





}
