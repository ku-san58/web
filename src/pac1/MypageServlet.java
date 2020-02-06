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
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
				"jdbc:mysql://10.15.121.37:3306/webapp2019_sgt2?serverTimezone=JST",
				"user_sgt2", "sgt2");
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
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>練習６－１</title>");
		out.println("</head>");
		out.println("<body>");
	
		
		for (String str : list) {
			out.println(str + "<br>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

}
