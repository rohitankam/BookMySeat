package com.bookmyseat.rohit.bookmyseat;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUPActivity extends AppCompatActivity {

    EditText ename,eemail,epass,erepass,ephone;
    private  String name,email,pass,repass,phone;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ename=(EditText)findViewById(R.id.input_name);
        eemail=(EditText)findViewById(R.id.input_email);
        epass=(EditText)findViewById(R.id.input_password);
        erepass=(EditText)findViewById(R.id.input_reenter);
        ephone=(EditText)findViewById(R.id.input_phone);
        b1=(Button)findViewById(R.id.signup);

    }

    public void home(View view) {
        NavUtils.navigateUpFromSameTask(this);
    }

    public void Signup(View view) {
        register();
    }

    public void register(){
        initialize();
        if(!valid()){
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
        }
        else
        {
            SignupSuccess();
        }
    }

    public void SignupSuccess(){
        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
    }

    public boolean valid(){
        boolean valid =true;
        if(name.isEmpty()||name.length()>32){
            ename.setError("Please enter valid name");
            valid=false;
        }
        if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            eemail.setError("Please enter valid email");
            valid=false;
        }
        if(pass.isEmpty()){
            epass.setError("Please enter valid password");
            valid=false;
        }
        if(pass.length()<8){
            epass.setError("Minimum 8 characters");
            valid=false;
        }
        if(name.isEmpty()||!repass.equals(pass)){
            erepass.setError("Password doesnt match");
            valid=false;
        }
        if(phone.isEmpty()||phone.length()>10||phone.length()<10){
            ephone.setError("Please enter valid phone");
            valid=false;
        }
        return valid;
    }
    public void initialize(){
        name=ename.getText().toString().trim();
        email=eemail.getText().toString().trim();
        pass=epass.getText().toString().trim();
        repass=erepass.getText().toString().trim();
        phone=ephone.getText().toString().trim();
    }
}
