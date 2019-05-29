package com.noswingtetris.controller;

import java.awt.Graphics;
import java.util.LinkedList;

import com.noswingtetris.model.Tetromino;

public class ObjectHandler {

	LinkedList<Tetromino> objects = new LinkedList<Tetromino>();
	int[] x = new int[2];

	private int tickCounter = 0;

	public void tick() {

		if ((tickCounter % 10) == 0) {
			// System.out.println("Handler tick...");
			for (Tetromino obj : objects) {
				obj.tick();
			}
		}

		tickCounter++;

	}

	public void render(Graphics g) {
		// System.out.println("Handler render...");
		for (Tetromino obj : objects) {
			obj.render(g);
		}
	}

	public boolean addObject(Tetromino obj) {
		// System.out.println("Handler add obj...");
		return objects.add(obj);
	}

	public boolean removeObject(Tetromino obj) {
		return objects.remove(obj);
	}

}
