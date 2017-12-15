package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnection;

public class Category {
	private String CategoryName;

	public Category(String CategoryName) {
		this.CategoryName = CategoryName;
	}

	public static boolean addCategory(final String CATEGORY_NAME) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// 예외 흐름 E1
		if(CATEGORY_NAME.equals("")){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("insert into category values('%s')", CATEGORY_NAME);
			stmt.executeUpdate(query);

			System.out.println("카테고리 추가에 성공했습니다.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("카테고리 추가에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean removeCategory(final String CATEGORY_NAME) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// 예외 흐름 E1
		if(CATEGORY_NAME.equals("")){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("delete from category where CategoryName='%s'", CATEGORY_NAME);
			stmt.executeUpdate(query);

			System.out.println("카테고리 삭제에 성공했습니다.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("카테고리 삭제에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean modifyCategory(final String PREV_CATEGORY_NAME, final String CATEGORY_NAME) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// 예외 흐름 E1
		if(PREV_CATEGORY_NAME == null){
			return false;
		}
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("update category set categoryname = '%s' where categoryname = '%s'", CATEGORY_NAME, PREV_CATEGORY_NAME);
			stmt.executeUpdate(query);

			System.out.println("카테고리 수정에 성공했습니다.");
			result = true;
			stmt.close();
		} catch (Exception e) {
			System.out.println("카테고리 수정에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}

	public static Category[] getCategoryList() {
		Connection c = null;
		Statement stmt = null;
		Category[] categoryList = null;
		
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from category");

			List<Category> temp = new ArrayList<>();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				temp.add(new Category(rs.getString("CategoryName")));
			}
			
			categoryList = temp.toArray(new Category[0]);
			System.out.println("카테고리조회에 성공했습니다.");
		} catch (SQLException e) {
			System.out.println("카테고리조회에 실패했습니다.");
			e.printStackTrace();
		}

		return categoryList;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
}
