
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rifat
 */
public class HttpPost {
    public static void main (String args[]) throws IOException{
        URL url = new URL("https://jsonplaceholder.typicode.com/posts");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Chrome");
        con.setDoOutput(true);
        String message = "Yaay!! Ican post Something in this message";
        OutputStream output = con.getOutputStream();
        output.write(message.getBytes());
        output.flush();
        output.close();
        
        
        int responseCode = con.getResponseCode();
        System.out.println("Respose Code: " + responseCode);
        System.out.println("Respose Message: " +con.getResponseMessage());
        
        if(responseCode == HttpURLConnection.HTTP_CREATED){
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
