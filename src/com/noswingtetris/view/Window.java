package com.noswingtetris.view;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.noswingtetris.model.Game;

public class Window extends Frame{
	
	private static final long serialVersionUID = 1L;
	
	private Renderer renderer;

	public Window(int width, int height, Game game) {
		super();
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		renderer = new Renderer(width, height);
		this.add(renderer);
		this.pack();
	}
	
	public void render() {
		renderer.render();
	}
}
