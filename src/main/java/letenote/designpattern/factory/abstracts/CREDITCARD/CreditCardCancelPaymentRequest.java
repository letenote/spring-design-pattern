package letenote.designpattern.factory.abstracts.CREDITCARD;

import letenote.designpattern.factory.abstracts.utils.CancelPaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class CreditCardCancelPaymentRequest implements CancelPaymentRequestInterface {
	@Getter
	@Setter
	String paymentID;

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.CREDITCARD;
	}

	@Override
	public String toString() {
		return "CreditCardCancelPaymentRequest{" +
				"paymentID='" + paymentID + '\'' +
				'}';
	}
}
