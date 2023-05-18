package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	/*
	 * 기존 JDBC
	 * 
	 * 
	 * public static Connection getConnection(){
	 * 
	 * 	driver.properties를 읽어들여서
	 * 
	 *  해당 DB와 접속된 Connection객체를 생성해서 반환
	 *  
	 * }
	 * 
	 * public static void close(JDBC용객체){
	 * 
	 * 	전달받은 JDBC용 객체를 예외처리 후 반납
	 * 
	 * }
	 * 
	 * public static void commit/rollback(Connection 객체){
	 * 
	 * 	트랜잭션 처리
	 * 
	 * }
	 * 
	 */
	
	// 마이바티스
	public static SqlSession getSqlSession() {
		
		// 기존 Connection 역할을 sqlSession으로 대체
		// Connection은 가지고 있는 'DB 접속 정보'를 읽어들여 접속했음
		
		SqlSession sqlSession = null;
	
		// mybatis-config.xml파일을 읽어들여서
		// 해당 DB와 접속된 sqlSession객체를 생성해서 반환
		
		String resource = "/mybatis-config.xml";
		//		/는 모든 src폴더의 최상위 폴더를 의미(classes) 
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource); // 자원으로부터 스트림을 얻어내겠다.
			
			// 1단계 : new SqlSessionFactoryBuilder() : SqlSessionFactoryBuilder 객체 생성
			// 2단계 : .build() : 통로로부터 mybatis-config.xml파일을 읽어들이면서 sqlSessionFactory객체를 만들겠다.
			// 3단계 : .openSession(false) : SqlSession객체 생성 및 앞으로 트랜잭션 처리 시 자동 commit을 하지 않겠다.
			// == 개발자가 직접 트랜잭션을 관리하겠다.
			// .openSession 매개변수 주지 않으면 기본값 false
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
	

	
	
	
	
}
