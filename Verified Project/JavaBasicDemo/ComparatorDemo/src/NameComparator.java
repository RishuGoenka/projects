import java.util.*;

public class NameComparator implements Comparator<Product> {
	public int compare(Product o1, Product o2) {
		// Compare using name of Product
		return o1.getName().compareTo(o2.getName());
	}
}
