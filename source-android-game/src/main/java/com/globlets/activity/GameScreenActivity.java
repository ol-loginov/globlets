package com.globlets.activity;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.globlets.Logger;
import com.globlets.engine.Space;
import com.globlets.engine.SpaceRenderer;

public class GameScreenActivity extends ActivityScopeAware {
    public static final Logger logger = Logger.forClass(GameScreenActivity.class);

    private Space space;

    @Override
    protected void createView() {
        setContentView(createSurface());
    }

    private GLSurfaceView createSurface() {
        return new GameSurfaceView(getApplicationContext(), new SpaceRenderer(createSpace()));
    }

    private Space createSpace() {
        return space = new Space();
    }

    public static class GameSurfaceView extends GLSurfaceView {
        private final SpaceRenderer renderer;

        public GameSurfaceView(Context context, SpaceRenderer renderer) {
            super(context);
            this.renderer = renderer;

            setRenderer(renderer);
            setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
            requestRender();
        }
    }
}
