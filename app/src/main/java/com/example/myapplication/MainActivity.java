
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText editText;
    Button buttonWstecz, buttonDalej;

    int index;
    List<ObrazZOpisem> listaObrazkow = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editTextOpis);
        buttonWstecz = findViewById(R.id.buttonWstecz);
        buttonDalej = findViewById(R.id.buttonDalej);

        index = 0;

        listaObrazkow.add(
                new ObrazZOpisem(R.drawable.zad1, ""));
        listaObrazkow.add(
                new ObrazZOpisem(R.drawable.zad2, ""));
        listaObrazkow.add(
                new ObrazZOpisem(R.drawable.zad3, ""));

        wyswietlObraz(index);

        buttonWstecz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zapiszOpis();

                if (index == 0) {
                    index = listaObrazkow.size() - 1;
                } else {
                    index--;
                }

                wyswietlObraz(index);
            }
        });

        buttonDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zapiszOpis();

                if (index < listaObrazkow.size() - 1) {
                    index++;
                } else {
                    index = 0;
                }

                wyswietlObraz(index);
            }
        });
    }

    private void zapiszOpis() {
        String opis = editText.getText().toString();
        listaObrazkow.get(index).setOpis(opis);
    }

    private void wyswietlObraz(int index) {
        imageView.setImageResource(
                listaObrazkow.get(index).getIdObrazka());

        editText.setText(
                listaObrazkow.get(index).getOpis());
    }
}
