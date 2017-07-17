import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		Map data = new HashMap();
		data.put("jbjdb", "red colored ferari");
		data.put("ssyc", "white hundai");
		data.put("jtc", "yellow lamborghini");
		data.put("jhvv", "green maclaren");

		System.out.println(data.get("ssych"));

		// retrieve all keys from the map in form of set
		Set keys = data.keySet();
		for (Object k : keys) {
			System.out.println(k);
		}

		// retrieve keys with value as set
		Set rows = data.entrySet();
		for (Object r : rows) {
			System.out.println(r);
		}

		Collection c = data.values();
	}
}
