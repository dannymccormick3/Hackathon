package com.hack.hb.buddycar;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import static com.hack.hb.buddycar.R.layout.activity_main;


public class EditProfile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        final Button submitButton = (Button) findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText txtName = (EditText) findViewById(R.id.name);
                EditText txtBio = (EditText) findViewById(R.id.bio);
                EditText txtAge = (EditText) findViewById(R.id.age);
                EditText txtGender = (EditText) findViewById(R.id.gender);

                int age = Integer.parseInt(txtAge.getText().toString());

                String name = txtName.getText().toString();
                String bio = txtBio.getText().toString();
                String gender = txtGender.getText().toString();

                Profile newProf= new Profile(name, bio, age, gender);
                //TODO-link this to database

                CharSequence stringId = "Success! Your rating is " + newProf.rating;
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.layout_id), stringId, 5);
                mySnackbar.show();
            }
        });



    }
}

