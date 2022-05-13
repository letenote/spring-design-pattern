package letenote.designpattern.singleton;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SingletonApplication {
	@Bean // => @Bean is auto singleton
	public Counter counter(){
		return new Counter();
	};
}
