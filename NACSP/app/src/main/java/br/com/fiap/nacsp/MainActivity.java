package br.com.fiap.nacsp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edtUser;
    EditText edtPassword;
    CheckBox chkConected;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        chkConected = findViewById(R.id.chkConected);

        sp = getSharedPreferences("config", MODE_PRIVATE);

        edtUser.setText(sp.getString("user", null));
        edtPassword.setText(sp.getString("password", null));

    }

    public void signIn(View view) {
        SharedPreferences.Editor editor = sp.edit();

        if(edtUser.getText().toString().equals("FIAP") && edtPassword.getText().toString().equals("123456")){
            editor.putString("user", edtUser.getText().toString());
            editor.putString("password", edtPassword.getText().toString());
            editor.commit();

            Intent i = new Intent(this, SecondActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Invalid user or password", Toast.LENGTH_SHORT).show();
        }


    }
}
