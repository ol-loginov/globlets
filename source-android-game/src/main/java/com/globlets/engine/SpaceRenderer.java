package com.globlets.engine;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import com.globlets.Logger;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SpaceRenderer implements GLSurfaceView.Renderer {
    public static final Logger logger = Logger.forClass(SpaceRenderer.class);

    private final Space space;

    public SpaceRenderer(Space space) {
        this.space = space;
    }

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

        gl.glColor4f(1.0f, 1, 1, 1.0f);
        gl.glNormal3f(0, 0, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
    }
}
