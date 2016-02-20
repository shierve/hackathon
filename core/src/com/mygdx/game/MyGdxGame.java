package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture car1, car2, car3;

	Map map;
	Player player;
	Array<Cop> cops;
	Array<Artificial> artificials;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		car1 = new Texture("cotxenormal.png");
		car2 = new Texture("cotxenormalgroc.png");
		car3 = new Texture("poli.png");

	}

	private void spawnCop(){
		//spawn a random cop outside view
	}

	private void spawnArtificial(){

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(car1, 0, 0);
		batch.draw(car2, 100, 0);
		batch.draw(car3, 200, 0);
		batch.end();
	}
}
