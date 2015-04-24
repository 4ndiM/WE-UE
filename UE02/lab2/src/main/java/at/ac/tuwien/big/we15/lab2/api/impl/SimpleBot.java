package at.ac.tuwien.big.we15.lab2.api.impl;

import java.util.List;
import java.util.Random;

import at.ac.tuwien.big.we15.lab2.api.Bot;
import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.Question;

public class SimpleBot extends User implements Bot {
	
	private Random rnd;
	
	public SimpleBot(){
		setUsername("Deadbot");
		rnd = new Random();
	}

	/* (non-Javadoc)
	 * @see at.ac.tuwien.big.we15.lab2.api.impl.BotInterface#chQuestion(java.util.List)
	 */
	@Override
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
		rnd.setSeed(System.currentTimeMillis());
		return rnd.nextInt()%size;
	}
}
