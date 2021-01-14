package com.example.menu.Helper;

import android.widget.EditText;
import com.example.menu.Classes.MenuItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertIdCodeHelper {

   private DatabaseReference databaseReference;
   private MenuItem menuItem;

   public boolean registerMenu(EditText title, EditText code, String id) {
if (checkfield(title,code)) {
       menuItem = new MenuItem();
       int cod = Integer.parseInt(code.getText().toString().trim());
       menuItem.setCode(cod);
       menuItem.setTitle(title.getText().toString().trim());
       menuItem.setId(id);
       String reference = menuItem.getId();
       databaseReference = FirebaseDatabase.getInstance().getReference("Spinner").child(reference);
       databaseReference.push().setValue(menuItem);
       return true;
}
else  return false;
   }

    public boolean checkfield(EditText title, EditText code) {
        boolean registrable = true;

        if (title.getText().toString().trim().equals("")) {
            title.setError("Campo Vuoto");
            registrable = false;
        }

        if (code.getText().toString().trim().equals("")) {
            code.setError("Campo Vuoto");
            registrable = false;
        }

        return registrable;

    }

}
