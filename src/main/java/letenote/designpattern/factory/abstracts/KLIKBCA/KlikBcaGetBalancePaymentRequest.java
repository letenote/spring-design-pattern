package letenote.designpattern.factory.abstracts.KLIKBCA;

import letenote.designpattern.factory.abstracts.utils.GetBalancePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class KlikBcaGetBalancePaymentRequest implements GetBalancePaymentRequestInterface {
	@Getter
	@Setter
	String userID;

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.KLIKBCA;
	}

	@Override
	public String toString() {
		return "KlikBcaGetBalancePaymentRequest{" +
				"userID='" + userID + '\'' +
				'}';
	}
}
