package letenote.designpattern.factory.abstracts.utils;

public interface GetBalancePaymentRequestInterface {
	String getUserID();
	void setUserID(String userID);
	PaymentMethodType getPaymentMethod();
}
