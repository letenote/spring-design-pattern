package letenote.designpattern.factory.inheritance;

import letenote.designpattern.factory.socialmedia.FacebookSocialMedia;
import letenote.designpattern.factory.socialmedia.InstagramSocialMedia;
import letenote.designpattern.factory.socialmedia.SocialMediaInterface;
import letenote.designpattern.factory.socialmedia.TwitterSocialMedia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FactoryInheritance {
	@Bean(value = "facebookSocialMediaFactoryInheritance")
	@Scope("prototype")
	public SocialMediaInterface facebookSocialMediaFactoryInheritance(){
		return new FacebookSocialMedia();
	}
	@Bean(value = "twitterSocialMediaFactoryInheritance")
	@Scope("prototype")
	public SocialMediaInterface twitterSocialMediaFactoryInheritance(){
		return new TwitterSocialMedia();
	}
	@Bean(value = "instagramSocialMediaFactoryInheritance")
	@Scope("prototype")
	public SocialMediaInterface instagramSocialMediaFactoryInheritance(){
		return new InstagramSocialMedia();
	}
}
