package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Company;

public class CompanyDAO extends DatabaseConnection {

	/**The table name in database.*/
	private static final String TABLE_NAME = "companies";
	
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	
	/**
	 * Insert into database a new Company object.
	 * @param newCompany
	 */
	public void insert(Company newCompany){
		try {

			String sql = "INSERT INTO "+TABLE_NAME+" VALUES (?, ?, ?)";
			
			this.conn = super.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, newCompany.getId());
			pstm.setString(2, newCompany.getName());
			pstm.setString(3, newCompany.getEmail());
			
			pstm.execute();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Search into database for all the Companies registered.
	 * @return A List of object {@link Company}
	 */
	public List<Company> list(){
		List<Company> listCompanies = new ArrayList<Company>();
		
		try {
			
			this.conn = super.getConnection();
			this.pstm = conn.prepareStatement("SELECT * FROM "+TABLE_NAME);
			this.rs = pstm.executeQuery();
			
			while(rs.next()){
				Company company = new Company();
				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setEmail(rs.getString("email"));
				
				listCompanies.add(company);
			}
			
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCompanies;		
	}
	
	
	
	
	
	
	
	
	
}
