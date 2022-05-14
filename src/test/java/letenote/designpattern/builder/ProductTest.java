package letenote.designpattern.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {
	@Test
	void productNoBuilderTest(){
		var  nameExpected = "macbook air";
		var  priceExpected = 39_000_000L;
		var  descriptionExpected = "The most powerful MacBook Pro ever is here";
		var  imageExpected = "https://www.apple.com/macbook-pro.jpg";
		var  toStringExpected = "Product{name='macbook air', price=39000000, description='The most powerful MacBook Pro ever is here', image='https://www.apple.com/macbook-pro.jpg'}";
		Product newProduct = new Product(nameExpected, priceExpected, descriptionExpected, imageExpected);

		Assertions.assertEquals(newProduct.getName(), nameExpected);
		Assertions.assertEquals(newProduct.getPrice(), priceExpected);
		Assertions.assertEquals(newProduct.getDescription(), descriptionExpected);
		Assertions.assertEquals(newProduct.getImage(), imageExpected);
		Assertions.assertEquals(newProduct.toString(), toStringExpected);
	}

	@Test
	void productWithBuilder(){
		var  nameExpected = "macbook pro";
		var  priceExpected = 45_000_000L;
		var  descriptionExpected = "The most powerful MacBook Pro ever is here";
		var  imageExpected = "https://www.apple.com/macbook-pro.jpg";

		Product newProductBuilder = Product.builder()
				.name(nameExpected)
				.image(imageExpected)
				.description(descriptionExpected)
				.price(priceExpected)
				.build();

		Assertions.assertEquals(newProductBuilder.getName(), nameExpected);
		Assertions.assertEquals(newProductBuilder.getPrice(), priceExpected);
		Assertions.assertEquals(newProductBuilder.getDescription(), descriptionExpected);
		Assertions.assertEquals(newProductBuilder.getImage(), imageExpected);
		System.out.println(newProductBuilder);
	}
}