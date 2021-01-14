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

public class MenuWebHandler extends Fragment {
    Button uploadMenu;
    Button showUploadedMenu;
    Button changeMenu;
    Button signout;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public MenuWebHandler() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_web_handler, container, false);
        uploadMenu = view.findViewById(R.id.uploadButton);
        showUploadedMenu = view.findViewById(R.id.showMenu);
        changeMenu = view.findViewById(R.id.change);
        signout = view.findViewById(R.id.signout);

        uploadMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotouploadMenu();
            }
        });

        showUploadedMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoshowUploadedMenu();
            }
        });

        changeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotochangeMenu();
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

    private void gotochangeMenu() {
    Intent intent = new Intent(getContext(), ChangeMenu.class);
    startActivity(intent);
    }

    private void gotoshowUploadedMenu() {
    Intent intent = new Intent(getContext(), ShowMenu.class);
    startActivity(intent);
    }

    private void gotouploadMenu() {
        Intent intent = new Intent(getContext(), UploadMenu.class);
        startActivity(intent);
    }
}
