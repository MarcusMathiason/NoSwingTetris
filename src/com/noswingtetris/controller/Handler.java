package com.noswingtetris.controller;

import java.awt.Graphics;
import java.util.LinkedList;

import com.noswingtetris.model.Tetromino;

public class Handler {
	
	LinkedList<Tetromino> objects = new LinkedList<Tetromino>();
	
	public void tick() {
		//System.out.println("Handler tick...");
		for(Tetromino obj : objects) {
			obj.tick();
		}
		
	}
	
	public void render(Graphics g) {
		//System.out.println("Handler render...");
		for(Tetromino obj : objects) {
			obj.render(g);
		}
	}
	
	public boolean addObject(Tetromino obj){
		//System.out.println("Handler add obj...");
		return objects.add(obj);
	}
	
	public boolean removeObject(Tetromino obj){
		return objects.remove(obj);
	}

}
