package dao;

import pojo.User;



public class UserDAO extends DatabaseConnection {

	/**The table name in database.*/
	private static final String TABLE_NAME = "users";
	
	
	
	public UserDAO(){ }
	
	
	
	
	/**
	 * Look for an User by his email and password.
	 * @param email
	 * @param password
	 * @return An object {@link User}.
	 */
	public User searchByEmailAndPassword(String email, String password){
		User user = null;
		try {
			
			super.conn = super.getConnection();
			super.pstm = conn.prepareStatement(
					"SELECT * FROM "+TABLE_NAME+" WHERE email = '"+email+"' AND password = '"+password+"'");
			super.rs = pstm.executeQuery();
			
			if(rs.next()){
				
				String em = rs.getString("email");
				String pw = rs.getString("password");
				String nm = rs.getString("name");
				
				user = new User(em, pw);		
				user.setName(nm);
			}
			
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
}
