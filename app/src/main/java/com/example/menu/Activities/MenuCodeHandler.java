package com.example.menu.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.menu.R;
import com.google.firebase.auth.FirebaseAuth;

public class MenuCodeHandler extends Fragment {

   Button showidmenu;
   Button addidtolist;
   Button signout;
   FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public MenuCodeHandler() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.menu_code_handler, container, false);
            showidmenu = view.findViewById(R.id.showIdListButton);
            addidtolist = view.findViewById(R.id.addIdListButton);
            signout = view.findViewById(R.id.signout_button);
            showidmenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoshowid();
                }
            });
            addidtolist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoaddidtolist();
                }
            });
            signout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAuth.signOut();
                    logout();
                }
            });
            return view;
    }

    private void logout() {
        Toast.makeText(getContext(), "Disconnesso", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getContext(), Login.class);
        startActivity(intent);
    }

    private void gotoaddidtolist() {
        Intent intent = new Intent(getContext(), InsertIdCode.class);
        startActivity(intent);
    }

    private void gotoshowid() {
        Intent intent = new Intent(getContext(), ShowIdCode.class);
        startActivity(intent);
    }
}