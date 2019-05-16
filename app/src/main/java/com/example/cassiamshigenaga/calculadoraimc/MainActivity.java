package com.example.cassiamshigenaga.calculadoraimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MENSAGEM = "com.example.imccal.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcula (View view) {
        EditText edPeso = findViewById(R.id.edTextPeso);
        EditText edAltura = findViewById(R.id.edTextAltura);
        TextView textResultado = findViewById(R.id.tVResultado);
        String resultadoTexto;

        //para usar numeros quebrados (double)
        Double peso = Double.parseDouble(edPeso.getText().toString());
        Double altura = Double.parseDouble(edAltura.getText().toString());

        Double resultado = peso / (altura * altura);

        textResultado.setText ("Resultado: " + String.format("%.2f ", resultado));


        if (resultado < 18.5){
            resultadoTexto = "Resultado: " + String.format("%.2f ", resultado) + "Abaixo do Peso!";
        }
        else if (resultado >= 25) {
            resultadoTexto = "Resultado: " + String.format("%.2f ", resultado) + "Acima do Peso!";
        }
        else {
            resultadoTexto = "Resultado: " + String.format("%.2f ", resultado) + "Peso ideal!";
        }

        //para chamar formulario (activity) - intent
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra(MENSAGEM, resultadoTexto);
        startActivity(intent);
    }
}
