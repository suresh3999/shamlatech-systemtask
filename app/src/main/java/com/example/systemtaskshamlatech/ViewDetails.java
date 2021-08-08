package com.example.systemtaskshamlatech;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ViewDetails extends AppCompatActivity {

    String id1,email,firstname,lastname,img;
    TextView email1,firstname1,lastname1;
    ImageView img1;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        Intent i = getIntent();
        id1 = i.getStringExtra("id");
        email = i.getStringExtra("email");
        firstname = i.getStringExtra("firstname");
        lastname = i.getStringExtra("lastname");
        img = i.getStringExtra("imagurl");



        email1=(TextView)findViewById(R.id.idEmail);
        firstname1=(TextView)findViewById(R.id.idFirstName);
        lastname1=(TextView)findViewById(R.id.idLastName);
        img1=(ImageView)findViewById(R.id.idIVUser);

        email1.setText(email);
        firstname1.setText(firstname);
        lastname1.setText(lastname);

        Picasso.with(context)
                .load(img)
                .into(img1);




    }
}
