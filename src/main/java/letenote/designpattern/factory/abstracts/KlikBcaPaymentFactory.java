package letenote.designpattern.factory.abstracts;

import letenote.designpattern.factory.abstracts.KLIKBCA.KlikBcaCancelPaymentRequest;
import letenote.designpattern.factory.abstracts.KLIKBCA.KlikBcaChargePaymentRequest;
import letenote.designpattern.factory.abstracts.KLIKBCA.KlikBcaGetBalancePaymentRequest;
import letenote.designpattern.factory.abstracts.utils.CancelPaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.ChargePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.GetBalancePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentFactoryInterface;
import org.springframework.context.annotation.Configuration;
@Configuration
public class KlikBcaPaymentFactory implements PaymentFactoryInterface {
	@Override
	public ChargePaymentRequestInterface createChargeRequest() {
		return new KlikBcaChargePaymentRequest();
	}
	@Override
	public CancelPaymentRequestInterface createCancelRequest() {
		return new KlikBcaCancelPaymentRequest();
	}
	@Override
	public GetBalancePaymentRequestInterface createGetBalanceRequest() {
		return new KlikBcaGetBalancePaymentRequest();
	}
}
