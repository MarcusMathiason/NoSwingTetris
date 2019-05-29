package com.noswingtetris.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Window;
import java.util.Random;

public class Tetromino {
	private final int SIZE = 40;
	private int x = (Game.SCREEN_WIDTH/2), y;
	private int yVel = 40;
	private int xVel = 40;
	
	private boolean yInc = true;
	private boolean xInc = true;
	
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
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
		
		//Center square
		g.fillRect(x, y, SIZE, SIZE);
		
		switch(shape) {
		case "I":
			g.fillRect(x-(SIZE*2), y, SIZE, SIZE);
			g.fillRect(x-(SIZE), y, SIZE, SIZE);
			g.fillRect(x+(SIZE*2), y, SIZE, SIZE);
			g.fillRect(x+(SIZE), y, SIZE, SIZE);
			break;
		case "O":
			g.fillRect(x, y+(SIZE), SIZE, SIZE);
			g.fillRect(x+(SIZE), y, SIZE, SIZE);
			g.fillRect(x+(SIZE), y+(SIZE), SIZE, SIZE);
			break;
		
		case "T":
			g.fillRect(x-(SIZE), y, SIZE, SIZE);
			g.fillRect(x+(SIZE), y, SIZE, SIZE);
			g.fillRect(x, y+(SIZE), SIZE, SIZE);
			break;
		
		case "J":
			g.fillRect(x+(SIZE), y, SIZE, SIZE);
			g.fillRect(x+(SIZE*2), y, SIZE, SIZE);
			g.fillRect(x+(SIZE*2), y+SIZE, SIZE, SIZE);
			break;
		
		case "L":
			g.fillRect(x, y+(SIZE), SIZE, SIZE);
			g.fillRect(x+(SIZE), y, SIZE, SIZE);
			g.fillRect(x+(SIZE*2), y, SIZE, SIZE);
			break;
		
		case "S":
			g.fillRect(x+(SIZE), y, SIZE, SIZE);
			g.fillRect(x, y+(SIZE), SIZE, SIZE);
			g.fillRect(x-(SIZE), y+(SIZE), SIZE, SIZE);
			break;
		
		case "Z":
			g.fillRect(x+(SIZE), y, SIZE, SIZE);
			g.fillRect(x+(SIZE), y+(SIZE), SIZE, SIZE);
			g.fillRect(x+(SIZE*2), y+(SIZE), SIZE, SIZE);
			break;
		
		}
		
		
	}
	
	public void stop() {
		xVel = 0;
		yVel = 0;
	}
	
	public void tick() {
		
		if(yInc) {
			this.y += yVel;
			if((this.y+SIZE+1)>Game.SCREEN_HEIGHT) {
				yInc = false;
			}
		} else {
			stop();
		}
		
		if(xInc) {
			this.x += xVel;
			if((this.x+SIZE+1)>Game.SCREEN_WIDTH) {
				xInc = false;
			}
		} else {
			this.x -= xVel;
			if((this.x-1)<0) {
				xInc = true;
			}
		}
	}
}
