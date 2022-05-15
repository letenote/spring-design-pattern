package letenote.designpattern.factory.method;

import letenote.designpattern.factory.socialmedia.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class FactoryMethod {
	@Autowired
	ApplicationContext applicationContext;
	@Bean
	@Scope("singleton")
	public String unsupportedSocialMediaMessage(){
		return "Unsupported Media Type";
	}
	@Bean(value = "socialMediaFactoryMethod")
	@Primary
	@Scope("prototype")
	public SocialMediaInterface socialMedia(SocialMediaType type) throws Exception {
		if( type == SocialMediaType.FACEBOOK ){
			return new FacebookSocialMedia();
		} else if ( type == SocialMediaType.TWITTER ) {
			return new TwitterSocialMedia();
		} else if ( type == SocialMediaType.INSTAGRAM ) {
			return new InstagramSocialMedia();
		} else {
			throw new Exception("customizeMessage: " + applicationContext.getBean("unsupportedSocialMediaMessage"));
		}
	}
}
