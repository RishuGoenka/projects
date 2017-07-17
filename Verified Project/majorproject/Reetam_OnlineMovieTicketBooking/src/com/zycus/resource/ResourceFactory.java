package com.zycus.resource;

import java.util.ListResourceBundle;

import com.zycus.dao.DaoFactory;
import com.zycus.fasad.Fasad;





public class ResourceFactory extends ListResourceBundle {
	
	@Override
	protected Object[][] getContents() {
		Object[][] resources={
				{"fasad",new Fasad()}
		};
		 return resources;
	}
	/*private Object[][] getResources() {
		 Object[][] resources={
				{"status", new Status()},
				{"Schedular", new Schedular(config)},
				{"daoFactory",new DaoFactory()}
		};
		 return resources;
	}*/
	
	

}
