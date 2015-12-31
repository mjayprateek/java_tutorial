package portal;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.text.StrSubstitutor;
import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

import com.ccavenue.security.AesCryptUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.novopay.external.service.merchant.request.CreateWapiOrderRequest;
import in.novopay.external.service.merchant.response.CreateWapiOrderResponse;

public class TestPaymentGateway {

	@Test
	public void test() {
		AesCryptUtil aesUtil = new AesCryptUtil("2E282D2239837C37EE302353B5C2E720");
		String res = aesUtil.decrypt("de5cec7c47a61d92eae68f4ed3c30c14bb13f948bda16"
				+ "f76c322415bf0c69819844165cbd109b62e71b0cd41caecf97e5108827986381a"
				+ "101343885a0be5fd2a5ce1946253fd1184a39a54d60c508be7f5520e6c1948695f68bbb42e1993c69c\n".trim());
		//System.out.println(res);
	}
	
	@Test
	public void testCreateWapiOrderResponse() throws JsonProcessingException {
		String createWapiOrderJsonResStr = "{ \"orderId\":\"${orderId}\", "
				+ "\"orderDate\":\"${orderDate}\", "
				+ "\"orderStatus\":\"${orderStatus}\", "
				+ "\"responseStatus\":\"${responseStatus}\", "
				+ "\"responseCode\":\"230000\", "
				+ "\"responseMsg\":\"Internal Server Error\", "
				+ "\"novopayRefNo\":\"\"}";
		
		Map<String, String> valueMap = new HashMap<String, String>();
		valueMap.put("orderId", "1234");
		valueMap.put("orderDate", "2015-11-30");
		valueMap.put("orderStatus", "FAILURE");
		valueMap.put("responseStatus", "FAILURE");
		createWapiOrderJsonResStr = StrSubstitutor.replace(createWapiOrderJsonResStr, valueMap);
		System.out.println(createWapiOrderJsonResStr);
		
		CreateWapiOrderResponse res = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			res = mapper.readValue(createWapiOrderJsonResStr, CreateWapiOrderResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsonRes = "";
		try {
			jsonRes = mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(jsonRes);
		assertEquals(jsonRes.trim().replaceAll("\\s",""), createWapiOrderJsonResStr.replaceAll("\\s",""));
	}
	
	@Test
	public void testCreateWapiOrderRequest() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		CreateWapiOrderRequest req = new CreateWapiOrderRequest();
		
		req.setOrderId("12345");
		req.setOrderName("orderName");
		req.setOrderDescription("orderDesc");
		req.setOrderDate("2015-11-21 00:00:00");
		req.setAmount("12345");
		req.setCurrency("INR");
		req.setRedirectSuccessUrl("http://localhost:8080/greeting/success");
		req.setRedirectFailureUrl("http://localhost:8080/greeting/failure");
		
		req.setBillingSameAsShipping("FALSE");
		
		req.setBillingAddress1("billingAddress1");
		req.setBillingAddress2("billingAddress2");
		req.setBillingCity("JAIPUR");
		req.setBillingState("RAJASTHAN");
		req.setBillingCountry("INDIA");
		req.setBillingPincode("302001");
		req.setBillingContactno("9123451234");
		req.setBillingEmail("billing@gmail.com");
		req.setBillingName("billingName");
		
		req.setShippingAddress1("shippingAddress1");
		req.setShippingAddress2("shippingAddress2");
		req.setShippingCity("JAIPUR");
		req.setShippingState("RAJASTHAN");
		req.setShippingCountry("INDIA");
		req.setShippingPincode("302001");
		req.setShippingContactno("9123451234");
		req.setShippingEmail("shipping@gmail.com");
		req.setShippingName("shippingName");
		
		req.setMetaData("metaDate");
		req.setOriginOfRequest("metaDate");
		
		System.out.println(mapper.writeValueAsString(req));
	
		String createOrderReqStr = "{\"orderId\":\"12345\",\"orderDate\":\"2015-11-21 00:00:00\","
				+ "\"orderName\":\"orderName\",\"orderDescription\":\"orderDesc\","
				+ "\"amount\":\"12345\",\"currency\":\"INR\","
				+ "\"redirectSuccessUrl\":\"http://localhost:8080/greeting/success\","
				+ "\"redirectFailureUrl\":\"http://localhost:8080/greeting/failure\","
				+ "\"billingName\":\"billingName\",\"billingAddress1\":\"billingAddress1\","
				+ "\"billingAddress2\":\"billingAddress2\",\"billingCity\":\"JAIPUR\","
				+ "\"billingState\":\"RAJASTHAN\",\"billingPincode\":\"302001\",\"billingCountry\":\"INDIA\","
				+ "\"billingContactno\":\"9123451234\",\"billingEmail\":\"billing@gmail.com\","
				+ "\"shippingName\":\"shippingName\",\"shippingAddress1\":\"shippingAddress1\","
				+ "\"shippingAddress2\":\"shippingAddress2\",\"shippingCity\":\"JAIPUR\","
				+ "\"shippingState\":\"RAJASTHAN\",\"shippingPincode\":\"302001\","
				+ "\"shippingCountry\":\"INDIA\",\"shippingContactno\":\"9123451234\","
				+ "\"shippingEmail\":\"shipping@gmail.com\",\"metaData\":\"metaDate\","
				+ "\"originOfRequest\":\"metaDate\"}";
		
		CreateWapiOrderRequest req2 = mapper.readValue(createOrderReqStr, CreateWapiOrderRequest.class);
		System.out.println(mapper.writeValueAsString(req2));
	}
	
	@Test
	public void testUriComponentsBuilder() throws UnsupportedEncodingException {
		UriTemplate uriTemplate = new UriTemplate("http://localhost:8080/greeting/failure?" + "orderId={orderId}&orderDate={orderDate}&orderStatus={orderStatus}"
				+ "&responseStatus={responseStatus}&responseCode={responseCode}"
				+ "&resposneMsg=Internal Server Error&novopayRefNo={novopayRefNo}");
		
		String redirectURI= "https://oauth2-login-demo.appspot.com/code";
		System.out.println(URLEncoder.encode(redirectURI,"UTF-8" ));
		
		
		Map<String, String> valueMap = new HashMap<String, String>();
		valueMap.put("orderId", "12345");
		valueMap.put("orderDate", "2-15-11-21 00:00:00");
		valueMap.put("orderStatus", "FAILURE");
		valueMap.put("responseStatus", "&FAILURE=FAIL");
		valueMap.put("responseCode", "");
		valueMap.put("responseMsg", "Message &= failure");
		valueMap.put("novopayRefNo", "");
		
		System.out.println(uriTemplate.expand(valueMap).toString());
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(uriTemplate.expand(valueMap).toString());
		UriComponents builtUri = builder.buildAndExpand(valueMap);
		
		System.out.println(builtUri.toUriString());
	}
	
	@Test
	public void testISODateTimeformat() {
		String formatAsISODateTime = formatAsISODateTime(new Date());
		System.out.println(formatAsISODateTime);
		
		Date isoDateTime = parseFromISODateTime(formatAsISODateTime);
		System.out.println(formatAsISODateTime(isoDateTime));
		
		isoDateTime = parseFromISODateTime("2015-11-21T00:00:00.123+0530");
		System.out.println(formatAsISODateTime(isoDateTime));
		
	}
	
	public static String formatAsISODateTime(Date date) {
		TimeZone indianTimeZone = TimeZone.getTimeZone("Asia/Calcutta");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		formatter.setTimeZone(indianTimeZone);
		return formatter.format(date);
	}
	
	public static Date parseFromISODateTime(String s) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Date d = new Date();
		try {
			d = formatter.parse(s);
		} catch (ParseException e) {
			return null;
		}

		return d;
	}

}
