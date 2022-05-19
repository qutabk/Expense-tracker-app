package com.example.expense_manager112;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_itro);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    //asdf
                    sleep(2000);
                    Intent i=new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}