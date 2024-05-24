package sogo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String no = req.getParameter("no");

		if (no != null && no.equals("1")) {
			// DAOをインスタンス化する
			ShohinDAO dao = new ShohinDAO();
			// リクエストにDAOで取得したユーザ情報をセットする
			req.setAttribute("list", dao.selectAll());

			RequestDispatcher rd = req.getRequestDispatcher("/web/ichiran.jsp?no=1");
			rd.forward(req, res);
			
		} else if (no != null && no.equals("2")) {
			// DAOをインスタンス化する
			ShohinDAO dao = new ShohinDAO();
			// リクエストにDAOで取得したユーザ情報をセットする
			req.setAttribute("list", dao.selectAll());

			RequestDispatcher rd = req.getRequestDispatcher("/web/ichiran.jsp?no=2");
			rd.forward(req, res);
		}
	}

}
