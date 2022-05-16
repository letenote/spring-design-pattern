package letenote.designpattern.factory.abstracts.KLIKBCA;

import letenote.designpattern.factory.abstracts.utils.CancelPaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class KlikBcaCancelPaymentRequest implements CancelPaymentRequestInterface {
	@Getter
	@Setter
	String paymentID;

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.KLIKBCA;
	}

	@Override
	public String toString() {
		return "KlikBcaCancelPaymentRequest{" +
				"paymentID='" + paymentID + '\'' +
				'}';
	}
}
