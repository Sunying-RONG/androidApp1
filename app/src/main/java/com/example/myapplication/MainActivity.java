package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      add view by java code
        LinearLayout monLinearLayout = new LinearLayout(this);
        monLinearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView nom = new TextView(this);
        nom.setText("Nom: ");
        EditText editNom = new EditText(this);

        TextView prenom = new TextView(this);
        prenom.setText("Prénom: ");
        EditText editPrenom = new EditText(this);

        TextView age = new TextView(this);
        age.setText("Âge: ");
        EditText editAge = new EditText(this);

        TextView competences = new TextView(this);
        competences.setText("Compétences: ");
        EditText editCompetences = new EditText(this);

        TextView numPhone = new TextView(this);
        numPhone.setText("Téléphone: ");
        EditText editNumphone = new EditText(this);

        Button valider = new Button(this);
        valider.setText("Valider");

        monLinearLayout.addView(nom);
        monLinearLayout.addView(editNom);
        monLinearLayout.addView(prenom);
        monLinearLayout.addView(editPrenom);
        monLinearLayout.addView(age);
        monLinearLayout.addView(editAge);
        monLinearLayout.addView(competences);
        monLinearLayout.addView(editCompetences);
        monLinearLayout.addView(numPhone);
        monLinearLayout.addView(editNumphone);
        monLinearLayout.addView(valider);

//      add view in activity_main.xml
        setContentView(R.layout.activity_main);
//      add view by java function
//        setContentView(monLinearLayout);

    }

    public void sendMessage(View view) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        final View popupView = inflater.inflate(R.layout.validation, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


//      dismiss popup window by clicking cancel button
        Button buttonCancel = popupView.findViewById(R.id.cancel);
        buttonCancel.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        }));
    }
    public void validateConfirm(View view) {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);

        EditText last_name_input = findViewById(R.id.last_name);
        String last_name = last_name_input.getText().toString();
        intent.putExtra("last_name", last_name);

        EditText first_name_input = findViewById(R.id.first_name);
        String first_name = first_name_input.getText().toString();
        intent.putExtra("first_name", first_name);

        EditText age_input = findViewById(R.id.age);
        String age = age_input.getText().toString();
        intent.putExtra("age", age);

        EditText competences_input = findViewById(R.id.competences);
        String competences = competences_input.getText().toString();
        intent.putExtra("competences", competences);

        EditText telephone_input = findViewById(R.id.telephone);
        String telephone = telephone_input.getText().toString();
        intent.putExtra("telephone", telephone);

        startActivity(intent);
    }
}


