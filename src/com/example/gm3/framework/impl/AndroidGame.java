package com.example.gm3.framework.impl;

import com.example.gm3.framework.Audio;
import com.example.gm3.framework.FileIO;
import com.example.gm3.framework.Game;
import com.example.gm3.framework.Graphics;
import com.example.gm3.framework.Input;
import com.example.gm3.framework.Screen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public abstract class AndroidGame extends Activity implements Game {
	AndroidFastRenderView renderView;
	Graphics graphics;
	Audio audio;
	Input input;
	FileIO fileIO;
	Screen screen;
	WakeLock wakeLock;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d("lol", "onCreate");

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		boolean isLandsape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
		int frameBufferWidth = isLandsape ? 480 : 320;
		int frameBufferHeight = isLandsape ? 320 : 480;
		Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
				frameBufferHeight, Config.RGB_565);
		float scaleX = (float) frameBufferWidth
				/ getWindowManager().getDefaultDisplay().getWidth();
		float scaleY = (float) frameBufferHeight
				/ getWindowManager().getDefaultDisplay().getHeight();

		renderView = new AndroidFastRenderView(this, frameBuffer);
		graphics = new AndroidGraphics(getAssets(), frameBuffer);
		fileIO = new AndroidFileIO(getAssets());
		audio = new AndroidAudio(this);
		input = new AndroidInput(this, renderView, scaleX, scaleY);
		screen = getStartScreen();
		setContentView(renderView);

		PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK,
				"GLGame");
	}

	@SuppressLint("Wakelock")
	@Override
	protected void onResume() {
		super.onResume();

		Log.d("lol", "Resum :" + screen.getClass().toString());

		wakeLock.acquire();
		screen.resume();
		renderView.resume();

	}

	@Override
	protected void onPause() {
		super.onPause();

		Log.d("lol", "Pause :" + screen.getClass().toString());

		wakeLock.release();
		renderView.pause();
		screen.pause();
		if (isFinishing()) {
			screen.dispose();
		}

	}

	@Override
	public Input getInput() {
		return input;
	}

	@Override
	public FileIO getFileIO() {
		return fileIO;
	}

	@Override
	public Graphics getGraphics() {
		return graphics;
	}

	@Override
	public Audio getAudio() {
		return audio;
	}

	@Override
	public void setScreen(Screen screen) {
		if (screen == null) {
			Log.d("lol", "Screen mast not be null");
			throw new RuntimeException("Screen mast not be null");
		}
		if (this.screen != null) {
			this.screen.pause();
			this.screen.dispose();
		}
		screen.resume();
		screen.update(0);
		this.screen = screen;
		Log.d("lol", "New screen: " + screen.getClass().toString());
	}

	@Override
	public Screen getCurrentScreen() {
		return screen;
	}

}
