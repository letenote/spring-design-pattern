package letenote.designpattern.builder;

public class Product {
	private String name;
	private Long price;
	private String description;
	private String image;

	public Product(String name, Long price, String description, String image) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public Long getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	@Override
	public String toString() {
		return "Product{" +
				"name='" + name + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				", image='" + image + '\'' +
				'}';
	}

	public static Product.ProductBuilder builder(){
		return new Product.ProductBuilder();
	}

	public static class ProductBuilder{
		private String name;
		private Long price;
		private String description;
		private String image;

		public ProductBuilder() {}
		public Product.ProductBuilder name(final String name){
			this.name = name;
			return this;
		}
		public Product.ProductBuilder price(final Long price){
			this.price = price;
			return this;
		}
		public Product.ProductBuilder description(final String description){
			this.description = description;
			return this;
		}
		public Product.ProductBuilder image(final String image){
			this.image = image;
			return this;
		}
		public Product build(){
			return new Product(
					this.name,
					this.price,
					this.description,
					this.image
			);
		}
	}
}
