package kr.co.bit;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import kr.co.bit.controller.Controller;

public class HandlerMapping {
	
	private Map<String, Controller> mappings = null;
	
	public HandlerMapping() {
		this("C:\\Users\\bit-user\\Desktop\\Mini_project2\\beanProperties");
	}
	
	public HandlerMapping(String configName) {
		mappings = new HashMap<>();
		
		// 1) beanProperties 파일 생성하여 불러온다.
		Properties prop = new Properties();
		try {
			// 2) beanProperties 파일 경로 생성
			InputStream inStream = new FileInputStream(configName);
			// 3) 불러오기
			prop.load(inStream);
			// 4) 키값 가져오기
			Set<Object> keys = prop.keySet();
			// 5) 키값에 맞는 Property(경로) 가져오기
			for (Object key : keys) {
				String className = prop.getProperty(key.toString());
				System.out.println(key + " : " + className);
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
		} catch (Exception e) { e.printStackTrace(); }
		
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	
}
