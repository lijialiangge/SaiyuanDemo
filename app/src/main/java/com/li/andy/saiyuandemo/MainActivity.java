package com.li.andy.saiyuandemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import layout.guide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main1,new guide()).commit();
        }
    }
}
