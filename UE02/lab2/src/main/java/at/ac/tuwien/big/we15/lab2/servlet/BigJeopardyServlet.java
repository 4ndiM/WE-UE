package at.ac.tuwien.big.we15.lab2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.Question;
import at.ac.tuwien.big.we15.lab2.api.QuestionDataProvider;
import at.ac.tuwien.big.we15.lab2.api.impl.Round;
import at.ac.tuwien.big.we15.lab2.api.impl.ServletJeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.impl.User;

/**
 * Servlet implementation class BigJeopardyServlet
 */
public class BigJeopardyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<Category> categories = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init() {
		ServletContext servletContext = getServletContext();
		JeopardyFactory factory = new ServletJeopardyFactory(servletContext);
		QuestionDataProvider provider = factory.createQuestionDataProvider();
		categories = provider.getCategoryData();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("answer_submit") != null){
			boolean right = false;
			Question q = null;
			Round rnd = null;
			String jsp = "/jeopardy.jsp";
			
			String[] answers = request.getParameterValues("answers");
			HttpSession session = request.getSession(true);
			
			q = (Question) session.getAttribute("question");
			if(q.trueAnswer(answers)){
				((User) session.getAttribute("user1")).setSum(q.getValue());
			
			}
			
			rnd = (Round) session.getAttribute("round");
			if(!rnd.setRound()){
				User user1 = (User) session.getAttribute("user1");
				User user2 = (User) session.getAttribute("user2");
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
			User user[] = {new User(), new User()};
			if(request.getParameter("login") != null) {
				user[0].setUsername(request.getParameter("username"));
			}
			else if(request.getParameter("restart") != null) {
				user[0].setUsername(((User) session.getAttribute("user1")).getUsername());
			}
			
			user[0].setImage("img/avatar/black-widow.png");
			user[0].setImageHead("img/avatar/black-widow_head.png");
			user[1].setUsername("Deadpool");
			user[1].setImage("img/avatar/deadpool.png");
			user[1].setImageHead("img/avatar/deadpool_head.png");
			if(request.getParameter("restart") != null) {
				Enumeration<String> attributes = session.getAttributeNames();
				while(attributes.hasMoreElements()) {
					session.removeAttribute(attributes.nextElement());
				}
				session = request.getSession(true);
			}
			for(int i=1;i<=2;i++){
				session.setAttribute("user"+i, user[i-1]);
			}

			
			session.setAttribute("round", new Round());
			session.setAttribute("categories", categories);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jeopardy.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("question_submit") != null) {
			HttpSession session = request.getSession(true);
			int id = Integer.parseInt(request.getParameter("question_selection"));
			
			Question question = null;
			for(Category c : categories) {
				for(Question q : c.getQuestions()) {
					if(q.getId() == id) {
						question = q;
					}
				}
			}
			
			session.setAttribute("question", question);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
