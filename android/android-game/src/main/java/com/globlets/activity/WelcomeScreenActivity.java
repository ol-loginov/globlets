package com.globlets.activity;

import android.content.Intent;
import android.view.View;
import com.globlets.R;

public class WelcomeScreenActivity extends ActivityScopeAware {
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

