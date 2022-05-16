package letenote.designpattern.factory.abstracts;

import letenote.designpattern.factory.abstracts.CREDITCARD.CreditCardCancelPaymentRequest;
import letenote.designpattern.factory.abstracts.CREDITCARD.CreditCardChargePaymentRequest;
import letenote.designpattern.factory.abstracts.CREDITCARD.CreditCardGetBalancePaymentRequest;
import letenote.designpattern.factory.abstracts.utils.CancelPaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.ChargePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.GetBalancePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentFactoryInterface;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CreditCardPaymentFactory implements PaymentFactoryInterface {
	@Override
	public ChargePaymentRequestInterface createChargeRequest() {
		return new CreditCardChargePaymentRequest();
	}
	@Override
	public CancelPaymentRequestInterface createCancelRequest() {
		return new CreditCardCancelPaymentRequest();
	}
	@Override
	public GetBalancePaymentRequestInterface createGetBalanceRequest() {
		return new CreditCardGetBalancePaymentRequest();
	}
}
