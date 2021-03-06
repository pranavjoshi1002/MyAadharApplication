package in.gov.uidai.otpapiclient;

import in.gov.uidai.otpapiclient.model.OtpRes;

import java.util.Scanner;
import java.util.UUID;

public class OtpAPIClientMain {

    public static void main(String[] args) throws Exception {
        OtpAPIService otpAPIService = new OtpAPIService();
        otpAPIService.readProperties();
        String txnId = UUID.randomUUID().toString();
        System.out.println("Printing txnId: " + txnId);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter UID");
        String uid = scanner.nextLine();
        OtpRes otpRes = otpAPIService.getOtpRes(uid,txnId);
        System.out.println(uid +  " " + txnId);
        System.out.println("Result : " + otpRes.getRet().value() + ", err: " + otpRes.getErr());
    }

}

//999957413077  stage UID
