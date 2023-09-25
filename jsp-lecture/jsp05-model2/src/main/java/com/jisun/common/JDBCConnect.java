package com.jisun.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCConnect {
	
	// 0.전역객체할당
	public Connection conn = null; //데이터베이스 연결을 나타내는 객체입니다
	public PreparedStatement pstmt = null; //SQL 문장을 실행하기 위한 객체입니다.
	public ResultSet rs = null; //데이터베이스 결과 집합을 나타내는 객체입니다.
	
	// JDBC연동(방법1) - 생성자01
    public JDBCConnect() {
    	try {
    		//1. driver 찾기
    		String driver = "oracle.jdbc.OracleDriver";
			Class.forName(driver);
			
			//2-1. db 접근
			// 자바17 = 오라클11
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "jisun"; //중요 > 안되면 C##jisun 해보기 ㅠ
			String pw = "1234";
			
		    //2-2. db 연동
			this.conn = DriverManager.getConnection(url, id, pw); // conn 객체에 연결을 할당합니다.
			System.out.println("db연결 성공");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
    // JDBC해제
    public void close() {
    	try {
    		if(rs!=null) rs.close();
    		if(pstmt!=null) pstmt.close();
        	if(conn!=null) conn.close();
    	} catch(Exception e) {
			e.printStackTrace();
    	}

    }
    
    
    
    
}
