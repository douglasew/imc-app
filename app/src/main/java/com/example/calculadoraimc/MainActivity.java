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
    TextView textResultado, textResultadoTable, textdescricao, textimcidael;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);

        textResultado = findViewById(R.id.textResultado);
        textResultadoTable = findViewById(R.id.textResultadoTable);
        textdescricao = findViewById(R.id.textdescricao);
        textimcidael = findViewById(R.id.textimcidael);

    }

    public void calcularIMC(View view) {

        float peso = Float.parseFloat(editPeso.getText().toString());
        float altura = Float.parseFloat(editAltura.getText().toString());

        float resultado = peso / (altura * altura);
        double pesoIdeal = (62.1 * altura) - 44.7;

        DecimalFormat decimal = new DecimalFormat("0.00");
        String resultadoFormatado = decimal.format(resultado);
        String resultadoIdeal = decimal.format(pesoIdeal);

        textResultado.setText("" + resultadoFormatado);

        if (resultado < 18.5) {
            textResultadoTable.setText("Abaixo do peso");
            textResultado.setTextColor(Color.YELLOW);
            textimcidael.setText("" + resultadoIdeal);
            textdescricao.setText("você deve continuar praticando atividade física, aumentar o volume das refeições e comer a cada 3 horas");
        } else if (resultado < 25) {
            textResultadoTable.setText("Peso Normal");
            textResultado.setTextColor(Color.GREEN);
            textimcidael.setText("" + resultadoIdeal);
            textdescricao.setText("Seu peso está adequado à altura. É importante manter a educação alimentar e a atividade física");
        } else if (resultado < 30) {
            textResultadoTable.setText("Sobrepeso");
            textResultado.setTextColor(Color.parseColor("#f0f059"));
            textimcidael.setText("" + resultadoIdeal);
            textdescricao.setText("Dependendo do seu histórico familiar e pessoal, pode haver um quadro de pré-diabetes e hipertensão");
        } else if (resultado < 35) {
            textResultadoTable.setText("Obesidade 1");
            textResultado.setTextColor(Color.parseColor("#ff9d00"));
            textimcidael.setText("" + resultadoIdeal);
            textdescricao.setText("O risco de desenvolver diabetes, para quem está nesta faixa de peso, é de 20%, e o de hipertensão ultrapassa 25%");
        } else if (resultado < 40) {
            textResultadoTable.setText("Obesidade 2");
            textResultado.setTextColor(Color.parseColor("#ff4545"));
            textimcidael.setText("" + resultadoIdeal);
            textdescricao.setText("O risco de desenvolver diabetes chega a 40%, e a chance de surgirem doenças associadas à obesidade, como hipertensão e outros problemas");
        } else {
            textResultadoTable.setText("Obesidade 3");
            textResultado.setTextColor(Color.RED);
            textimcidael.setText("" + resultadoIdeal);
            textdescricao.setText("O risco de desenvolver doenças associadas ao excesso de peso, como diabetes, problemas cardiovasculares chega a até 90%");
        }

    }
}