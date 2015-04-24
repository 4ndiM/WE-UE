package at.ac.tuwien.big.we15.lab2.api;

public interface CategoryList {
	
	public int getNumberOfCategories();

	public String getCategoryName(int index);

	public int getNumberOfQuestions(int index);

	public String getQuestionName(int categoryIndex, int index);
	
	public int getQuestionId(int categoryIndex, int index);
	
	public int getQuestionValue(int categoryIndex, int index);
	
	public boolean getQuestionUsed(int categoryIndex, int index);
}
