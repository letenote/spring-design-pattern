package letenote.designpattern.factory.abstracts.utils;
public interface ChargePaymentRequestInterface {
	String getPaymentID();
	void setPaymentID(String paymentID);
	Long getAmount();
	void setAmount(Long amount);
	Long getFee();
	PaymentMethodType getPaymentMethod();
}
