package letenote.designpattern.factory.abstracts.OVO;

import letenote.designpattern.factory.abstracts.utils.GetBalancePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
public class OvoGetBalancePaymentRequest implements GetBalancePaymentRequestInterface {
	@Getter
	@Setter
	String userID;

	@Override
	public PaymentMethodType getPaymentMethod() {
		return PaymentMethodType.OVO;
	}

	@Override
	public String toString() {
		return "OvoGetBalancePaymentRequest{" +
				"userID='" + userID + '\'' +
				'}';
	}
}
