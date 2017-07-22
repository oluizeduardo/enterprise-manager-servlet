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
	 * @return status
	 */
	public boolean insert(Company newCompany){
		
		boolean status = false;
		try {

			String sql = "INSERT INTO "+TABLE_NAME+" VALUES (?, ?, ?)";
			
			this.conn = super.getConnection();
			this.pstm = conn.prepareStatement(sql);
			pstm.setInt(1, newCompany.getId());
			pstm.setString(2, newCompany.getName());
			pstm.setString(3, newCompany.getEmail());
			
			status = pstm.execute();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
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
	
	
	/**
	 * Delete a company from the database.
	 * @param comp An object Company that will be deleted.
	 */
	public void delete(Company comp){
		try {
			
			this.conn = super.getConnection();
			this.pstm = conn.prepareStatement("DELETE * FROM "+TABLE_NAME+" WHERE id = "+comp.getId());
			this.pstm.execute();
			
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Look for a Company by its ID number.
	 * @param id
	 * @return An object {@link Company}.
	 */
	public Company searchByID(int id){
		Company comp = null;
		try {
			
			this.conn = super.getConnection();
			this.pstm = conn.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE id = "+comp.getId());
			this.rs = pstm.executeQuery();
			
			if(rs.next()){
				comp = new Company();
				comp.setId(rs.getInt("id"));
				comp.setName(rs.getString("name"));
				comp.setEmail(rs.getString("email"));
			}
			
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comp;
	}
	
	
	
}
