package com.uverwolf.ninjagold;

public class Aleatorio {
	
	public int aleatorio(int max, int min) {
	    int x =(int) (Math.random()*((max-min)+1))+min;
		
		return x;
	}
}
