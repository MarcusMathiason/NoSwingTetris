package com.noswingtetris.model;

import java.awt.Toolkit;

import com.noswingtetris.controller.ObjectHandler;
import com.noswingtetris.view.Window;

public class Game implements Runnable {
	public static final int SCREEN_WIDTH = 400;
	public static final int SCREEN_HEIGHT = 800;

	private Thread thread;

	private Window window;

	private ObjectHandler handler;

	private boolean isRunning = false;

	public Game() {

		handler = new ObjectHandler();

		handler.addObject(new Tetromino());

		window = new Window(SCREEN_WIDTH, SCREEN_HEIGHT, this, handler);

		start();
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			// Set to false for stable 60FPS
			boolean shouldRender = false;
			while (delta >= 1) {
				tick();
				delta--;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				window.render();
				Toolkit.getDefaultToolkit().sync();
				frames++;
			}

			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();

	}

	public void tick() {

		handler.tick();
	}

	public void start() {
		if (isRunning)
			return;
		thread = new Thread(this);
		System.out.println("Starting new thread...");
		thread.start();
		isRunning = true;
	}

	public void stop() {
		if (!isRunning)
			return;
		try {
			System.out.println("Stopping thread...");
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isRunning = false;
	}

	public static void main(String[] args) {
		new Game();
	}

}
