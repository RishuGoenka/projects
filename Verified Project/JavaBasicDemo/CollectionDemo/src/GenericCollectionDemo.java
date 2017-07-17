import java.util.*;
import java.util.HashMap;
import java.util.Map;

/*
 * Syntax for generic collections
 * in jdk 1.5,1.6:
 * Collection<element type> obj=new Collection<element type>()
 * 
 * in jdk 1.7 onwards
 * CollectionType <element type>=new CollectionType<>();
 * 
 * example:
 * Map<key_type,value_type> object= new HashMap<>();
 */

public class GenericCollectionDemo {

	public static void main(String[] args) {
		// for type safety in collections:
		// Collection in JDK 1.5 onwards refers to generic collection
		// Provides Type Safety , by verifying contents at Compile time

		List<String> names = new ArrayList<String>();
		names.add("mahendra");
		names.add("32.5");
		names.add("false");

		Map<String, String> dr = new HashMap<>(); //Creating Map
		dr.put("1", "riy");
		dr.clear();

	}

}
