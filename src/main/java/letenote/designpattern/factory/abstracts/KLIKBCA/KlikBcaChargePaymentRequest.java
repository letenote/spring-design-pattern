package letenote.designpattern.factory.abstracts.KLIKBCA;

import letenote.designpattern.factory.abstracts.utils.ChargePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class KlikBcaChargePaymentRequest implements ChargePaymentRequestInterface {
	@Getter
	@Setter
	String paymentID;
	@Getter
	@Setter
	Long amount;

	@Override
	public Long getFee() {
		return 6000L;
	}

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.KLIKBCA;
	}

	@Override
	public String toString() {
		return "KlikBcaChargePaymentRequest{" +
				"paymentID='" + paymentID + '\'' +
				", amount=" + amount +
				'}';
	}
}
