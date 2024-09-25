package com.example.prueba1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Elementos de la clase

    TextView resultado;
    Button btn1;
    ToggleButton btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        resultado = findViewById(R.id.textViewHellow);
        btn1 = findViewById(R.id.btnComenzar);
        btn2 = findViewById(R.id.toggleButtonActivar);


        MostrarBtn1(resultado); // Metodo que cambia el textView

        // Eventos de la clase

        // Evento que comprueba si el botton esta seleccionado o no
        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MostrarBtn2();
            }
        });

        // Eventos btn1 onclick

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("Has pulsado el Botón!");
            }
        });



    }

    // Evento que muestra cambia el texto del texview

    public void MostrarBtn1(View vista ){
        resultado.setText("Pulsado boton"); // Cambia el texto del textView
    }

    // Metodo que comprueba si el toggleButton es seleccionado

    public void MostrarBtn2(){
        if( btn2.isChecked() ){
            resultado.setText("Botón Acativado");
        }else{
            resultado.setText("Botón Desactivado");
        }
    }


}