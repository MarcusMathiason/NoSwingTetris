package com.noswingtetris.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.noswingtetris.controller.Handler;

public class Renderer extends Canvas {
	private static final long serialVersionUID = 1L;

	private int width, height;

	public Renderer(int width, int height) {
		this.width = width;
		this.height = height;
		this.setSize(width, height);
	}

	public void render(Handler handler) {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);

		g.fillRect(0, 0, width, height);

		handler.render(g);

		g.dispose();

		bs.show();
	}

}
