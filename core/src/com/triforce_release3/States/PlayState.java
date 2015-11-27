package com.triforce_release3.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.triforce_release3.HUD;
import com.triforce_release3.SoundFiles;
import com.triforce_release3.TriForceRelease3;

/**
 * Created by Matthew on 11/10/2015.
 */
public class PlayState extends TriForceRelease3 implements Screen, InputProcessor {

    TriForceRelease3 triForceRelease3;
    private HUD hud;

    SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private Animation animation;
    private float elapsedTime = 0f;

    public PlayState(TriForceRelease3 triForceRelease3){ //References the main class.
        this.triForceRelease3=triForceRelease3;
        hud = new HUD(triForceRelease3.batch);
    }

    public void create(){
        Gdx.input.setInputProcessor(this); //Have to change the Input Processor when changing screens, or else you can still use the buttons from the Main Menu on the Play Screen.
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("Megaman.pack"));
        animation = new Animation(1f/6f, textureAtlas.getRegions());

    }

    @Override
    public void show() { //This is called when you set the screen to this class.
        create();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1); //Blue background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        hud.stage.draw();
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw(animation.getKeyFrame(elapsedTime,true),150,180);
        batch.end();
        if(Gdx.input.justTouched()){
            SoundFiles.megamanSound.play();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() { //This is called when the other screen is displayed.

    }

    @Override
    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
