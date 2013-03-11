package com.globlets;

import android.app.Activity;
import android.os.Bundle;

public class WelcomeScreenActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogS.info("onCreate");
        setContentView(R.layout.welcome);
    }
}

