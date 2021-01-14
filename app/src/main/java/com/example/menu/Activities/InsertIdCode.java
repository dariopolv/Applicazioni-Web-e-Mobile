package com.example.menu.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.Helper.InsertIdCodeHelper;
import com.example.menu.R;

public class InsertIdCode extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText title;
    EditText code;
    String id;
    Button insert;
    Spinner selectionSpinner;
    InsertIdCodeHelper insertIdCodeHelper;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_id_code);
        title = findViewById(R.id.title);
        code = findViewById(R.id.code);
        insert = findViewById(R.id.caricaspinner);
        insertIdCodeHelper = new InsertIdCodeHelper();
        id = "";
        selectionSpinner = findViewById(R.id.selectionSpinner);
        selectionSpinner.setOnItemSelectedListener(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (insertIdCodeHelper.registerMenu(title, code, id)) {
                    Toast.makeText(InsertIdCode.this, "Registrato con successo", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), ShowIdCode.class);
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(), "Errore in fase di inserimento", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        id = adapterView.getSelectedItem().toString();
        Toast.makeText(this, adapterView.getSelectedItem().toString() + " Selezionato", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

