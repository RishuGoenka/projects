import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {
	/**
	 * Model class for Product, each instance of this class represent
	 */
	private static final long serialVersionUID = 2161961443965068607L;

	private String name;
	private String description;
	private double price;

	public Product(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Product p) {
		if (this.price > p.price)
			return 1;
		else if (this.price < p.price)
			return -1;
		else
			return 0;
	}

	// public int hashCode() {
	// return this.name.hashCode() + (int) this.price % 10;
	// }
	// Some formula to calculate hash code using both name and price
	// Make sure that, when name or price is changed, hashCode should change

	/**
	 * Check if target object is also a product And, it's name and price are
	 * same as current [this] product otherwise return false...
	 */

	// public boolean equals(Object target) {
	// if (target instanceof Product) {
	// Product trg = (Product) target;
	// if (trg.getName().equalsIgnoreCase(this.name) && trg.getPrice() ==
	// this.price)
	// return true;
	// } // in all other cases,
	// return false; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + "]";
	}

}
