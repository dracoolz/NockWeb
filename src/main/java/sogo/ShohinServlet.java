package sogo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShohinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/web/kakunin.jsp");
		rd.forward(request, response);

		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");

		HttpSession session = request.getSession(true);
		
		if (request.getParameter("submit").equals("確認")) {
			
			String id = (String) session.getAttribute("id");
			String name = (String) session.getAttribute("name");
			int kakaku = (Integer) session.getAttribute("kakaku");

			ShohinDAO dao = new ShohinDAO();
			// Daoの登録メソッドを使用し、DBへ登録する
			dao.insert(id, name, kakaku);
			
			request.setAttribute("registrationComplete", true);
			
			RequestDispatcher rd = request.getRequestDispatcher("/web/mod.jsp");
			rd.forward(request, response);
		
		} else if (request.getParameter("submit").equals("削除")) {
			
			String id = (String) session.getAttribute("id");
			
			ShohinDAO dao = new ShohinDAO();
			// Daoの登録メソッドを使用し、DBへ登録する
			dao.delete(id);
			
			request.setAttribute("complete", true);
			request.setAttribute("result", "削除が完了しました");

			RequestDispatcher rd = request.getRequestDispatcher("/list?no=2");
			rd.forward(request, response);
		
		} else if (request.getParameter("submit").equals("変更")) {
			
			String id = (String) session.getAttribute("id");
			String name = (String) session.getAttribute("name");
			int kakaku = (Integer) session.getAttribute("kakaku");
			
			ShohinDAO dao = new ShohinDAO();
			// Daoの登録メソッドを使用し、DBへ登録する
			dao.update(id, name, kakaku, id);
			
			request.setAttribute("complete", true);
			request.setAttribute("result", "変更が完了しました");

			RequestDispatcher rd = request.getRequestDispatcher("/list?no=2");
			rd.forward(request, response);
		}


	}

}
