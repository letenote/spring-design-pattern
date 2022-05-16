package letenote.designpattern.factory.abstracts.utils;

public interface PaymentFactoryInterface {
	ChargePaymentRequestInterface createChargeRequest();
	CancelPaymentRequestInterface createCancelRequest();
	GetBalancePaymentRequestInterface createGetBalanceRequest();
}
