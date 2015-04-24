package at.ac.tuwien.big.we15.lab2.api.impl;

import java.util.List;

import javax.servlet.ServletContext;

import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.CategoryList;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.Question;
import at.ac.tuwien.big.we15.lab2.api.QuestionDataProvider;

public class SimpleCategoryList implements CategoryList {

	List<Category> categories;
	
	public SimpleCategoryList(ServletContext servletContext) {
		JeopardyFactory factory = new ServletJeopardyFactory(servletContext);
		QuestionDataProvider provider = factory.createQuestionDataProvider();
		categories = provider.getCategoryData();
	}
	
	public Question getQuestion(int id) {
		for(Category c : categories) {
			for(Question q : c.getQuestions()) {
				if(q.getId() == id) {
					return q;
				}
			}
		}
		return null;
	}
	
	public int getNumberOfCategories() {
		return categories.size();
	}
	
	public String getCategoryName(int index) {
		return categories.get(index).getName();
	}
	
	public int getNumberOfQuestions(int index) {
		return categories.get(index).getQuestions().size();
	}

	public String getQuestionName(int categoryIndex, int index) {
		return categories.get(categoryIndex).getQuestions().get(index).getText();
	}
	
	public int getQuestionId(int categoryIndex, int index) {
		return categories.get(categoryIndex).getQuestions().get(index).getId();
	}
	
	public int getQuestionValue(int categoryIndex, int index) {
		return categories.get(categoryIndex).getQuestions().get(index).getValue();
	}
	
	public boolean getQuestionUsed(int categoryIndex, int index) {
		return categories.get(categoryIndex).getQuestions().get(index).getUsed();
	}
}
