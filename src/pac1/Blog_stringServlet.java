package pac1;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/Blog_stringServlet")
public class Blog_stringServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		String a = "*";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/web?serverTimezone=JST",
				"root", "yassan5800");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT"+ a +"FROM blog");

			while (rs.next()) {
				String s = "<td>" + rs.getString("blog_string") + "</td>";
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

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>練習６－１</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<th>ブログ内容</th>");
		out.println("</tr>");
		for (String str : list) {
			out.println("<tr>" + str + "</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
