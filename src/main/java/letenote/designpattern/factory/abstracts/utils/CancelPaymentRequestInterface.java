package letenote.designpattern.factory.abstracts.utils;

public interface CancelPaymentRequestInterface {
	String getPaymentID();
	void setPaymentID(String paymentID);
	PaymentMethodType getPaymentMethod();
}
