package com.cdut.coolweather;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("weather",null) != null) {
            Intent intent = new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();
        }
        checkNetWork();
    }

    private void checkNetWork() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivity.getActiveNetworkInfo();
        if ( info!= null && info.isAvailable()) {
            //正常上网状况
        } else {
            Toast.makeText(this,"亲,你没有联网哦!",Toast.LENGTH_LONG).show();
        }
    }
}
