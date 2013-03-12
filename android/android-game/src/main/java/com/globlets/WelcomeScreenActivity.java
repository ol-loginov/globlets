package com.globlets;

import android.content.Intent;
import android.view.View;

public class WelcomeScreenActivity extends ActivityScopeAware {
    public static final Logger logger = Logger.forClass(WelcomeScreenActivity.class);

    @Override
    protected void createView() {
        setContentView(R.layout.welcome);
        findViewById(R.id.welcome_btn_newGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent().setClass(getApplicationContext(), GameScreenActivity.class));
            }
        });
    }
}

