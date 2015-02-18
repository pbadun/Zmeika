package com.example.gm3.framework.impl;

import android.media.SoundPool;

import com.example.gm3.framework.Sound;

/**
 * �������� �� ��������������� �������� ��������
 * 
 * @author jb
 *
 */
public class AndroidSound implements Sound {
	int soundId;
	SoundPool soundSpool;

	public AndroidSound(SoundPool soundSpool, int soundId) {
		this.soundId = soundId;
		this.soundSpool = soundSpool;
	}

	@Override
	public void play(float volume) {
		soundSpool.play(soundId, volume, volume, 0, 0, 1);
	}

	@Override
	public void dispose() {
		soundSpool.unload(soundId);
	}

}
