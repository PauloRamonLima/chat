package br.com.softmind.sugarbr.util;

import com.mercadopago.*;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;


public class IntegracaoMercadoPago {

	      public static void main(String[] args)throws MPException, MPConfException {

	          MercadoPago.SDK.setClientSecret(System.getenv("CLIENT_SECRET_OK"));
	          MercadoPago.SDK.setClientId(System.getenv("CLIENT_ID_OK"));

	          Payment payment = new Payment()
	                  .setTransactionAmount(100f)
	                  .setToken("your_cardtoken")
	                  .setDescription("description")
	                  .setInstallments(1)
	                  .setPaymentMethodId("visa")
	                  .setPayer(new Payer()
	                          .setEmail("dummy_email"));

	          payment.save();

	          System.out.println(payment.getStatus());

	      }
}
