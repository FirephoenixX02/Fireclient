package me.firephoenix.fireclient.event.impl;

import me.firephoenix.fireclient.event.Event;

public class KeyEvent extends Event{

	private final int key;
	
	public KeyEvent(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
}
