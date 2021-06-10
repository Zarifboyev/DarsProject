package com.example.dars2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, surname, phone;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        phone = findViewById(R.id.phone);

        save = findViewById(R.id.save);

        save.setOnClickListener(v -> {
            if (name.getText().toString().isEmpty() && surname.getText().toString().isEmpty() && phone.getText().toString().isEmpty()) {
                name.setError("Ismni kiriting");
                surname.setError("Familyani kiriting");
                phone.setError("Telefonni kiriting");
                name.requestFocus();
            } else {
                User user = new User();
                user.setName(name.getText().toString());
                user.setSurname(surname.getText().toString());
                user.setPhone(phone.getText().toString());
                user.save();
            }
        });
    }
}