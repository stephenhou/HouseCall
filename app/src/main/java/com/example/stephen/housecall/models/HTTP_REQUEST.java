package com.example.stephen.housecall.models;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

/**
 * Created by Yi on 7/11/2016.
 */
public class HTTP_REQUEST {


    public HTTP_REQUEST(){

    }

//    public static String excutePost(String targetURL, String urlParameters) {
//        HttpURLConnection connection = null;
//        Authenticator.setDefault (new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("92826306-0970-45ee-9fe1-aaf4416cf421-bluemix", "be907baca4095366d8f7d6dc28d6ce5180d1b1e51b36231152dc4deeba21550d".toCharArray());
//            }
//        });
//        try {
//            //Create connection
//            URL url = new URL(targetURL);
//            connection = (HttpURLConnection)url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded");
//
//            connection.setRequestProperty("Content-Length",
//                    Integer.toString(urlParameters.getBytes().length));
//            connection.setRequestProperty("Content-Language", "en-US");
//
//            connection.setUseCaches(false);
//            connection.setDoOutput(true);
//
//            //Send request
//            DataOutputStream wr = new DataOutputStream(
//                    connection.getOutputStream());
//            wr.writeBytes(urlParameters);
//            wr.close();
//
//            //Get Response
//            InputStream is = connection.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//            StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+
//            String line;
//            while((line = rd.readLine()) != null) {
//                response.append(line);
//               // response.append('\r');
//            }
//            rd.close();
//            return response.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if(connection != null) {
//                connection.disconnect();
//            }
//        }
//    }

    public static String excuteGet(String targetURL) {
        HttpURLConnection connection = null;
        Authenticator.setDefault (new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("92826306-0970-45ee-9fe1-aaf4416cf421-bluemix", "be907baca4095366d8f7d6dc28d6ce5180d1b1e51b36231152dc4deeba21550d".toCharArray());
            }
        });
        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoOutput(true);




            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+
            String line;
            while((line = rd.readLine()) != null) {
                response.append(line);
                //response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }
}
