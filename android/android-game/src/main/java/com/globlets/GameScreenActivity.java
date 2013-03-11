package com.globlets;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class GameScreenActivity extends Activity {
    public static final Logger logger = Logger.forClass(WelcomeScreenActivity.class);

    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logger.enter("onCreate");
        super.onCreate(savedInstanceState);
        initializeView();
        logger.leave("onCreate");
    }

    private void initializeView() {
        setContentView(createSurface());
    }

    private GLSurfaceView createSurface() {
        glSurfaceView = new GLSurfaceView(getApplicationContext());
        return glSurfaceView;
    }
}
