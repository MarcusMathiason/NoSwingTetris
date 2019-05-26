package com.noswingtetris.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.noswingtetris.controller.InputHandler;
import com.noswingtetris.controller.ObjectHandler;

public class Renderer extends Canvas {
	private static final long serialVersionUID = 1L;

	private int width, height;
	
	public InputHandler input;

	public Renderer(int width, int height) {
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		input = new InputHandler(this);
	}

	public void render(ObjectHandler handler) {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);

		g.fillRect(0, 0, width, height);

		g.setColor(Color.red);

//		// Left section center
//		g.fillRect(width / 4, 0, 1, height);
//
//		// Absolute center
//		g.fillRect(width / 2, 0, 1, height);
//
//		// Right section center
//		g.fillRect((width / 2) + (width / 4), 0, 1, height);

		for (int i = 1; i <= 10; i++) {
			g.fillRect(40 * i, 0, 1, height);
		}

		for (int i = 1; i <= 20; i++) {
			g.fillRect(0, 40 * i, width, 1);
		}
		handler.render(g);

		g.dispose();

		bs.show();
	}

}
