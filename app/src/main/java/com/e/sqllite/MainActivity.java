package com.e.sqllite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.MyHelper;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id =  myHelper.InsertData(etUsername.getText().toString(), etPassword.getText().toString(),sqLiteDatabase);
                if (id > 0) {
                    Toast.makeText(MainActivity.this,"Successfull"+ id,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });












    }
}
