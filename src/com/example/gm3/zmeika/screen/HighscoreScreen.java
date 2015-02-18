package com.example.gm3.zmeika.screen;

import java.util.List;

import com.example.gm3.framework.Game;
import com.example.gm3.framework.Graphics;
import com.example.gm3.framework.Input.TouchEvent;
import com.example.gm3.framework.Screen;
import com.example.gm3.zmeika.Assets;
import com.example.gm3.zmeika.Settings;

public class HighscoreScreen extends Screen {
	String lines[] = new String[5];

	public HighscoreScreen(Game game) {
		super(game);
		for (int i = 0; i < 5; i++) {
			lines[i] = "" + (i + 1) + ". " + Settings.highscores[i];
		}
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvent = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();

		int len = touchEvent.size();
		for (int i = 0; i < len; i++) {
			TouchEvent even = touchEvent.get(i);
			if (even.type == TouchEvent.TOUCH_UP) {
				if (even.x < 64 && even.y > 416) {
					if (Settings.soundEnable) {
						Assets.click.play(1);
					}
					game.setScreen(new MainMenuScreen(game));
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.backgraund, 0, 0);
		g.drawPixmap(Assets.mainMenu, 64, 20, 0, 42, 196, 42);

		int y = 100;
		for (int i = 0; i < 5; i++) {
			drawText(g, lines[i], 20, y);
			y += 50;
		}

		g.drawPixmap(Assets.buttons, 0, 416, 64, 64, 64, 64);
	}

	public void drawText(Graphics g, String line, int x, int y) {
		int len = line.length();
		for (int i = 0; i < len; i++) {
			char character = line.charAt(i);
			if (character == ' ') {
				x += 20;
				continue;
			}
			int srcX = 0;
			int srcWidth = 0;
			if (character == '.') {
				srcX = 200;
				srcWidth = 10;
			} else {
				srcX = (character - '0') * 20;
				srcWidth = 20;
			}
			g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
			x += srcWidth;
		}
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
