package letenote.designpattern.factory.abstracts.OVO;

import letenote.designpattern.factory.abstracts.utils.CancelPaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class OvoCancelPaymentRequest implements CancelPaymentRequestInterface {
	@Getter
	@Setter
	String paymentID;

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.OVO;
	}

	@Override
	public String toString() {
		return "OvoCancelPaymentRequest{" +
				"paymentID='" + paymentID + '\'' +
				'}';
	}
}
