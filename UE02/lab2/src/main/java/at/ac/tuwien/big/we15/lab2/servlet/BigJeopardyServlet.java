package at.ac.tuwien.big.we15.lab2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.ac.tuwien.big.we15.lab2.api.Bot;
import at.ac.tuwien.big.we15.lab2.api.CategoryList;
import at.ac.tuwien.big.we15.lab2.api.Question;
import at.ac.tuwien.big.we15.lab2.api.User;
import at.ac.tuwien.big.we15.lab2.api.impl.Round;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleBot;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleCategoryList;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleUser;


/**
 * Servlet implementation class BigJeopardyServlet
 */
public class BigJeopardyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("answer_submit") != null){
			Question q = null;
			Round rnd = null;
			String jsp = "/jeopardy.jsp";
			
			String[] answers = request.getParameterValues("answers");
			HttpSession session = request.getSession(true);
			
			User user = (User) session.getAttribute("user");
			q = (Question) session.getAttribute("question");
			if(q.trueAnswer(answers)){
				user.setSum(q.getValue());
			} else {
				user.setSum(-(q.getValue() / 2));
			}
			
			CategoryList categories = (CategoryList) session.getAttribute("categories");
			
			Bot bot = (Bot) session.getAttribute("bot");
			Question botQ = bot.chQuestion(categories.getCategories());
			botQ.setUsed(true);
			if(Math.floor((Math.random()*100)) > 50) {
				bot.setSum(botQ.getValue());
			} else {
				bot.setSum(-(botQ.getValue() / 2));
			}
			
			rnd = (Round) session.getAttribute("round");
			if(!rnd.setRound()){
				User user1 = (User) session.getAttribute("user");
				User user2 = (User) session.getAttribute("bot");
				session.setAttribute("winner", user1.getSum() > user2.getSum() ? user1 : user2);
				session.setAttribute("loser", user1.getSum() <= user2.getSum() ? user1 : user2);
				jsp= "/winner.jsp";
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if((request.getParameter("login") != null) || (request.getParameter("restart") != null)) {
			HttpSession session = request.getSession(true);

//			User user[] = {new User(), new SimpleBot()};
//			if(request.getParameter("login") != null) {
//				user[0].setUsername(request.getParameter("username"));
//			}
//			else if(request.getParameter("restart") != null) {
//				user[0].setUsername(((User) session.getAttribute("user1")).getUsername());
//			}
//			
//			user[0].setImage("img/avatar/black-widow.png");
//			user[0].setImageHead("img/avatar/black-widow_head.png");
//			user[1].setUsername("Deadpool");
//			user[1].setImage("img/avatar/deadpool.png");
//			user[1].setImageHead("img/avatar/deadpool_head.png");
//			if(request.getParameter("restart") != null) {
//				Enumeration<String> attributes = session.getAttributeNames();
//				while(attributes.hasMoreElements()) {
//					session.removeAttribute(attributes.nextElement());
//				}
//				session = request.getSession(true);
//			}
//			for(int i=1;i<=2;i++){
//				session.setAttribute("user"+i, user[i-1]);
//			}

			User user = new SimpleUser();
			user.setUsername(request.getParameter("username"));
			user.setImage("img/avatar/black-widow.png");
			user.setImageHead("img/avatar/black-widow_head.png");
			session.setAttribute("user", user);
			
			Bot bot = new SimpleBot();
			bot.setImage("img/avatar/deadpool.png");
			bot.setImageHead("img/avatar/deadpool_head.png");
			session.setAttribute("bot", bot);

			session.setAttribute("round", new Round());
			
			session.setAttribute("categories", new SimpleCategoryList(getServletContext()));
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jeopardy.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("question_submit") != null) {
			HttpSession session = request.getSession(true);
			int id = Integer.parseInt(request.getParameter("question_selection"));
			
			SimpleCategoryList categories = (SimpleCategoryList) session.getAttribute("categories");
			Question question = categories.getQuestion(id);

			question.setUsed(true);
			session.setAttribute("question", question);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
