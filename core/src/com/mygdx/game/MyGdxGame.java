package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Iterator;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	private static final int copvel = 200;
	private static final int COMP = 2000000000;

	private OrthographicCamera cam;
	Vector3 tp = new Vector3();
	boolean dragging;


	SpriteBatch batch;
	Texture background;
	Texture car, cop;
	Array<Cop> cops = new Array<Cop>();

	private Player player = new Player();
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		cam = new OrthographicCamera(1000, 1000 * (h / w));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		batch = new SpriteBatch();
		//background = new Texture("carretera.png");
		car = new Texture("cotxeblaudonut.png");
		cop = new Texture("poli.png");

		// ShapeRenderer so we can see our touch point
		Gdx.input.setInputProcessor(this);

	}

	private void spawnCop(){

	}

	private void gameOver(){

	}

	@Override
	public void render (){

		cam.update();
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(background, 0, 0);
		if(player.posicio == 0) batch.draw(car, (cam.viewportWidth / 6f)-50, 30);
		if(player.posicio == 1) batch.draw(car, (cam.viewportWidth / 2f)-50, 30);
		if(player.posicio == 2) batch.draw(car, (cam.viewportWidth*5 / 6f)-50, 30);


		Iterator<Cop> iter = cops.iterator();
		while (iter.hasNext()) {
			Cop cop = iter.next();
			cop.y -= copvel * Gdx.graphics.getDeltaTime();
			if (cop.y + 260 < 0)
				iter.remove();
			if (cop.r.overlaps(player.r)){
				gameOver();
			}
		}
		batch.end();
	}

	@Override
	public void dispose() {

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
		cam.unproject(tp.set(screenX, screenY, 0));
		if(tp.x < cam.viewportWidth / 2f) player.posicio--;
		else player.posicio++;
		if(player.posicio < 0) player.posicio = 0;
		if(player.posicio > 2) player.posicio = 2;
		return true;
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
