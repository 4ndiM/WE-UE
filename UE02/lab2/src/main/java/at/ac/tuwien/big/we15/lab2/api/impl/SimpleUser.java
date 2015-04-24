package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.User;

public class SimpleUser implements User {
	
	private String username;
	private int sum = 0;
	private int lastProfit = 0;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum += sum;
		this.lastProfit = sum;
	}
	public int getLastProfit() {
		return lastProfit;
	}
	
}
