package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editPeso, editAltura;
    TextView textResultado, textResultadoTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);

        textResultado = findViewById(R.id.textResultado);
        textResultadoTable = findViewById(R.id.textResultadoTable);

    }

    public void calcularIMC(View view) {

        float peso = Float.parseFloat(editPeso.getText().toString());
        float altura = Float.parseFloat(editAltura.getText().toString());

        float resultado = peso / (altura * altura);

        DecimalFormat decimal = new DecimalFormat("0.00");
        String resultadoFormatado = decimal.format(resultado);

        textResultado.setText("Seu IMC: " + resultadoFormatado);

        if (resultado < 18.5) {
            textResultadoTable.setText("Abaixo do peso");
        } else if (resultado < 25) {
            textResultadoTable.setText("Peso Normal");
        } else if (resultado < 30) {
            textResultadoTable.setText("Sobrepeso");
        } else if (resultado < 35) {
            textResultadoTable.setText("Obesidade 1");
        } else if (resultado < 40) {
            textResultadoTable.setText("Obesidade 2");
        } else {
            textResultadoTable.setText("Obesidade 3");
        }

    }
}