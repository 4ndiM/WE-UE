package at.ac.tuwien.big.we15.lab2.api.impl;

public class Round {

	private int maxRound = 5;
	private int round = 1;
	
	
	public int getMaxRound() {
		return maxRound;
	}
	public void setMaxRound(int maxRound) {
		this.maxRound = maxRound;
	}
	public int getRound() {
		return round;
	}
	public boolean setRound() {
		if(this.round >= this.maxRound){
			return false;
		}
		this.round++;
		return true;
	}
	
	
}
