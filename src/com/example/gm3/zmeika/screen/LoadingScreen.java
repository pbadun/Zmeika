package com.example.gm3.zmeika.screen;

import com.example.gm3.framework.Game;
import com.example.gm3.framework.Graphics;
import com.example.gm3.framework.Screen;
import com.example.gm3.framework.Graphics.PixmapFormat;
import com.example.gm3.zmeika.Assets;
import com.example.gm3.zmeika.Settings;

/**
 * Стартовый класс - загружает ресурсы программы. Инициализация базовых
 * настроек.
 * 
 * @author jb
 *
 */
public class LoadingScreen extends Screen {

	public LoadingScreen(Game game) {
		super(game);
		Graphics g = game.getGraphics();
		Assets.backgraund = g.newPixmap("backgraund.png", PixmapFormat.RGB565);
		Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
		Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
		Assets.buttons = g.newPixmap("button.png", PixmapFormat.ARGB4444);
		Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
		Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
		Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
		Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
		Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
		Assets.pause = g.newPixmap("pause.png", PixmapFormat.ARGB4444);
		Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
		Assets.headUp = g.newPixmap("headup.png", PixmapFormat.ARGB4444);
		Assets.headLeft = g.newPixmap("headleft.png", PixmapFormat.ARGB4444);
		Assets.headDown = g.newPixmap("headdown.png", PixmapFormat.ARGB4444);
		Assets.headRight = g.newPixmap("headright.png", PixmapFormat.ARGB4444);
		Assets.tail = g.newPixmap("tail.png", PixmapFormat.ARGB4444);
		Assets.stain1 = g.newPixmap("stain1.png", PixmapFormat.ARGB4444);
		Assets.stain2 = g.newPixmap("stain2.png", PixmapFormat.ARGB4444);
		Assets.stain3 = g.newPixmap("stain3.png", PixmapFormat.ARGB4444);

		Assets.click = game.getAudio().newSound("click.wav");
		Assets.eat = game.getAudio().newSound("eat.wav");
		Assets.bitten = game.getAudio().newSound("bitten.wav");
		Settings.load(game.getFileIO());
	}

	@Override
	public void update(float deltaTime) {
		game.setScreen(new MainMenuScreen(game));

	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub

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
