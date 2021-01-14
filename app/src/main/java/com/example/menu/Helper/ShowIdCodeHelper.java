package com.example.menu.Helper;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class ShowIdCodeHelper {

    ArrayList<String> itemList;
    DatabaseReference databaseReference;

    public void showListId(final Context context, final ListView listView, String category) {
        itemList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Spinner").child(category).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue() != null) {
                    String key = snapshot.getValue().toString();
                    int index = key.indexOf("-");
                    int count = 0;
                    while (count != key.length()-2){
                        count = key.indexOf("}", index);
                        String id = key.substring(index, index + 20);
                        index = key.indexOf("-", index+20);
                        String spinnerTitle = snapshot.child(id).child("title").getValue(String.class);
                        String spinnerCode = Integer.toString(snapshot.child(id).child("code").getValue(Integer.class));
                        String spinnerId = snapshot.child(id).child("id").getValue(String.class);
                        String menuString = spinnerTitle + " ID: " + spinnerCode;
                        loadList(context, listView, itemList, menuString);
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void loadList(Context context, ListView listView,  ArrayList<String> arrayList, String menuString) {
        arrayList.add(menuString);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context,android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
