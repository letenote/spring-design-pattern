package letenote.designpattern.factory.abstracts;

import letenote.designpattern.factory.abstracts.OVO.OvoCancelPaymentRequest;
import letenote.designpattern.factory.abstracts.OVO.OvoChargePaymentRequest;
import letenote.designpattern.factory.abstracts.OVO.OvoGetBalancePaymentRequest;
import letenote.designpattern.factory.abstracts.utils.CancelPaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.ChargePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.GetBalancePaymentRequestInterface;
import letenote.designpattern.factory.abstracts.utils.PaymentFactoryInterface;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OvoPaymentFactory implements PaymentFactoryInterface {
	@Override
	public ChargePaymentRequestInterface createChargeRequest() {return new OvoChargePaymentRequest();}
	@Override
	public CancelPaymentRequestInterface createCancelRequest() {return new OvoCancelPaymentRequest();}
	@Override
	public GetBalancePaymentRequestInterface createGetBalanceRequest() {return new OvoGetBalancePaymentRequest();}
}
