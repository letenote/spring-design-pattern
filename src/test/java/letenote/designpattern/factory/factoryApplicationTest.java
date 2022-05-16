package letenote.designpattern.factory;

import letenote.designpattern.factory.abstracts.CreditCardPaymentFactory;
import letenote.designpattern.factory.abstracts.KlikBcaPaymentFactory;
import letenote.designpattern.factory.abstracts.OvoPaymentFactory;
import letenote.designpattern.factory.abstracts.PaymentGateAway;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import letenote.designpattern.factory.socialmedia.SocialMediaInterface;
import letenote.designpattern.factory.socialmedia.SocialMediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

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

	@Test
	void duplicateBeansTest(){
//		Assertions.assertThrows(
//				NoUniqueBeanDefinitionException.class,
//				() -> applicationContext.getBean(SocialMediaInterface.class, SocialMediaType.INSTAGRAM)
//		);
		Assertions.assertDoesNotThrow(
				() -> applicationContext.getBean(SocialMediaInterface.class, SocialMediaType.INSTAGRAM)
		);
	}

	@Test
	void factoryInheritanceTest(){
		var facebookExpected = "FacebookSocialMedia{name='Facebook', url='https://facebook.com', type=FACEBOOK}";
		var facebookNameExpected = "Facebook";
		var facebookUrlExpected = "https://facebook.com";
		var facebookTypeExpected = "FACEBOOK";
		SocialMediaInterface facebook = applicationContext.getBean("facebookSocialMediaFactoryInheritance", SocialMediaInterface.class);

		Assertions.assertEquals(facebook.getName(), facebookNameExpected);
		Assertions.assertEquals(facebook.getUrl(), facebookUrlExpected);
		Assertions.assertEquals(facebook.getType().toString(), facebookTypeExpected);
		Assertions.assertEquals(facebook.toString(), facebookExpected);


		var twitterExpected = "TwitterSocialMedia{name='Twitter', url='https://twitter.com', type=TWITTER}";
		var twitterNameExpected = "Twitter";
		var twitterUrlExpected = "https://twitter.com";
		var twitterTypeExpected = "TWITTER";
		SocialMediaInterface twitter = applicationContext.getBean("twitterSocialMediaFactoryInheritance", SocialMediaInterface.class);

		Assertions.assertEquals(twitter.getName(), twitterNameExpected);
		Assertions.assertEquals(twitter.getUrl(), twitterUrlExpected);
		Assertions.assertEquals(twitter.getType().toString(), twitterTypeExpected);
		Assertions.assertEquals(twitter.toString(), twitterExpected);

		var instagramExpected = "InstagramSocialMedia{name='Instagram', url='https://instagram.com', type=INSTAGRAM}";
		var instagramNameExpected = "Instagram";
		var instagramUrlExpected = "https://instagram.com";
		var instagramTypeExpected = "INSTAGRAM";
		SocialMediaInterface instagram = applicationContext.getBean("instagramSocialMediaFactoryInheritance", SocialMediaInterface.class);

		Assertions.assertEquals(instagram.getName(), instagramNameExpected);
		Assertions.assertEquals(instagram.getUrl(), instagramUrlExpected);
		Assertions.assertEquals(instagram.getType().toString(), instagramTypeExpected);
		Assertions.assertEquals(instagram.toString(), instagramExpected);
	}

	@Test
	void factoryAbstractsCreditCardChargeTest(){
		var paymentIdExpected = "payment-cc-id";
		var amountExpected = 1000000L;
		var feeExpected = 50000;
		var paymentMethodExpected = PaymentMethodType.CREDITCARD;
		var toStringExpected = "CreditCardChargePaymentRequest{paymentID='payment-cc-id', amount=1000000}";
		CreditCardPaymentFactory creditCardPaymentFactory = applicationContext.getBean(CreditCardPaymentFactory.class);
		var userTopUpWithCreditCard = PaymentGateAway.chargePayment(
				creditCardPaymentFactory,
				paymentIdExpected,
				amountExpected
		);

		System.out.println(userTopUpWithCreditCard.toString());
		Assertions.assertEquals(userTopUpWithCreditCard.getPaymentID(), paymentIdExpected);
		Assertions.assertEquals(userTopUpWithCreditCard.getAmount(), amountExpected);
		Assertions.assertEquals(userTopUpWithCreditCard.getFee(), feeExpected);
		Assertions.assertEquals(userTopUpWithCreditCard.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(userTopUpWithCreditCard.toString(), toStringExpected);
	}

	@Test
	void factoryAbstractsCreditCardCancelTest(){
		var paymentIdExpected = "payment-cc-id";
		var paymentMethodExpected = PaymentMethodType.CREDITCARD;
		var toStringExpected = "CreditCardCancelPaymentRequest{paymentID='payment-cc-id'}";
		CreditCardPaymentFactory creditCardPaymentFactory = applicationContext.getBean(CreditCardPaymentFactory.class);
		var userCancelTopUpWithCreditCard = PaymentGateAway.cancelPayment(
				creditCardPaymentFactory,
				paymentIdExpected
		);

		Assertions.assertEquals(userCancelTopUpWithCreditCard.getPaymentID(), paymentIdExpected);
		Assertions.assertEquals(userCancelTopUpWithCreditCard.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(userCancelTopUpWithCreditCard.toString(), toStringExpected);
	}

	@Test
	void factoryAbstractsCreditCardGetBalanceTest(){
		var userIdExpected = "user-id";
		var paymentMethodExpected = PaymentMethodType.CREDITCARD;
		var toStringExpected = "CreditCardGetBalancePaymentRequest{userID='user-id'}";
		CreditCardPaymentFactory creditCardPaymentFactory = applicationContext.getBean(CreditCardPaymentFactory.class);
		var getBalanceUserInCreditCard = PaymentGateAway.getBalancePayment(
				creditCardPaymentFactory,
				userIdExpected
		);

		Assertions.assertEquals(getBalanceUserInCreditCard.getUserID(), userIdExpected);
		Assertions.assertEquals(getBalanceUserInCreditCard.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(getBalanceUserInCreditCard.toString(), toStringExpected);
	}

	@Test
	void factoryAbstractsKlikBcaChargeTest(){
		var paymentIdExpected = "payment-klik-bca-id";
		var amountExpected = 1000000L;
		var feeExpected = 6000;
		var paymentMethodExpected = PaymentMethodType.KLIKBCA;
		var toStringExpected = "KlikBcaChargePaymentRequest{paymentID='payment-klik-bca-id', amount=1000000}";
		KlikBcaPaymentFactory klikBcaPaymentFactory = applicationContext.getBean(KlikBcaPaymentFactory.class);
		var userTopUpWithKlikBCA = PaymentGateAway.chargePayment(
				klikBcaPaymentFactory,
				paymentIdExpected,
				amountExpected
		);

		System.out.println(userTopUpWithKlikBCA.toString());
		Assertions.assertEquals(userTopUpWithKlikBCA.getPaymentID(), paymentIdExpected);
		Assertions.assertEquals(userTopUpWithKlikBCA.getAmount(), amountExpected);
		Assertions.assertEquals(userTopUpWithKlikBCA.getFee(), feeExpected);
		Assertions.assertEquals(userTopUpWithKlikBCA.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(userTopUpWithKlikBCA.toString(), toStringExpected);
	}

	@Test
	void factoryAbstractsKlikBcaCancelTest(){
		var paymentIdExpected = "payment-klik-bca-id";
		var paymentMethodExpected = PaymentMethodType.KLIKBCA;
		var toStringExpected = "KlikBcaCancelPaymentRequest{paymentID='payment-klik-bca-id'}";
		KlikBcaPaymentFactory klikBcaPaymentFactory = applicationContext.getBean(KlikBcaPaymentFactory.class);
		var userCancelTopUpWithKlikBCA = PaymentGateAway.cancelPayment(
				klikBcaPaymentFactory,
				paymentIdExpected
		);

		Assertions.assertEquals(userCancelTopUpWithKlikBCA.getPaymentID(), paymentIdExpected);
		Assertions.assertEquals(userCancelTopUpWithKlikBCA.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(userCancelTopUpWithKlikBCA.toString(), toStringExpected);
	}

	@Test
	void factoryAbstractsKlikBcaGetBalanceTest(){
		var userIdExpected = "user-id";
		var paymentMethodExpected = PaymentMethodType.KLIKBCA;
		var toStringExpected = "KlikBcaGetBalancePaymentRequest{userID='user-id'}";
		KlikBcaPaymentFactory klikBcaPaymentFactory = applicationContext.getBean(KlikBcaPaymentFactory.class);
		var getBalanceUserInKlikBCA = PaymentGateAway.getBalancePayment(
				klikBcaPaymentFactory,
				userIdExpected
		);

		Assertions.assertEquals(getBalanceUserInKlikBCA.getUserID(), userIdExpected);
		Assertions.assertEquals(getBalanceUserInKlikBCA.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(getBalanceUserInKlikBCA.toString(), toStringExpected);
	}

	@Test
	void factoryAbstractsOvoChargeTest(){
		var paymentIdExpected = "payment-ovo-id";
		var amountExpected = 1000000L;
		var feeExpected = 1000;
		var paymentMethodExpected = PaymentMethodType.OVO;
		var toStringExpected = "OvoChargePaymentRequest{paymentID='payment-ovo-id', amount=1000000}";
		OvoPaymentFactory ovoPaymentFactory = applicationContext.getBean(OvoPaymentFactory.class);
		var userTopUpWithOVO = PaymentGateAway.chargePayment(
				ovoPaymentFactory,
				paymentIdExpected,
				amountExpected
		);

		Assertions.assertEquals(userTopUpWithOVO.getPaymentID(), paymentIdExpected);
		Assertions.assertEquals(userTopUpWithOVO.getAmount(), amountExpected);
		Assertions.assertEquals(userTopUpWithOVO.getFee(), feeExpected);
		Assertions.assertEquals(userTopUpWithOVO.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(userTopUpWithOVO.toString(), toStringExpected);
	}

	@Test
	void factoryAbstractsOvoCancelTest(){
		var paymentIdExpected = "payment-ovo-id";
		var paymentMethodExpected = PaymentMethodType.OVO;
		var toStringExpected = "OvoCancelPaymentRequest{paymentID='payment-ovo-id'}";
		OvoPaymentFactory ovoPaymentFactory = applicationContext.getBean(OvoPaymentFactory.class);
		var userCancelTopUpWithOVO = PaymentGateAway.cancelPayment(
				ovoPaymentFactory,
				paymentIdExpected
		);

		Assertions.assertEquals(userCancelTopUpWithOVO.getPaymentID(), paymentIdExpected);
		Assertions.assertEquals(userCancelTopUpWithOVO.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(userCancelTopUpWithOVO.toString(), toStringExpected);
	}

	@Test
	void factoryAbstractsOvoGetBalanceTest(){
		var userIdExpected = "user-id";
		var paymentMethodExpected = PaymentMethodType.OVO;
		var toStringExpected = "OvoGetBalancePaymentRequest{userID='user-id'}";
		OvoPaymentFactory ovoPaymentFactory = applicationContext.getBean(OvoPaymentFactory.class);
		var getBalanceUserInOVO = PaymentGateAway.getBalancePayment(
				ovoPaymentFactory,
				userIdExpected
		);

		Assertions.assertEquals(getBalanceUserInOVO.getUserID(), userIdExpected);
		Assertions.assertEquals(getBalanceUserInOVO.getPaymentMethod(), paymentMethodExpected);
		Assertions.assertEquals(getBalanceUserInOVO.toString(), toStringExpected);
	}
}