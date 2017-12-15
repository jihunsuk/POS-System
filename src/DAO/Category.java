package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBConnection;

public class Category {
	private String CategoryName;
	
	public Category(){
		
	}
	
	public boolean addCategory(final String CATEGORY_NAME){
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();
			
			String query = String.format("insert into category values('%s')", CATEGORY_NAME);
			stmt.executeUpdate(query);
			
			System.out.println("카테고리 추가에 성공했습니다.");
			result = true;
			stmt.close();
		} catch (SQLException e) {
			System.out.println("카테고리 추가에 실패했습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			
		}

		return result;
	}
	
	public boolean removeCategory(final String CATEGORY_NAME){
		Connection c = null;
		Statement stmt = null;
		boolean result = false;
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("delete from category where CategoryName='%s'", CATEGORY_NAME);
			stmt.executeUpdate(query);
			
			System.out.println("카테고리 삭제에 성공했습니다.");
			result = true;
			stmt.close();
		} catch (SQLException e) {
			System.out.println("카테고리 삭제에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean modifyCategory(Category c, final String CATEGORY_NAME){
		
		return false;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
}
