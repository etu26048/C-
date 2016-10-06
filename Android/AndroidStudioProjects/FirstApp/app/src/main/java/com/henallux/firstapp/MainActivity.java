package com.henallux.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button bouton;
    private Intent intent;
    private FirstApp myApp;
    private ListView textView;
    //Log.d("PrintingFirstApp","FirstApp's VALUE");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myApp = (FirstApp)this.getApplicationContext();
        Log.i("onCreateTag","onCreate is executed");
        setContentView(R.layout.activity_main);
        //Permet de référencer via R.java la classe activity_main qui se trouve dans le package layout
        bouton = (Button) findViewById(R.id.buttonTest);
        //Permet de retrouver l'élément graphique de la vue (ici bouton) via l'id qu'on lui a attribué
        bouton.setOnClickListener(new View.OnClickListener() {
            //gestion d'évènements quand on click sur le bouton
            @Override
            public void onClick(View arg0) {
                //Toast.makeText(MainActivity.this,"Ceci est un bouton OK",Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,""+myApp.getNbClick(),Toast.LENGTH_SHORT).show();
            }
        });
        textView = (ListView) this.findViewById(R.id.listViewId);
        ArrayList<String> allText = new ArrayList<String>();
        allText.add("Affiche 1");
        allText.add("Affiche 2");
        allText.add("Affiche 3");
        allText.add("Affiche 4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allText);
        textView.setAdapter(adapter);
        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position : "+(++position),Toast.LENGTH_SHORT).show();
            }
        });

        //Labo2
        Button bouton_go_to_child_activity = (Button)findViewById(R.id.buttonChild);
        intent = new Intent(MainActivity.this,ChildActivity.class);
        bouton_go_to_child_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("infoId","Message sent by the parent");
                //permet d'envoyer du texte à l'activité enfant
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode == 1)
        {
            switch (resultCode){
                case 0 : Toast.makeText(MainActivity.this,"Result code = 0",Toast.LENGTH_SHORT).show();
                    break;
                case 1 : Toast.makeText(MainActivity.this,"Result code = 1",Toast.LENGTH_SHORT).show();
                    break;
            }
        }



    }


}
