package letenote.designpattern.builder.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProductBuilderPrototype {
	@Bean
	@Scope("prototype")
	public Product laptopProductCategory(){
		return Product.builder()
				.category(Category.LAPTOP)
				.build();
	}
	@Bean
	@Scope("prototype")
	public Product gadgetProductCategory(){
		return Product.builder()
				.category(Category.GADGET)
				.build();
	}
}
