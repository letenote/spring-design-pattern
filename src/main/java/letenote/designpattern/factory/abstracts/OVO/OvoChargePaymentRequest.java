package letenote.designpattern.factory.abstracts.OVO;

import letenote.designpattern.factory.abstracts.utils.ChargePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class OvoChargePaymentRequest implements ChargePaymentRequestInterface {
	@Getter
	@Setter
	String paymentID;
	@Getter
	@Setter
	Long amount;

	@Override
	public Long getFee() {
		return 1000L;
	}

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.OVO;
	}

	@Override
	public String toString() {
		return "OvoChargePaymentRequest{" +
				"paymentID='" + paymentID + '\'' +
				", amount=" + amount +
				'}';
	}
}
