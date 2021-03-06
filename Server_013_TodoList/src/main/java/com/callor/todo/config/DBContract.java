package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 싱글톤 패턴
 * 자원(Resource : 하드웨어장치, 네트워크, 파일...)을 코드에서 활용할때는
 * 최소한의 연결을 하여 사용하는 것이 여러모로 좋다
 * 
 * 필요한 연결객체를 프로젝트에서 1개만 선언하고
 * 공용으로 사용하는 방법
 */

// MySQL을 연동하기 위한 클래스
public class DBContract {
	
	private static final Logger log = LoggerFactory.getLogger("DB");
	private static Connection dbConn;
	
	/*
	 * static 초기화 블럭
	 * static으로 선언된 변수나 객체를 프로젝트가 시작될때
	 * 자동으로 생성하는 코드를 작성하는 부분
	 * 
	 * Connection 객체인 dbConn을 사용할 준비를 하기
	 * DB Server와 연동을 시작하여 연결 session을 생성해둔다.
	 * 필요할때 get() method를 통하여 제공해준다
	 */
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";	// cj가 붙은게 현재 최신버전이라 그걸 사용중
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "gbUser";	// 오라클은 스키마랑 관련되어 있어 user가 중요하지만 mysql에서는 그냥 접속용일뿐
		String pass = "12345";
		
		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, user, pass);
			}
			log.debug("MySQL 연결 OK!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// get Instance method
	// Instance : 사용준비(생성된, 초기화된) 객체
	// private static 으로 선언된 변수, 객체를 다른곳에서 사용할 수 있도록 제공하는 method
	// getter,setter 자동완성 메뉴에서 확장해서 체크해서 만들어도 된다
	public static Connection getDbConn() {
		return dbConn;
	}
	
	

}
