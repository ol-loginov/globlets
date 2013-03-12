package com.globlets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GGame extends Game {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Rectangle bucket;
    private Texture bucketImage;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        batch = new SpriteBatch();

        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
        bucket = new Rectangle();
        bucket.x = 800 / 2 - 48 / 2;
        bucket.y = 20;
        bucket.width = 48;
        bucket.height = 48;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(bucketImage, bucket.x, bucket.y);
        batch.end();
    }
}
