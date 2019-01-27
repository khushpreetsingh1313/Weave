package com.example.weave;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.constraint.solver.widgets.ConstraintTableLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactsActivity extends AppCompatActivity {
    //https://www.youtube.com/watch?v=g4C8IHzaTv0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        Button create_contact = findViewById(R.id.CreateContact);
        create_contact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                EditText FirstName = findViewById(R.id.FirstName);
                EditText LastName = findViewById(R.id.LastName);
                EditText PhoneNumber = findViewById(R.id.PhoneNumber);
                EditText EmailAddress = findViewById(R.id.EmailAddress);


                if(FirstName.getText().toString().isEmpty() || LastName.getText().toString().isEmpty() || PhoneNumber.getText().toString().isEmpty()) {
                    Toast.makeText(AddContactsActivity.this, "Please make sure all required information is entered", Toast.LENGTH_SHORT).show();
                }
                if(!EmailAddress.getText().toString().isEmpty() & !EmailAddress.getText().toString().contains("@") || !EmailAddress.getText().toString().contains(".")) {
                    Toast.makeText(AddContactsActivity.this, "Email does not have the required format", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent
                            .putExtra(ContactsContract.Intents.Insert.EMAIL, EmailAddress.getText())
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.PHONE, PhoneNumber.getText())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MAIN)
                            .putExtra(ContactsContract.Intents.Insert.NAME, FirstName.getText() + " " + LastName.getText())
                    ;

                    startActivity(intent);
                }


            }
        });
    }



}
