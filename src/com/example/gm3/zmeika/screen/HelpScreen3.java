package com.example.gm3.zmeika.screen;

import java.util.List;

import com.example.gm3.framework.Game;
import com.example.gm3.framework.Graphics;
import com.example.gm3.framework.Screen;
import com.example.gm3.framework.Input.TouchEvent;
import com.example.gm3.zmeika.Assets;
import com.example.gm3.zmeika.Settings;

public class HelpScreen3 extends Screen {

	public HelpScreen3(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvent = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();

		int len = touchEvent.size();
		for (int i = 0; i < len; i++) {
			TouchEvent even = touchEvent.get(i);
			if (even.type == TouchEvent.TOUCH_UP) {
				if (even.x > 256 && even.y > 416) {
					// /
					game.setScreen(new MainMenuScreen(game));

					if (Settings.soundEnable) {
						Assets.click.play(1);
					}
				}
			}
		}

	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.backgraund, 0, 0);
		g.drawPixmap(Assets.help3, 64, 100);
		g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
