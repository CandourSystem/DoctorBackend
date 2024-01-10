package org.cs.jwt.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Rabindra NAth
 * 
 * 
 */

@Service
public class ZipCodeServices {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://api.postalpincode.in/pincode/";

    public String sendOtpSMS(final String zipcode) throws Exception {
        StringBuffer response = new StringBuffer();
        logger.info("QMSSMSServices :: sendOtpSMS");
        URL obj = new URL(GET_URL+"/"+zipcode);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
          

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println(response.toString());
        return response.toString();
    }

}