package pac1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectSampleServlet1
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/web?serverTimezone=JST",
				"root", "yassan5800");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM blog");

			while (rs.next()) {
				String s = rs.getString("day")+ ":" + rs.getString("title");
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {
				}
			}
		}


		MypageBean1 myBean = new MypageBean1();
		myBean.setValue(list);

		request.setAttribute("myBean",myBean);
		getServletContext().getRequestDispatcher("/Mypage.jsp").forward(request,response);
		request.setAttribute("DiaryList", list);

	}
	
}
