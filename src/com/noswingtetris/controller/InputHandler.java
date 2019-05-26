package com.noswingtetris.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.noswingtetris.view.Renderer;

public class InputHandler implements KeyListener {

	public Key up = new Key(), down = new Key(), left = new Key(), right = new Key();

	public InputHandler(Renderer r) {
		r.addKeyListener(this);
	}

	public class Key {
		public boolean isPressed = false;

		public boolean getIsPressed() {
			return isPressed;
		}

		public void togglePressed(boolean pressed) {
			isPressed = pressed;
		}
	}

	public void keyPressed(KeyEvent e) {
		togglePressedState(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		togglePressedState(e.getKeyCode(), false);
	}

	public void keyTyped(KeyEvent e) {

	}

	public void togglePressedState(int keycode, boolean pressedState) {
		if (keycode == KeyEvent.VK_UP) {
			up.togglePressed(pressedState);
			System.out.println("Up pressed state: " + pressedState );
		}

		if (keycode == KeyEvent.VK_DOWN) {
			down.togglePressed(pressedState);
			System.out.println("Down pressed state: " + pressedState );
		}

		if (keycode == KeyEvent.VK_LEFT) {
			left.togglePressed(pressedState);
			System.out.println("Left pressed state: " + pressedState );
		}

		if (keycode == KeyEvent.VK_RIGHT) {
			right.togglePressed(pressedState);
			System.out.println("Right pressed state: " + pressedState );
		}
	}

}
