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

public class signup extends AppCompatActivity {

    EditText Name;
    EditText Password;
    Button sign;
    EditText Phone_no;
    EditText Email;
    TextView Login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth=FirebaseAuth.getInstance();

        Name= (EditText)findViewById(R.id.name);
        Password=(EditText)findViewById(R.id.password);
        sign=(Button)findViewById(R.id.signup);
        Phone_no=(EditText)findViewById(R.id.phone);
        Email=(EditText)findViewById(R.id.email);
        Login=(TextView)findViewById(R.id.signin);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String useremail=Email.getText().toString();
               String userpassword=Password.getText().toString();
               if(useremail.isEmpty())
               {}
               else if(userpassword.isEmpty())
               {}
               else if (!(useremail.isEmpty() && userpassword.isEmpty()))
               { mAuth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful())
                  {
                      Intent intent= new Intent(signup.this,drawer.class);
                      Toast.makeText(signup.this,"Register Successfull",Toast.LENGTH_SHORT).show();
                      startActivity(intent);
                  }
                  else
                       {Toast.makeText(signup.this,"signup unsuccessfull",Toast.LENGTH_SHORT).show();}
                   }
               });

               }



            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(signup.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
