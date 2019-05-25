package com.noswingtetris.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Window;
import java.util.Random;

public class Tetromino {
	private final int SIZE = 40;
	private int x, y;
	private int yVel = 40;
	private boolean yInc = true;
	
	private String[] shapes = {
			"I",
			"O",
			"T",
			"J",
			"L",
			"S",
			"Z"
	};
	
	private Color[] colors = {
			Color.CYAN,
			Color.YELLOW,
			Color.MAGENTA,
			Color.BLUE,
			//Orange
			new Color(255, 69, 0),
			Color.GREEN,
			Color.RED
	};
	
	private String shape;
	private Color color;
	private Random rand;
	
	public Tetromino() {
		rand = new Random();
		shape = shapes[rand.nextInt(shapes.length)];
		setColor();
		System.out.println("Shape: " + shape);
		System.out.println("Color: " + color);
	}
	
	public void setColor() {
		switch(shape) {
		case "I":
			color = colors[0];
			break;
		case "O":
			color = colors[1];
			break;
		
		case "T":
			color = colors[2];
			break;
		
		case "J":
			color = colors[3];
			break;
		
		case "L":
			color = colors[4];
			break;
		
		case "S":
			color = colors[5];
			break;
		
		case "Z":
			color = colors[6];
			break;
		
		}
	}
	
	public void render(Graphics g) {
		//System.out.println("Tetromino render...");
		g.setColor(color);
		g.fillRect(x, y, SIZE, SIZE);
	}
	
	public void tick() {
		if(yInc) {
			this.y += yVel;
			if((this.y+SIZE+1)>Game.SCREEN_HEIGHT) {
				yInc = false;
			}
		} else {
			this.y -= yVel;
			if((this.y-1)<0) {
				yInc = true;
			}
		}
	}
}
