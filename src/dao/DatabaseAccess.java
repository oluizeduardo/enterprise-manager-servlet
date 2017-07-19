package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/busca")
public class DatabaseAccess extends HttpServlet {

	
	//-- Conexão com o Postgres
	private String address = "127.0.0.1";
	private String port = "5432";
	private String nameDataBase = "EnterpriseManager";
    private String url = "jdbc:postgresql://"+address+":"+port+"/"+nameDataBase;  
    private String username = "postgres";  
    private String password = "postgres";  
    private String driver = "org.postgresql.Driver";
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String title = "Empresas Cadastradas";		
			      
	    out.println("<!DOCTYPE html>" +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n" +
	         "<h1 align = \"center\">" + title + "</h1>\n");
	    
	    try {
			Class.forName(this.driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			//Executing SQL query.
			Statement stm = conn.createStatement();
			String sql = "SELECT * FROM company";
			
			ResultSet rs = stm.executeQuery(sql);
			
			out.println("<ul>");
			
			// Extracting data from ResultSet object.
			while(rs.next()){
				
				// Retriving by column name.
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				out.println("<li>");
				// Display the values.
				out.println("ID: "+id);
				out.println(" NAME: "+name);
				out.println(" EMAIL: "+email);	
				
				out.println("</li>");
			}
			out.println("</ul>");
			out.println("</body></html>");
			
			// Close the opened objects. Clean-up environment.
	        rs.close();
	        stm.close();
	        conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

}
