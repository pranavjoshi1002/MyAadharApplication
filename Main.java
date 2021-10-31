package main;

import auth_2_0.Auth;
import auth_2_0.AuthRes;
import constants.Constants;
import auth_2_0.AuthResponseDetailsV2;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        OTPAuth OTPAuth = new OTPAuth();
        try {
            OTPAuth.readProperties();
            HelperClass helperClass = new HelperClass(OTPAuth.configProp);
            //999912916662 b232fd59-41f1-4406-a4cf-4911efa17c48
            String uid = "999957413077";
            String txn = "204d4543-e4b2-49ca-b4c6-2a8b131ba93f";
            String otpInRRequest = "474430";
            System.out.println("UID: "+uid+" TxnId: "+txn+" OTP :"+otpInRRequest);
            Auth auth = OTPAuth.createResidentAuth(uid, txn, otpInRRequest, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()), "");
            AuthResponseDetailsV2 data = helperClass.getAuthResponseDetailsV2(auth);

            // Get Auth Response
            AuthRes authRes = data.getAuthRes();
            System.out.println("Auth Response: " + authRes.getRet().toString());
            if (authRes.getErr() != null)
            System.out.println("ErrorCode: "+authRes.getErr());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
