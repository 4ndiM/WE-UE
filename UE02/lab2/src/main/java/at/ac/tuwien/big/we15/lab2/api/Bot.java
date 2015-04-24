package at.ac.tuwien.big.we15.lab2.api;

import java.util.List;

public interface Bot {

	/**
	 * 
	 * @param categories
	 * 			list of categories from which the bot chooses one category and a question from that category
	 * @return
	 * 			the chosen question
	 */
	public Question chQuestion(List<Category> categories);

}