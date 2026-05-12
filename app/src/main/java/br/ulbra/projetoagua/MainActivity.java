package br.ulbra.projetoagua;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     Button btnCalcular;
     EditText edtPeso, edtIdade,edtConsumo, edtModo;
     TextView txtRes;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtConsumo = findViewById(R.id.edtConsumo);
        edtIdade = findViewById(R.id.edtIdade);
        edtPeso = findViewById(R.id.edtPeso);
        edtModo = findViewById(R.id.edtModo);
        txtRes = findViewById(R.id.txtRes);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(edtPeso.getText().toString());
                int idade = Integer.parseInt(edtIdade.getText().toString());
                double consumo = Double.parseDouble(edtConsumo.getText().toString());
                int modo = Integer.parseInt(edtModo.getText().toString());


                if (peso <= 0 || idade <= 0) {
                    Toast.makeText(MainActivity.this,
                            "digite um valor maior que zero",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                double extra;

                if (modo == 1) {
                    extra = 0;

                } else if (modo == 2) {
                    extra = 300;

                } else if (modo == 3) {
                    extra = 600;

                } else {
                    Toast.makeText(MainActivity.this,
                            "Modo invalido",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                double consumoBase = peso * 35;
                double CT = consumoBase + extra;
                double R = CT - consumo;

                String resultado =
                        "Meta diária: " + CT + " ml" +
                                "\nFaltam: " + R + " ml";

                txtRes.setText(resultado);
            }
        });


        }
    }

