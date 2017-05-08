package com.li.andy.saiyuandemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static  boolean isFirst=false;
    private static final int Go_Home=1000;
    private static final int Go_Guide=1001;
    private Handler mHandler;
    private static final int timess=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case Go_Home:

                        gohome();
                        break;

                    case Go_Guide:

                        goguide();
                        break;
                }
            }
        };



        initSave();



    }

    public void gohome(){
        Intent intent=new Intent(this,Main.class);
        startActivity(intent);
        finish();
    }

    public void goguide(){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main1,new guide()).commit();

    }

    public void initSave(){

        SharedPreferences sp = getSharedPreferences("ok",MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        isFirst=sp.getBoolean("isfirstin",true);
        if(!isFirst){
            mHandler.sendEmptyMessageAtTime(Go_Home,timess);

        }else{

            mHandler.sendEmptyMessageAtTime(Go_Guide,timess);
            edit.putBoolean("isfirstin",false);
            edit.commit();
        }
        Log.i("isfirstin:", String.valueOf(isFirst));

    };





}
