package com.example.gm3;

import com.example.gm3.framework.Screen;
import com.example.gm3.framework.impl.AndroidGame;
import com.example.gm3.zmeika.screen.LoadingScreen;

public class Zmeaika extends AndroidGame {

	@Override
	public Screen getStartScreen() {
		return new LoadingScreen(this);
	}

	
}
