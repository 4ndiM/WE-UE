package at.ac.tuwien.big.we15.lab2.api;

import java.util.List;
import at.ac.tuwien.big.we15.lab2.api.User;
import at.ac.tuwien.big.we15.lab2.api.Category;

public interface Bot extends User {

	/**
	 * 
	 * @param categories
	 * 				List of categories, from which a question an the corresponding answers are chosen
	 * @return
	 * 				an array of ids of the answers given
	 */
	public String[] chAnswer(List<Category> categories);
	/**
	 * 
	 * @param categories
	 * 			list of categories from which the bot chooses one category and a question from that category
	 * @return
	 * 			the chosen question
	 */
	public Question chQuestion(List<Category> categories);

	public Category getCategory();
	
	public Question getQuestion();

}