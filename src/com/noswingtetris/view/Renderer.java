package com.noswingtetris.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Renderer extends Canvas{
	private static final long serialVersionUID = 1L;
	
		public Renderer(int width, int height) {
			this.setSize(width, height);
		}
		
		public void render() {
			BufferStrategy bs = this.getBufferStrategy();
			if(bs == null) {
				this.createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			
			g.setColor(Color.black);
			
			g.fillRect(100, 100, 100, 100);
			
			g.dispose();
			
			bs.show();
		}

}
