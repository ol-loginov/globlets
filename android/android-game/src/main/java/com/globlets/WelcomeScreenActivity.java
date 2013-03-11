package com.globlets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreenActivity extends Activity {
    public static final Logger logger = Logger.forClass(WelcomeScreenActivity.class);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        logger.enter("onCreate");
        super.onCreate(savedInstanceState);
        initializeView();
        logger.leave("onCreate");
    }

    private void initializeView() {
        setContentView(R.layout.welcome);
        findViewById(R.id.welcome_btn_newGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent().setClass(getApplicationContext(), GameScreenActivity.class));
            }
        });
    }
}

