package com.bhanu.workbook.crypto;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacUtils;

@Slf4j
public class HMACAlgo {

  private static String WM_CONSUMER_ID_VALUE = "a266360f-4da0-4496-938d-c2d214f15b53";
  private static String WM_SVC_NAME_VALUE = "ASDAODSFORUKIL";
  private static String WM_SVC_ENV_VALUE = "TEST";


  private static String WM_CONSUMER_ID_KEY = "WM_CONSUMER.ID";
  private static String WM_SVC_NAME_KEY = "WM_SVC.NAME";
  private static String WM_SVC_ENV_KEY = "WM_SVC.ENV";
  private static String WM_CONSUMER_INTIMESTAMP_KEY = "WM_CONSUMER.INTIMESTAMP";


  private static String secreteKey = "CommsmartServicesKey2021@v87vIXsMB8q=&$0";

  private static String ENCRYPTION_METHOD = "HmacSHA512";

  public static void main(String[] arg) throws NoSuchAlgorithmException {

//    KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA512");
//    keyGen.init(512, new SecureRandom());
//    SecretKey secretKey = keyGen.generateKey();
//    String key =  Base64.encodeBase64String(secretKey.getEncoded());
//    System.out.println("Key:" + key);

    long epochMilli = getEpochMilli();

    String payload = MessageFormat.format("{0}:{1};{2}:{3};{4}:{5};{6}:{7}", WM_CONSUMER_ID_KEY, WM_CONSUMER_ID_VALUE,
        WM_SVC_NAME_KEY, WM_SVC_NAME_VALUE,
        WM_SVC_ENV_KEY, WM_SVC_ENV_VALUE,
        WM_CONSUMER_INTIMESTAMP_KEY, String.valueOf(epochMilli));

    final String signature = encode(secreteKey, payload);

    System.out.println("Signature: " + signature);
    System.out.println("epoch: " + epochMilli);
    System.out.println();
    String ukilPayload = MessageFormat.format("{0}:{1};{2}:{3};{4}:{5};{6}:{7}", WM_CONSUMER_ID_KEY,
        "6e1051f0-019d-4317-a69d-964c80adce64",
        WM_SVC_NAME_KEY, "ASDA-ODS",
        WM_SVC_ENV_KEY, "PQA",
        WM_CONSUMER_INTIMESTAMP_KEY, "1645622179688");

    final String signatureUkil =
        encode("tik6g/f6qm3lKy6C1IbZHV3QuyMMBJyvqEaC9OWH8Q1JLV29+d6nCppl1yo2PFf89D3U2nLrR+wSAIBQhz9q5A==", ukilPayload);
    System.out.println("signature Ukil: " + signatureUkil);

    System.out.println("UKIL Signature validation: " + signatureUkil.equals(
        "4S3q7qJtehX+00q8mgfEM2HGdN937ijFJ+MX5EdM6B+NECCOlmle7SMxldPZU8O28EP5dRhHwT7rAlYTFNTL3A=="));
  }


  static String encode(String key, String message) {
    try {
      Mac sha512HMAC = HmacUtils.getInitializedMac(ENCRYPTION_METHOD, key.getBytes(StandardCharsets.UTF_8));
      return Base64.getEncoder().encodeToString(sha512HMAC.doFinal(message.getBytes(StandardCharsets.UTF_8)));
    } catch (Exception e) {
      log.warn(
          "Not able to Encrypt exception :", e);
      return null;
    }
  }

  static long getEpochMilli() {
    return LocalDateTime.now()
        .atZone(ZoneId.of("Europe/London"))
        .toInstant()
        .toEpochMilli();
  }
}