package at.ac.tuwien.big.we15.lab2.api.impl;

public class User {
	
	private String username;
	private int sum = 0;
	private boolean winner = false;
	private String image = null;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImageHead() {
		return image_head;
	}
	public void setImageHead(String image_head) {
		this.image_head = image_head;
	}
	private String image_head = null;
	
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
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
	}
	
}
