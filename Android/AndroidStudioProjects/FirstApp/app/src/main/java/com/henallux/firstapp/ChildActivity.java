package com.henallux.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.net.Uri;

/**
 * Created by dark- on 28/09/2016.
 */

public class ChildActivity extends AppCompatActivity {

    private Bundle bundle;
    private Button bouton;
    private Button boutonPhoneCall;
    private Button boutonInternet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        bundle = this.getIntent().getExtras();
        //On récupère l'intent associé à l'activité et on récupère le dictionnaire
        Toast.makeText(ChildActivity.this,bundle.getString("infoId"),Toast.LENGTH_SHORT).show();
        bouton = (Button)findViewById(R.id.buttonResult);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                //à quoi ça sert concrètement ?
                finish();
                //l'application se finit et retourne à la main activity
            }
        });
        boutonPhoneCall = (Button) findViewById(R.id.buttonCall);
        boutonPhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.net.Uri uri = Uri.parse("tel:0496630154");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        boutonInternet = (Button) findViewById(R.id.buttonInternet);
        boutonInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.net.Uri uri = Uri.parse("http://www.facebook.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
}
