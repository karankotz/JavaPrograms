/* A Simple Java Program to extract the contents of the Web Page Source Code
Date Created : 3/13/2018
Author: Karan Kotabagi
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws IOException {
        //Declare the URL
        URL weburl = new URL("https://www.facebook.com");
        //Open the connection to the weburl
        URLConnection con = weburl.openConnection();
        //Start the input stream
        InputStream in = con.getInputStream();
        //Get the encoding via getEncoding() method
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        //Create the bytestreamobject
        ByteArrayOutputStream bytestreamobject = new ByteArrayOutputStream();
        //create the buffer buf of the type byte
        byte[] buf = new byte[8192];
        //set the len to 0
        int len = 0;
        //write from the inputstream to the buffer
        while ((len = in.read(buf)) != -1) {
            bytestreamobject.write(buf, 0, len);
        }
        //Assign the resulting string to the body
        String body = new String(bytestreamobject.toByteArray(), encoding);
        System.out.println(body);
    }

}
