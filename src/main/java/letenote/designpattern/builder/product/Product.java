package letenote.designpattern.builder.product;

public class Product {
	private final String name;
	private final Long price;
	private final String description;
	private final String image;
	private final Category category;

	public Product(String name, Long price, String description, String image, Category category) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.category = category;
	}

	public Category getCategory() {
		return category;
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
				", category=" + category +
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
		private Category category;

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
		public Product.ProductBuilder category(final Category category){
			this.category = category;
			return this;
		}
		public Product build(){
			return new Product(
					this.name,
					this.price,
					this.description,
					this.image,
					this.category
			);
		}
	}
}
