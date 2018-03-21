package br.com.fiap.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdgPizzas;
    CheckBox chkBordaRecheada;
    RadioButton rdbMussarela;
    RadioButton rdbCalabresa;
    RadioButton rdbPortuguesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgPizzas = findViewById(R.id.rdgPizzas);
        chkBordaRecheada = findViewById(R.id.chkBordaRechada);
        rdbMussarela = findViewById(R.id.rdbMussarela);
        rdbCalabresa = findViewById(R.id.rdbCalabresa);
        rdbPortuguesa = findViewById(R.id.rdbPortuguesa);
    }

    public void Retornar(View view){

        CheckBox chkBordaRecheada = (CheckBox)findViewById(R.id.chkBordaRechada);
        if (rdbCalabresa.isChecked()){
            chkBordaRecheada.setEnabled(true);
        }
        if (rdbPortuguesa.isChecked()){
            chkBordaRecheada.setEnabled(true);
        }
    }

    public void Selecionar(View view){

        CheckBox chkBordaRecheada = (CheckBox)findViewById(R.id.chkBordaRechada);
        if (rdbMussarela.isChecked()){
            chkBordaRecheada.setEnabled(false);
        } else{
            chkBordaRecheada.setEnabled(true);
        }

    }

    public void Calcular(View view) {
        double resultado = 0;

        int selecionado = rdgPizzas.getCheckedRadioButtonId();

        switch (selecionado){
            case R.id.rdbMussarela:
                resultado = 10;
                break;
            case R.id.rdbCalabresa:
                resultado = 15;
                break;
            case R.id.rdbPortuguesa:
                resultado = 20;
                break;
            case R.id.rdbBrigadeiro:
                resultado = 18;
                break;
            case R.id.rdbRomeuJulieta:
                resultado = 22;
                break;
        }

        if (chkBordaRecheada.isChecked()){
            resultado += 5;
        }



        Toast.makeText(this, String.valueOf(resultado), Toast.LENGTH_SHORT).show();


    }
}
