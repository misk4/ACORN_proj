package com.DAO;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlsessionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	static{
String resource = "com/config/Configuration.xml";//패키지명과 xml파일 써주면됨 //예(...............Configuration.xm)이런식
InputStream inputStream=null;
try {
	inputStream = Resources.getResourceAsStream(resource);
} catch (IOException e) {
	
	e.printStackTrace();
}
sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	public static SqlSession openSession(){
		return sqlSessionFactory.openSession();//메서드 만들어서 세션뽑음 
	}
	
}
