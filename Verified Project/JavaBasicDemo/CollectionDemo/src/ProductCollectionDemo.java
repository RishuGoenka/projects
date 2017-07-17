import java.util.SortedSet;
import java.util.TreeSet;

public class ProductCollectionDemo {

	public static void main(String[] args) {
		SortedSet<Product> pr = new TreeSet<Product>();
		pr.add(new Product("sony", "experia t3", 565));
		pr.add(new Product("sony", "experia t34", 565));
		pr.add(new Product("samsung", "galaxy", 500));
		pr.add(new Product("nokia", "lumia", 400));

		for (Product p : pr) {
			System.out.println(p.getName() + " " + p.getDescription() + " " + p.getPrice());
		}
	}
}
