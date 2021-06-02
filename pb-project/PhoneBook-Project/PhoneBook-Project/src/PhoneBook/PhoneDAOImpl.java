package PhoneBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl implements PhoneDAO {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,"c##bitsuer","bituser");
		} catch(ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	}

	@Override
	public List<PhoneVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<PhoneVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement(); 
	 		
			String sql = "Select id, Name, Hp, Tel " + "From PHONE_BOOK";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String Name = rs.getString(2);
				String Hp = rs.getString(3);
				String Tel = rs.getString(4);
				
				PhoneVO vo = new PhoneVO(id, Name, Hp, Tel);
				
				list.add(vo);
			} 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
		}
	}
		return list;
	}
	
	@Override
	public List<PhoneVO> search(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PhoneVO> list = new ArrayList<>();
		
		String sql = "Select id, Name, Hp, Tel From PHONE_BOOK " + " WHERE Name LIKE ? ";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "%" + keyword + "%");;
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String Name = rs.getString("Name");
				String Hp = rs.getString("Hp");
				String Tel = rs.getString("Tel") ;
				
				PhoneVO vo = new PhoneVO(id, Name, Hp, Tel);
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch(Exception e) {
		}
	}
		return list;
}

	@Override
	public boolean insert(PhoneVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO phone_book Values(seq_phone_book_pk.NextVal, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			
			insertedCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		return 1 == insertedCount;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM PHONE_BOOK WHERE id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			deletedCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
		}catch(Exception e) {
		}
	}
		return 1 == deletedCount;
	}

	@Override
	public boolean insert(PhoneVO vo) {
		// TODO Auto-generated method stub
		return false;
	}
}
	

