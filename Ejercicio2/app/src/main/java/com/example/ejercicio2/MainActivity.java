package com.example.ejercicio2;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ToggleButton btnOcultarMostrar ;
    ImageView imageView;

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

        btnOcultarMostrar = findViewById(R.id.btnOcultar);
        imageView = findViewById(R.id.image);

        // Metodo que oculta la imagen o la muestra
        // setVisibility -> metodo que nos permite modificar la visibilidad de una imagen

        btnOcultarMostrar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if( btnOcultarMostrar.isChecked() ){
                   imageView.setVisibility(View.INVISIBLE);
                }else{
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}