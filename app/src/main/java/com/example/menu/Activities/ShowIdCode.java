package com.example.menu.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.Helper.ShowIdCodeHelper;
import com.example.menu.R;

public class ShowIdCode extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ListView listView;
    ShowIdCodeHelper showIdCodeHelper;
    String category;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_id_code);
        category = "";
        spinner = findViewById(R.id.spinnerTest);
        spinner.setOnItemSelectedListener(this);
        listView = findViewById(R.id.listView);
        showIdCodeHelper = new ShowIdCodeHelper();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        category = adapterView.getSelectedItem().toString();
        showIdCodeHelper.showListId(getApplicationContext(), listView, category);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}
