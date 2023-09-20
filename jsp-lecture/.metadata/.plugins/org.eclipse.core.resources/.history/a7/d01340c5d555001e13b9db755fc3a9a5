package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCConnect {
	
	// 
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
	// JDBC연동 - 생성자01
    public JDBCConnect() {
    	try {
    		//1. driver 찾기
    		String driver = "oracle.jdbc.OracleDriver";
			Class.forName(driver);
			
			//2-1. db 접근
			// 자바17 = 오라클11
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "jisun";
			String pw = "1234";
			
		    //2-2. db 연동
		    Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("db연결 성공");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	// JDBC연동 - 생성자02
    public JDBCConnect(String driver,  String id, String url, String pw) {
    	try {
    		//1. driver 찾기
    		String driver = "oracle.jdbc.OracleDriver";
			Class.forName(driver);
			
		    //2-2. db 연동
		    Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("db연결 성공");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    // JDBC해제
    public void close() {
    	try {
        	if(conn!=null) conn.close();
        	if(pstmt!=null) pstmt.close();
        	if(rs!=null) rs.close();
    	} catch(Exception e) {
			e.printStackTrace();
    	}

    }
    
    
    
    
}
