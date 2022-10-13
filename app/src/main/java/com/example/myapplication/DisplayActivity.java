package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        Intent intent = getIntent();

        TextView receiver_last_name = findViewById(R.id.last_name);
        String last_name = intent.getStringExtra("last_name");
        receiver_last_name.setText(last_name);

        TextView receiver_first_name = findViewById(R.id.first_name);
        String first_name = intent.getStringExtra("first_name");
        receiver_first_name.setText(first_name);

        TextView receiver_age = findViewById(R.id.age);
        String age = intent.getStringExtra("age");
        receiver_age.setText(age);

        TextView receiver_competences = findViewById(R.id.competences);
        String competences = intent.getStringExtra("competences");
        receiver_competences.setText(competences);

        TextView receiver_telephone = findViewById(R.id.telephone);
        String telephone = intent.getStringExtra("telephone");
        receiver_telephone.setText(telephone);
    }

    public void okButton(View view) {
        Intent intent = new Intent(getApplicationContext(), OkActivity.class);

        TextView telephone_input = findViewById(R.id.telephone);
        String telephone = telephone_input.getText().toString();
        intent.putExtra("telephone", telephone);

        startActivity(intent);
    }
    public void returnButton(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);
    }

}
