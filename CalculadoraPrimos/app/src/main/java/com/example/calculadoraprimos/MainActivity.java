package com.example.calculadoraprimos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static private Boolean esPrimo(int n) {
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                cont++;
        }
        return cont == 2;
    }

    static private int primo(int n) {
        int i = 0, a = 0, cont = 0;
        while (cont < n) {
            if (esPrimo(i)) {
                a = i;
                cont++;
            }
            i++;
        }
        return a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularPrimo(View view) {
        EditText numero = (EditText) findViewById(R.id.posicion);
        try {

            int num = Integer.parseInt(numero.getText().toString());

            int res = primo(num);

            TextView resultado = (TextView) findViewById(R.id.resultado);
            resultado.setText("Solución: " + res);
        } catch (NumberFormatException nf) {
            Toast.makeText(this, "Debes introducir un número", Toast.LENGTH_SHORT).show();
        }
    }

}