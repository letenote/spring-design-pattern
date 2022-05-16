package letenote.designpattern.factory.abstracts.CREDITCARD;

import letenote.designpattern.factory.abstracts.utils.ChargePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class CreditCardChargePaymentRequest implements ChargePaymentRequestInterface {
	@Getter
	@Setter
	String paymentID;
	@Getter
	@Setter
	Long amount;

	@Override
	public Long getFee() {
		return getAmount() * 5 / 100;
	}

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.CREDITCARD;
	}

	@Override
	public String toString() {
		return "CreditCardChargePaymentRequest{" +
				"paymentID='" + paymentID + '\'' +
				", amount=" + amount +
				'}';
	}
}
