package sogo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DUControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");

		HttpSession session = request.getSession(true);

		// Check if the "submit" parameter is not null
		String submitParameter = request.getParameter("submit");

		if (submitParameter != null && submitParameter.equals("削除")) {

			ShohinDAO dao = new ShohinDAO();
			ShohinBean bean = new ShohinBean();
			// リクエストからユーザIDを取得する
			String id = request.getParameter("idValue");
			
			//error
			if (id == null) {
				
				
				request.setAttribute("result", "失敗");

				RequestDispatcher rd = request.getRequestDispatcher("/web/ichiran.jsp?no=2");
				rd.forward(request, response);
			
			//success
			} else {
				
				//id, name, kakakuを取得
				bean = dao.jouken(id);
				String name = bean.getName();
				int kakaku = bean.getKakaku();

				// セッションへユーザ情報をセットする
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("kakaku", kakaku);
				RequestDispatcher rd = request.getRequestDispatcher("/web/kakunin.jsp?no=2");
				rd.forward(request, response);
			}
			
		} else if (submitParameter != null && submitParameter.equals("変更")) {

			ShohinDAO dao = new ShohinDAO();
			ShohinBean bean = new ShohinBean();
			// リクエストからユーザIDを取得する
			String id = request.getParameter("idValue");

			//id, name, kakakuを取得
			bean = dao.jouken(id);
			String name = bean.getName();
			int kakaku = bean.getKakaku();

			// セッションへユーザ情報をセットする
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("kakaku", kakaku);

			RequestDispatcher rd = request.getRequestDispatcher("/web/mod.jsp?no=1");
			rd.forward(request, response);

		}

	}


}
