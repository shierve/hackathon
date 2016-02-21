package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
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
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Iterator;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	private static final int copvel = 200;
	private static final int COMP = 2000000000;

	private OrthographicCamera cam;
	Vector3 tp = new Vector3();

	private float w, h;

	SpriteBatch batch;
	Texture background;
	Texture car, cop;
	Array<Cop> cops = new Array<Cop>();

	private boolean move = true;
	private long lastCop = 0;
	private int score = 0;

	private Player player;

	@Override
	public void create () {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		player = new Player(w);

		cam = new OrthographicCamera(1000, 1000 * (h / w));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		batch = new SpriteBatch();
		background = new Texture("elenadef.png");
		car = new Texture("cotxeblaudonut.png");
		cop = new Texture("poli.png");

		// ShapeRenderer so we can see our touch point
		Gdx.input.setInputProcessor(this);

	}

	private void spawnCop(){
		Cop cop = new Cop(MathUtils.random(0, 2), (int)cam.viewportHeight);
		cops.add(cop);
		lastCop = TimeUtils.nanoTime();
	}

	private void gameOver(){
		//stops tubes and bird
		move = false;
		//Opens preferences and reads Highscore
		if (score < 0)
			score = 0;
		Preferences prefs = Gdx.app.getPreferences("FlappyPreferences");
		int highscore = prefs.getInteger("highscore", 0);
		if (score > highscore) {
			highscore = score;
			prefs.putInteger("highscore", score);
			prefs.flush();
		}

	}

	@Override
	public void render (){

		cam.update();
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0, w*1.4f, h*1.4f);
		if(player.posicio == 0) batch.draw(car, (cam.viewportWidth / 6f)-50, 30);
		if(player.posicio == 1) batch.draw(car, (cam.viewportWidth / 2f)-50, 30);
		if(player.posicio == 2) batch.draw(car, (cam.viewportWidth*5 / 6f)-50, 30);

		for (Cop copi : cops){
			batch.draw(cop, copi.getPosicio(), copi.y);
		}

		batch.end();

		if(TimeUtils.nanoTime() - lastCop > COMP && move) {
			spawnCop();
			score++;
		}


		Iterator<Cop> iter = cops.iterator();
		while (iter.hasNext() && move) {
			Cop cop = iter.next();
			cop.y -= copvel * Gdx.graphics.getDeltaTime();
			if (cop.y + 260 < 0)
				iter.remove();
			if (cop.r.overlaps(player.r)){
				gameOver();
			}
			cop.r.setPosition(cop.getPosicio(), cop.y);
		}
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
		player.setPosicio(player.posicio);

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
