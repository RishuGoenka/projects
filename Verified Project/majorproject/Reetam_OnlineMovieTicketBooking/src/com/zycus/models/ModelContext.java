package com.zycus.models;

import java.util.HashMap;

public class ModelContext {	//data transfer objects (DTO)

		private HashMap<String,Object> bundle; 
		
		public ModelContext(){
			bundle=new HashMap<String, Object>();
		}
		
		public void setResource(String key, Object value){
			bundle.put(key, value);
		}
		
		public Object getResource(String key){
			return bundle.get(key);
		}
}
