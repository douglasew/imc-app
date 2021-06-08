package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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
            textResultadoTable.setTextColor(Color.YELLOW);
        } else if (resultado < 25) {
            textResultadoTable.setText("Peso Normal");
            textResultadoTable.setTextColor(Color.GREEN);
        } else if (resultado < 30) {
            textResultadoTable.setText("Sobrepeso");
            textResultadoTable.setTextColor(Color.parseColor("#f0f059"));
        } else if (resultado < 35) {
            textResultadoTable.setText("Obesidade 1");
            textResultadoTable.setTextColor(Color.parseColor("#ff9d00"));
        } else if (resultado < 40) {
            textResultadoTable.setText("Obesidade 2");
            textResultadoTable.setTextColor(Color.parseColor("#ff4545"));
        } else {
            textResultadoTable.setText("Obesidade 3");
            textResultadoTable.setTextColor(Color.RED);
        }

    }
}