package at.ac.tuwien.big.we15.lab2.api;

import java.util.List;

public interface Bot {
	
	/**
	 * 
	 * @param categories
	 * 				List of categories, from which a question an the corresponding answers are chosen
	 * @return
	 * 				an array of ids of the answers given
	 */
	public String[] chAnswer(List<Category> categories);

}