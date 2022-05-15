package letenote.designpattern.factory;

import letenote.designpattern.factory.socialmedia.SocialMediaInterface;
import letenote.designpattern.factory.socialmedia.SocialMediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FactoryApplication.class)
class factoryApplicationTest {
	@Autowired
	ApplicationContext applicationContext;

	@Test
	void factoryMethodTest()throws IllegalArgumentException{
		var facebookExpected = "FacebookSocialMedia{name='Facebook', url='https://facebook.com', type=FACEBOOK}";
		var facebookNameExpected = "Facebook";
		var facebookUrlExpected = "https://facebook.com";
		var facebookTypeExpected = "FACEBOOK";
		SocialMediaInterface facebook = applicationContext.getBean(SocialMediaInterface.class, SocialMediaType.FACEBOOK);

		Assertions.assertEquals(facebook.getName(), facebookNameExpected);
		Assertions.assertEquals(facebook.getUrl(), facebookUrlExpected);
		Assertions.assertEquals(facebook.getType().toString(), facebookTypeExpected);
		Assertions.assertEquals(facebook.toString(), facebookExpected);

		var twitterExpected = "TwitterSocialMedia{name='Twitter', url='https://twitter.com', type=TWITTER}";
		var twitterNameExpected = "Twitter";
		var twitterUrlExpected = "https://twitter.com";
		var twitterTypeExpected = "TWITTER";
		SocialMediaInterface twitter = applicationContext.getBean(SocialMediaInterface.class, SocialMediaType.TWITTER);

		Assertions.assertEquals(twitter.getName(), twitterNameExpected);
		Assertions.assertEquals(twitter.getUrl(), twitterUrlExpected);
		Assertions.assertEquals(twitter.getType().toString(), twitterTypeExpected);
		Assertions.assertEquals(twitter.toString(), twitterExpected);

		var instagramExpected = "InstagramSocialMedia{name='Instagram', url='https://instagram.com', type=INSTAGRAM}";
		var instagramNameExpected = "Instagram";
		var instagramUrlExpected = "https://instagram.com";
		var instagramTypeExpected = "INSTAGRAM";
		SocialMediaInterface instagram = applicationContext.getBean(SocialMediaInterface.class, SocialMediaType.INSTAGRAM);

		Assertions.assertEquals(instagram.getName(), instagramNameExpected);
		Assertions.assertEquals(instagram.getUrl(), instagramUrlExpected);
		Assertions.assertEquals(instagram.getType().toString(), instagramTypeExpected);
		Assertions.assertEquals(instagram.toString(), instagramExpected);
	}
	@Test
	void invalidSocialMediaTypeInFactoryMethodTest() {
		assertThrows(
			BeanCreationException.class,
			() -> applicationContext.getBean(SocialMediaInterface.class, "OTHER")
		);
	}

	@Test
	void notImplementSocialMediaTypeInFactoryMethodExceptionTest() {
		Exception exception = assertThrows(
			Exception.class,
			() -> applicationContext.getBean(SocialMediaInterface.class, SocialMediaType.OTHERS)
		);
		String getExceptionMessage = exception.getCause().getMessage().split("customizeMessage:")[1].trim();
		var getExceptionMessageExpected = applicationContext.getBean("unsupportedSocialMediaMessage");

		assertEquals(getExceptionMessageExpected, getExceptionMessage);
	}
}