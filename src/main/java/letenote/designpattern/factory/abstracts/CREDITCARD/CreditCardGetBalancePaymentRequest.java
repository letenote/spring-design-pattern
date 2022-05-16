package letenote.designpattern.factory.abstracts.CREDITCARD;

import letenote.designpattern.factory.abstracts.utils.GetBalancePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class CreditCardGetBalancePaymentRequest implements GetBalancePaymentRequestInterface {
	@Getter
	@Setter
	String userID;

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.CREDITCARD;
	}

	@Override
	public String toString() {
		return "CreditCardGetBalancePaymentRequest{" +
				"userID='" + userID + '\'' +
				'}';
	}
}
