package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ok);

        Intent intent = getIntent();

        TextView receiver_telephone = findViewById(R.id.telephone);
        String telephone = intent.getStringExtra("telephone");
        receiver_telephone.setText(telephone);
    }

    public void callButton(View view) {
        TextView telephone_input = findViewById(R.id.telephone);
        String telephone = telephone_input.getText().toString();

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+telephone));
        startActivity(callIntent);
    }
}
