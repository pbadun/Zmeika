package com.example.gm3.zmeika;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.util.Log;

import com.example.gm3.framework.FileIO;

public class Settings {
	public static boolean soundEnable = true;
	public static int[] highscores = new int[] { 0, 0, 0, 0, 0 };

	public static void load(FileIO file) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					file.readFile("mr.nom")));
			soundEnable = Boolean.parseBoolean(in.readLine());
			for (int i = 0; i < 5; i++) {
				highscores[i] = Integer.parseInt(in.readLine());
			}
		} catch (IOException e) {
			Log.d("lol", "Read Error");
		} catch (NumberFormatException e) {
			Log.d("lol", "Parser Error");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e2) {
			}
		}
	}

	public static void save(FileIO file) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					file.writeFile("mr.nom")));
			out.write(Boolean.toString(soundEnable) + "\n");
			for (int i = 0; i < 5; i++) {
				out.write(Integer.toString(highscores[i]) + "\n");
			}
		} catch (IOException e) {
			Log.d("lol", "Write Error");
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static void addScore(int score) {
		for (int i = 0; i < 5; i++) {
			if (highscores[i] < score) {
				for (int j = 4; j > i; j--) {
					highscores[j] = highscores[j - 1];
				}
				highscores[i] = score;
				break;
			}
		}
	}
}
