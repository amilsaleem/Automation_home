package com.example.light;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    static String ip_address="192.168.0.109";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      final  Switch s = findViewById(R.id.switch1);
        TextView t=findViewById(R.id.textView);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,ip_address+isconn(MainActivity.this),Toast.LENGTH_SHORT).show(); ;

            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean b = s.isChecked();

                //Toast.makeText(MainActivity.this,"s=="+b,Toast.LENGTH_SHORT).show();


                        WebView bView = (WebView) findViewById(R.id.view1);
                        bView.loadUrl("http://"+ip_address+"/on");

                    /*      Intent br=new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+ip.getip_address()+"/on")) ;
                          startActivity(br);

                     */

                      /*  Intent br=new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+ip.getip_address()+"/on")) ;
                        startActivity(br);

                        /*try {
                            //new setUp(1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/
                              }
        });





    }

    public boolean isconn(Context c){
        ConnectivityManager connectivityManager=(ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=connectivityManager.getActiveNetworkInfo();
        if (ni!=null && ni.isConnectedOrConnecting()){
            android.net.NetworkInfo wifi=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mob=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifi!=null && wifi.isConnectedOrConnecting()) return true;
            else return false;
        }
        else
            return false;
    }

}
