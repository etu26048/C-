package com.henallux.labo3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        this.getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId())
        {
            case R.id.itemPhoneID:
                MakeAPhoneCall();
                return true;
            case R.id.itemMessageID:
                Toast.makeText(MainActivity.this,"Message",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemChildActivityID:
                NavigateToSecondPage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void NavigateToSecondPage()
    {
        Intent intent = new Intent(MainActivity.this,ChildActivity.class);
        startActivity(intent);
    }
    public void MakeAPhoneCall()
    {
        android.net.Uri uri= Uri.parse("tel:0496630154");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}
