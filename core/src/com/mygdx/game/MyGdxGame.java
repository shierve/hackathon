package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ApplicationAdapter {
	static final int WORLD_WIDTH = 1024;
	static final int WORLD_HEIGHT = 1024;
	private OrthographicCamera cam;


	SpriteBatch batch;
	Texture car, artificial, cop;

	Map map;
	Player player;
	Array<Cop> cops;
	Array<Artificial> artificials;
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		cam = new OrthographicCamera(2000, 2000 * (h / w));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		batch = new SpriteBatch();
		car = new Texture("cotxeblaudonut.png");
		artificial = new Texture("cotxenormalgroc.png");
		cop = new Texture("poli.png");

	}

	private void spawnCop(){
		//spawn a random cop outside view
	}

	private void spawnArtificial(){

	}

	@Override
	public void render () {
		cam.update();
		batch.setProjectionMatrix(cam.combined);

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(car, 0, 0);
		batch.draw(artificial, 100, 0);
		batch.draw(cop, 200, 0);
		batch.end();
	}
}
