package com.globlets.activity;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import com.globlets.Logger;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameScreenActivity extends ActivityScopeAware {
    public static final Logger logger = Logger.forClass(GameScreenActivity.class);

    @Override
    protected void createView() {
        setContentView(createSurface());
    }

    private GLSurfaceView createSurface() {
        GameSurfaceRenderer glRenderer = new GameSurfaceRenderer();
        return new GameSurfaceView(getApplicationContext(), glRenderer);
    }

    public static class GameSurfaceView extends GLSurfaceView {
        public GameSurfaceView(Context context, GLSurfaceView.Renderer renderer) {
            super(context);
            setRenderer(renderer);
            setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        }
    }

    public static class GameSurfaceRenderer implements GLSurfaceView.Renderer {
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            logger.info("surface created");
            gl.glEnable(GL10.GL_NORMALIZE);
            gl.glShadeModel(GL10.GL_SMOOTH);
            gl.glEnable(GL10.GL_DEPTH_TEST);
            gl.glDepthFunc(GL10.GL_LEQUAL);
            gl.glEnable(GL10.GL_LIGHTING);
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            logger.info("surface changed");
            gl.glViewport(0, 0, width, height);
            float ratio = (float) width / height;
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();
            GLU.gluPerspective(gl, 60, ratio, 0.1f, 100f);
            gl.glMatrixMode(GL10.GL_MODELVIEW);
        }

        public void onDrawFrame(GL10 gl) {
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
        }
    }
}
