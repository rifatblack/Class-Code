/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rifat
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class HttpGet {
    public static void main (String args[]) throws IOException{
        URL url = new URL("http://webcode.me/");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Chrome");
        int responseCode = con.getResponseCode();
        System.out.println("Respose Code: " + responseCode);
        System.out.println("Respose Message: " +con.getResponseMessage());
        
        if(responseCode == HttpURLConnection.HTTP_OK){
            InputStreamReader in = new InputStreamReader(con.getInputStream());
            BufferedReader read = new BufferedReader(in);
            String str = null;
            StringBuffer response = new StringBuffer();
            while((str = read.readLine()) !=null){
                System.out.println(str);
            }
            System.out.println(response);
        }
            else{
             System.out.println("Get method Not worked" );
        }
        
    }
    
}
