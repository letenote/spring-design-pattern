package letenote.designpattern.builder;

import letenote.designpattern.builder.product.Category;
import letenote.designpattern.builder.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = BuilderApplication.class)
class BuilderApplicationTest {
	@Autowired
	ApplicationContext applicationContext;

	@Test
	void productNoBuilderTest(){
		var  nameExpected = "macbook air";
		var  priceExpected = 39_000_000L;
		var  descriptionExpected = "The most powerful MacBook Pro ever is here";
		var  imageExpected = "https://www.apple.com/macbook-pro.jpg";
		var  categoryExpected = Category.LAPTOP;
		var  toStringExpected = "Product{name='macbook air', price=39000000, description='The most powerful MacBook Pro ever is here', image='https://www.apple.com/macbook-pro.jpg', category=LAPTOP}";
		Product newProduct = new Product(nameExpected, priceExpected, descriptionExpected, imageExpected, categoryExpected);

		Assertions.assertEquals(newProduct.getName(), nameExpected);
		Assertions.assertEquals(newProduct.getPrice(), priceExpected);
		Assertions.assertEquals(newProduct.getDescription(), descriptionExpected);
		Assertions.assertEquals(newProduct.getImage(), imageExpected);
		Assertions.assertEquals(newProduct.getCategory(), categoryExpected);
		Assertions.assertEquals(newProduct.toString(), toStringExpected);
	}

	@Test
	void productWithBuilderTest(){
		var  nameExpected = "macbook pro";
		var  priceExpected = 45_000_000L;
		var  descriptionExpected = "The most powerful MacBook Pro ever is here";
		var  imageExpected = "https://www.apple.com/macbook-pro.jpg";
		var  categoryExpected = Category.LAPTOP;
		Product newProductBuilder = Product.builder()
				.name(nameExpected)
				.image(imageExpected)
				.description(descriptionExpected)
				.price(priceExpected)
				.category(categoryExpected)
				.build();

		Assertions.assertEquals(newProductBuilder.getCategory(), categoryExpected);
		Assertions.assertEquals(newProductBuilder.getName(), nameExpected);
		Assertions.assertEquals(newProductBuilder.getPrice(), priceExpected);
		Assertions.assertEquals(newProductBuilder.getDescription(), descriptionExpected);
		Assertions.assertEquals(newProductBuilder.getImage(), imageExpected);
		System.out.println(newProductBuilder);
	}

	@Test
	void productBuilderPrototypeTest(){
		var toStringGadgetExpected = "Product{name='null', price=null, description='null', image='null', category=GADGET}";
		Product newGadgetProduct = applicationContext.getBean("gadgetProductCategory", Product.class);
		Assertions.assertEquals(newGadgetProduct.toString(), toStringGadgetExpected);

		var toStringLaptopExpected = "Product{name='null', price=null, description='null', image='null', category=LAPTOP}";
		Product newLaptopProduct = applicationContext.getBean("laptopProductCategory", Product.class);
		Assertions.assertEquals(newLaptopProduct.toString(), toStringLaptopExpected);
	}
}