package com.globlets.activity;

import android.app.Activity;
import android.os.Bundle;

public abstract class ActivityScopeAware extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createView();
    }

    protected abstract void createView();
}
