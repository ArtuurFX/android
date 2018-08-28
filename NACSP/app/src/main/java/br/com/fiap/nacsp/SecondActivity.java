package br.com.fiap.nacsp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    RadioButton rbtRed;
    RadioButton rbtBlue;
    RadioButton rbtGreen;
    RadioGroup  rdgColor;
    View vwView;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rbtRed = findViewById(R.id.rbtRed);
        rbtBlue = findViewById(R.id.rbtBlue);
        rbtGreen = findViewById(R.id.rbtGreen);
        rdgColor = findViewById(R.id.rdgColor);
        vwView = findViewById(R.id.vwView);

        sp = getSharedPreferences("config2", MODE_PRIVATE);

        int color = sp.getInt("color", 0);

        if(color == 1){
            vwView.setBackgroundColor(Color.RED);
        }else if(color == 2){
            vwView.setBackgroundColor(Color.BLUE);
        }else if(color == 3){
            vwView.setBackgroundColor(Color.GREEN);
        }


    }

    public void save(View view) {

        SharedPreferences.Editor editor = sp.edit();
        int value = rdgColor.getCheckedRadioButtonId();

        switch (value){
            case R.id.rbtRed:
                vwView.setBackgroundColor(Color.RED);
                editor.putInt("color", 1);
                break;

            case R.id.rbtBlue:
                vwView.setBackgroundColor(Color.BLUE);
                editor.putInt("color", 2);
                break;

            case R.id.rbtGreen:
                vwView.setBackgroundColor(Color.GREEN);
                editor.putInt("color", 3);
                break;

        }
        editor.commit();

        Toast.makeText(this, "Color changed", Toast.LENGTH_SHORT).show();

    }
}
