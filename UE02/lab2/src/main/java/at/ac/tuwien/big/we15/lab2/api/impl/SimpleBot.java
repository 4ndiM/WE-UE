package at.ac.tuwien.big.we15.lab2.api.impl;

import java.util.Arrays;
import java.util.List;

import at.ac.tuwien.big.we15.lab2.api.Answer;
import at.ac.tuwien.big.we15.lab2.api.Bot;
import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.Question;

public class SimpleBot extends SimpleUser implements Bot {
	
	private Question currentQuestion = null;

	public SimpleBot(){
		setUsername("Deadbot");
	}
	
	public String[] chAnswer(List<Category> categories){
		String[] a;
		
		List<Answer> lst = chQuestion(categories).getAllAnswers();
		int n, max = getRandom(lst.size());
		a = new String[max];
		
		for(int i=0;i<max;i++){
			n = getRandom(max);
			if(distinct(a, lst.get(n))){
				a[i] = String.format("%d",lst.get(n).getId());
			}
		}
		return a;
	}

	private boolean distinct(String[] a, Answer answer) {
		String str = String.format("%d",answer.getId());
		return !(Arrays.asList(a).contains(str));
	}

	/**
	 * 
	 * @param categories
	 * 			list of categories from which the bot chooses one category and a question from that category
	 * @return
	 * 			the chosen question
	 */
	public Question chQuestion(List<Category> categories){
		int cnt = 0;
		Category c = null;
		List<Question> lst = null;
		Question q = null;
		
		while(true){
			cnt++;
			c = chCategory(categories);
			lst = c.getQuestions();
			
			q = lst.get(getRandom(lst.size()));
			if(!q.getUsed()){
				return q;
			}
			if(cnt > categories.size()*lst.size()){
				return null;
			}
		}
	}

	private Category chCategory(List<Category> categories) {
		int elem = getRandom(categories.size());
		return categories.get(elem);
	}

	private int getRandom(int size) {
		return (int) Math.floor(Math.random()*size);
	}
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
}
